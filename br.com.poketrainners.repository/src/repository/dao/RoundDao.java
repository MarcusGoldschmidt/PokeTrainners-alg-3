/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import domain.entities.Round;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcus
 */
public class RoundDao extends BaseDao<Round> {

    private final String TableName = "player";
    private final String TablePk = TableName + "Id";

    public RoundDao() {
        super(Round.class);
    }

    @Override
    public ArrayList<Round> Index() {
        String sql = "SELECT * FROM " + TableName;
        try {
            ArrayList<Round> rounds = new ArrayList<>();
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Round round;

            while (rs.next()) {
                round = new Round();

                round.setRoundId(rs.getInt(TablePk));
                round.setBattleId(rs.getInt("BattleId"));
                round.setMessage(rs.getString("Message"));
                round.setAtributeComparable(rs.getString("AtributeComparable"));
                round.setValueOne(rs.getString("ValueOne"));
                round.setValueTwo(rs.getString("ValueTwo"));
                round.setPlayerWinnerId(rs.getInt("PlayerWinnerId"));
            }

            return rounds;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Round Show(int id) {
        String sql = "SELECT * FROM " + TableName + " WHERE " + TablePk + " = " + id;
        try {
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Round round = new Round();

            round.setRoundId(rs.getInt(TablePk));
            round.setBattleId(rs.getInt("BattleId"));
            round.setMessage(rs.getString("Message"));
            round.setAtributeComparable(rs.getString("AtributeComparable"));
            round.setValueOne(rs.getString("ValueOne"));
            round.setValueTwo(rs.getString("ValueTwo"));
            round.setPlayerWinnerId(rs.getInt("PlayerWinnerId"));

            return round;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean Store(Round data) {
        String sql = "INSERT INTO " + TableName + " (Message,AtributeComparable,ValueOne,ValueTwo,PlayerWinnerId) values (?,?,?,?,?)";
        try {

            PreparedStatement ptst = this.connect.prepareStatement(sql);

            ptst.setString(1, data.getMessage());
            ptst.setString(2, data.getAtributeComparable());
            ptst.setString(3, data.getValueOne());
            ptst.setString(4, data.getValueTwo());
            ptst.setInt(5, data.getPlayerWinnerId());

            ptst.execute();
            ptst.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean Update(Round data) {
        String sql = " UPDATE " + TableName + " set Message=?, AtributeComparable=?,ValueOne=?, ValueTwo=?, PlayerWinnerId=? "
                + " WHERE " + TablePk + " = " + data.getBattleId();

        try {
            PreparedStatement ptst = this.connect.prepareStatement(sql);

            ptst.setString(1, data.getMessage());
            ptst.setString(2, data.getAtributeComparable());
            ptst.setString(3, data.getValueOne());
            ptst.setString(4, data.getValueTwo());
            ptst.setInt(5, data.getPlayerWinnerId());
            ptst.execute();
            ptst.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean Delete(int id) {
        String sql = "DELETE FROM " + TableName + " WHERE " + TablePk + " = " + id;

        try {
            PreparedStatement ptst = this.connect.prepareStatement(sql);

            boolean deletou = ptst.execute();
            ptst.close();
            return deletou;
        } catch (SQLException e) {
            return false;
        }
    }

}
