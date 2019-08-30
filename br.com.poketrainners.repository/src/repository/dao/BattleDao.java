/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import domain.entities.Battle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcus
 */
public class BattleDao extends BaseDao<Battle> {

    private final String TableName = "Battle";
    private final String TablePk = TableName + "Id";

    public BattleDao() {
        super(Battle.class);
    }

    @Override
    public ArrayList<Battle> Index() {
        String sql = "SELECT * FROM " + TableName;
        try {
            ArrayList<Battle> battles = new ArrayList<>();
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Battle battle;

            while (rs.next()) {
                battle = new Battle();

                battle.setBattleId(rs.getInt(TablePk));
                battle.setPlayerOneId(rs.getInt("PlayerOneId"));
                battle.setPlayerTwoId(rs.getInt("PlayerTwoId"));

                battles.add(battle);
            }

            return battles;
        } catch (SQLException e) {
            return null;
        }

    }

    @Override
    public Battle Show(int id) {
        String sql = "SELECT * FROM " + TableName + " WHERE " + TablePk + " = " + id;
        try {
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Battle battle;
            battle = new Battle();

            battle.setBattleId(rs.getInt(TablePk));
            battle.setPlayerOneId(rs.getInt("PlayerOneId"));
            battle.setPlayerTwoId(rs.getInt("PlayerTwoId"));

            return battle;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean Store(Battle data) {
        String sql = "INSERT INTO " + TableName + " (PlayerOneId, PlayerTwoId) values (?,?)";
        try {

            PreparedStatement ptst = this.connect.prepareStatement(sql);

            ptst.setInt(1, data.getPlayerOneId());
            ptst.setInt(2, data.getPlayerTwoId());

            ptst.execute();
            ptst.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean Update(Battle data) {
        String sql = " UPDATE " + TableName + " set PlayerOneId=?, PlayerTwoId=?, Status=?,PlayerWinnerId=?"
                + " WHERE " + TablePk + " = " + data.getBattleId();

        try {
            PreparedStatement ptst = this.connect.prepareStatement(sql);

            ptst.setInt(1, data.getPlayerOneId());
            ptst.setInt(2, data.getPlayerTwoId());
            ptst.setInt(3, data.getStatus().ordinal());
            ptst.setInt(4, data.getPlayerWinnerId());

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
