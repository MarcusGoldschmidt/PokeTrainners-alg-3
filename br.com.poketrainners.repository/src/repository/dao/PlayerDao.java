/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import domain.entities.Player;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcus
 */
public class PlayerDao extends BaseDao<Player> {

    private final String TableName = "player";
    private final String TablePk = TableName + "Id";

    public PlayerDao() {
        super(Player.class);
    }

    @Override
    public List<Player> Index() {
        String sql = "SELECT * FROM " + TableName;
        try {
            List<Player> players = new ArrayList<>();
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Player player;

            while (rs.next()) {
                player = new Player();

                player.setPlayerId(rs.getInt(TablePk));
                player.setName(rs.getString("Nome"));
                player.setPontuacao(rs.getDouble("Pontuacao"));
                player.setLevel(rs.getInt("Level"));
                player.setMoney(rs.getDouble("Money"));
                players.add(player);
            }

            return players;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Player Show(int id) {
        String sql = "SELECT * FROM " + TableName + " WHERE " + TablePk + " = " + id;
        try {
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            Player player = new Player();

            player.setPlayerId(rs.getInt(TablePk));
            player.setName(rs.getString("Nome"));
            player.setPontuacao(rs.getDouble("Pontuacao"));
            player.setLevel(rs.getInt("Level"));
            player.setMoney(rs.getDouble("Money"));

            return player;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean Store(Player data) {
        String sql = "INSERT INTO " + TableName + " (Name,Pontuacao,Level,Money) values (?,?,?,?)";
        try {
            PreparedStatement ptst = this.connect.prepareStatement(sql);

            ptst.setInt(1, data.getPlayerId());
            ptst.setDouble(2, data.getPontuacao());
            ptst.setInt(3, data.getLevel());
            ptst.setDouble(4, data.getMoney());

            ptst.execute();
            ptst.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean Update(Player data) {
        String sql = " UPDATE " + TableName + " set Name=?, Pontuacao=?,Level=?, Money=? "
                + " WHERE " + TablePk + " = " + data.getPlayerId();

        try {
            PreparedStatement ptst = this.connect.prepareStatement(sql);

            ptst.setString(1, data.getName());
            ptst.setDouble(2, data.getPontuacao());
            ptst.setInt(3, data.getLevel());
            ptst.setDouble(4, data.getMoney());

            ptst.execute();
            ptst.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

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
