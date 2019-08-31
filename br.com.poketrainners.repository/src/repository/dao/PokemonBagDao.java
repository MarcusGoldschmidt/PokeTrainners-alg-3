/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import domain.entities.PokemonBag;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcus
 */
public class PokemonBagDao extends BaseDao<PokemonBag> {

    private final String TableName = "pokemonBag";
    private final String TablePk = TableName + "Id";

    public PokemonBagDao() {
        super(PokemonBag.class);
    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<PokemonBag> Index() {
        String sql = " SELECT * FROM " + TableName;
        try {
            ArrayList<PokemonBag> bags = new ArrayList<>();
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            PokemonBag bag;

            while (rs.next()) {
                bag = new PokemonBag(6);

                bag.setBagId(rs.getInt(TablePk));
                bag.setMaxSize(rs.getInt("MaxSize"));
                bag.setPlayerId(rs.getInt("PlayerId"));
                bags.add(bag);
            }

            return bags;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public PokemonBag Show(int id) {
        String sql = " SELECT * FROM " + TableName;
        try {
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            PokemonBag bag = new PokemonBag(6);

            bag.setBagId(rs.getInt(TablePk));
            bag.setMaxSize(rs.getInt("MaxSize"));
            bag.setPlayerId(rs.getInt("PlayerId"));

            return bag;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean Store(PokemonBag data) {
        String sql = " INSERT INTO " + TableName + " (MaxSize,PlayerId) values (?,?)";
        try {

            PreparedStatement ptst = this.connect.prepareStatement(sql);

            ptst.setInt(1, data.getMaxSize());
            ptst.setDouble(2, data.getPlayerId());

            ptst.execute();
            ptst.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean Update(PokemonBag data) {
        String sql = " UPDATE " + TableName + " set MaxSize=?, PlayerId=? "
                + " WHERE " + TablePk + " = " + data.getPlayerId();

        try {
            PreparedStatement ptst = this.connect.prepareStatement(sql);
            
            ptst.setInt(1, data.getMaxSize());
            ptst.setDouble(2, data.getPlayerId());
            ptst.execute();
            ptst.close();
            return true;
            
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean Delete(int id) {
        String sql = " DELETE FROM " + TableName + " WHERE " + TablePk + " = " + id;

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
