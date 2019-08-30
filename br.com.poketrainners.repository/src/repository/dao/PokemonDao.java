/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import domain.entities.Pokemon;
import domain.entities.enuns.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcus
 */
public class PokemonDao extends BaseDao<Pokemon> {

    private final String TableName = "Pokemon";
    private final String TablePk = TableName + "Id";

    public PokemonDao() {
        super(Pokemon.class);
    }

    @Override
    public ArrayList<Pokemon> Index() {
        String sql = "SELECT * FROM " + TableName;
        try {
            ArrayList<Pokemon> pokemons = new ArrayList<>();
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Pokemon pokemon;

            while (rs.next()) {
                pokemon = new Pokemon();

                pokemon.setPokemonId(rs.getInt(TablePk));

                pokemon.setPlayerOwnerId(rs.getInt("PlayerOwnerId"));

                pokemon.setName(rs.getString("Name"));
                pokemon.setDescription(rs.getString("Description"));

                pokemon.setLevel(rs.getInt("Level"));
                pokemon.setCurrentXp(rs.getInt("CurrentXp"));
                pokemon.setXpToNextLevel(rs.getInt("XpToNextLevel"));

                pokemon.setMaxHp(rs.getInt("MaxHp"));
                pokemon.setCurrentHp(rs.getInt("CurrentHp"));

                pokemon.setAttack(rs.getInt("Attack"));
                pokemon.setSpAtk(rs.getInt("SpAtk"));
                pokemon.setSpDef(rs.getInt("SpDef"));
                pokemon.setSpeed(rs.getInt("Speed"));

                pokemon.setDefenseToCath(rs.getInt("DefenseToCath"));

                pokemon.setType1(Type.valueOf(rs.getString("Type1")));
                pokemon.setType1(Type.valueOf(rs.getString("Type2")));

                pokemons.add(pokemon);
            }

            return pokemons;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public Pokemon Show(int id) {
        String sql = "SELECT * FROM " + TableName + " WHERE " + TablePk + " = " + id;
        try {
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            Pokemon pokemon = new Pokemon();

            pokemon.setPokemonId(rs.getInt(TablePk));

            pokemon.setPlayerOwnerId(rs.getInt("PlayerOwnerId"));

            pokemon.setName(rs.getString("Name"));
            pokemon.setDescription(rs.getString("Description"));

            pokemon.setLevel(rs.getInt("Level"));
            pokemon.setCurrentXp(rs.getInt("CurrentXp"));
            pokemon.setXpToNextLevel(rs.getInt("XpToNextLevel"));

            pokemon.setMaxHp(rs.getInt("MaxHp"));
            pokemon.setCurrentHp(rs.getInt("CurrentHp"));

            pokemon.setAttack(rs.getInt("Attack"));
            pokemon.setSpAtk(rs.getInt("SpAtk"));
            pokemon.setSpDef(rs.getInt("SpDef"));
            pokemon.setSpeed(rs.getInt("Speed"));

            pokemon.setDefenseToCath(rs.getInt("DefenseToCath"));

            pokemon.setType1(Type.valueOf(rs.getString("Type1")));
            pokemon.setType1(Type.valueOf(rs.getString("Type2")));

            return pokemon;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean Store(Pokemon data) {
        String sql = "INSERT INTO " + TableName + " (PlayerOwnerId,Name,Description,Level,CurrentXp,XpToNextLevel,MaxHp,CurrentHp,Attack,SpAtk,SpDef,Speed, DefenseToCath, Type1,Type2) values"
                + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ptst = this.connect.prepareStatement(sql);

            ptst.setInt(1, data.getPlayerOwnerId());
            ptst.setString(2, data.getName());
            ptst.setString(3, data.getDescription());

            ptst.setInt(4, data.getLevel());
            ptst.setInt(5, data.getCurrentXp());
            ptst.setInt(6, data.getXpToNextLevel());

            ptst.setInt(7, data.getMaxHp());
            ptst.setInt(8, data.getCurrentHp());

            ptst.setInt(9, data.getAttack());
            ptst.setInt(10, data.getSpAtk());
            ptst.setInt(11, data.getSpDef());
            ptst.setInt(12, data.getSpeed());

            ptst.setInt(13, data.getDefenseToCath());
            ptst.setString(14, data.getType1().toString());
            ptst.setString(15, data.getType2().toString());

            ptst.execute();
            ptst.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean Update(Pokemon data) {
        String sql = " UPDATE " + TableName + " set PlayerOwnerId=?, Name=?, Description=?, Level=?, CurrentXp=?, XpToNextLevel=?,MaxHp=?,CurrentHp=?,Attack=?,SpAtk=?,SpDef=?,Speed=?,DefenseToCath=?,Type1=?,Type2=?"
                + " WHERE " + TablePk + " = " + data.getPokemonId();

        try {
            PreparedStatement ptst = this.connect.prepareStatement(sql);

            ptst.setInt(1, data.getPlayerOwnerId());
            ptst.setString(2, data.getName());
            ptst.setString(3, data.getDescription());

            ptst.setInt(4, data.getLevel());
            ptst.setInt(5, data.getCurrentXp());
            ptst.setInt(6, data.getXpToNextLevel());

            ptst.setInt(7, data.getMaxHp());
            ptst.setInt(8, data.getCurrentHp());

            ptst.setInt(9, data.getAttack());
            ptst.setInt(10, data.getSpAtk());
            ptst.setInt(11, data.getSpDef());
            ptst.setInt(12, data.getSpeed());

            ptst.setInt(13, data.getDefenseToCath());
            ptst.setString(14, data.getType1().toString());
            ptst.setString(15, data.getType2().toString());

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
