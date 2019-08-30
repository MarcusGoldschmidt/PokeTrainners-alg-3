/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.dao;

import domain.entities.Pokemon;
import domain.entities.PokemonCathed;
import domain.entities.enuns.Type;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marcus
 */
public class PokemonCathedDao extends BaseDao<PokemonCathed> {

    private final String TableName = "Pokemon";
    private final String TablePk = TableName + "Id";

    public PokemonCathedDao() {
        super(PokemonCathed.class);
    }

    @Override
    public ArrayList<PokemonCathed> Index() {
        String sql = "SELECT * FROM " + TableName;
        try {
            ArrayList<PokemonCathed> pokemonCatheds = new ArrayList<>();
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            PokemonCathed pokemonCathed;

            while (rs.next()) {
                pokemonCathed = new PokemonCathed();

                pokemonCathed.setPokemonCathedId(rs.getInt(TablePk));
                pokemonCathed.setPlayerId(rs.getInt("PlayerId"));
                pokemonCathed.setPlayerId(rs.getInt("PokemonBagId"));

                pokemonCathed.setCreatedAt(rs.getDate("CreatedAt"));

                pokemonCathed.setPokemon(new Pokemon());

                pokemonCathed.getPokemon().setName(rs.getString("Name"));
                pokemonCathed.getPokemon().setDescription(rs.getString("Description"));

                pokemonCathed.getPokemon().setLevel(rs.getInt("Level"));
                pokemonCathed.getPokemon().setCurrentXp(rs.getInt("CurrentXp"));
                pokemonCathed.getPokemon().setXpToNextLevel(rs.getInt("XpToNextLevel"));

                pokemonCathed.getPokemon().setMaxHp(rs.getInt("MaxHp"));
                pokemonCathed.getPokemon().setCurrentHp(rs.getInt("CurrentHp"));

                pokemonCathed.getPokemon().setAttack(rs.getInt("Attack"));
                pokemonCathed.getPokemon().setSpAtk(rs.getInt("SpAtk"));
                pokemonCathed.getPokemon().setSpDef(rs.getInt("SpDef"));
                pokemonCathed.getPokemon().setSpeed(rs.getInt("Speed"));

                pokemonCathed.getPokemon().setDefenseToCath(rs.getInt("DefenseToCath"));

                pokemonCathed.getPokemon().setType1(Type.valueOf(rs.getString("Type1")));
                pokemonCathed.getPokemon().setType1(Type.valueOf(rs.getString("Type2")));

                pokemonCatheds.add(pokemonCathed);
            }

            return pokemonCatheds;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public PokemonCathed Show(int id) {
        String sql = "SELECT * FROM " + TableName + " WHERE " + TablePk + " =  " + id;
        try {
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            PokemonCathed pokemonCathed = new PokemonCathed();

            pokemonCathed.setPokemonCathedId(rs.getInt(TablePk));
            pokemonCathed.setPlayerId(rs.getInt("PlayerId"));
            pokemonCathed.setPlayerId(rs.getInt("PokemonBagId"));

            pokemonCathed.setCreatedAt(rs.getDate("CreatedAt"));

            pokemonCathed.setPokemon(new Pokemon());

            pokemonCathed.getPokemon().setName(rs.getString("Name"));
            pokemonCathed.getPokemon().setDescription(rs.getString("Description"));

            pokemonCathed.getPokemon().setLevel(rs.getInt("Level"));
            pokemonCathed.getPokemon().setCurrentXp(rs.getInt("CurrentXp"));
            pokemonCathed.getPokemon().setXpToNextLevel(rs.getInt("XpToNextLevel"));

            pokemonCathed.getPokemon().setMaxHp(rs.getInt("MaxHp"));
            pokemonCathed.getPokemon().setCurrentHp(rs.getInt("CurrentHp"));

            pokemonCathed.getPokemon().setAttack(rs.getInt("Attack"));
            pokemonCathed.getPokemon().setSpAtk(rs.getInt("SpAtk"));
            pokemonCathed.getPokemon().setSpDef(rs.getInt("SpDef"));
            pokemonCathed.getPokemon().setSpeed(rs.getInt("Speed"));

            pokemonCathed.getPokemon().setDefenseToCath(rs.getInt("DefenseToCath"));

            pokemonCathed.getPokemon().setType1(Type.valueOf(rs.getString("Type1")));
            pokemonCathed.getPokemon().setType1(Type.valueOf(rs.getString("Type2")));

            return pokemonCathed;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public boolean Store(PokemonCathed data) {
        String sql = "INSERT INTO " + TableName + " (PlayerId,Name,Description,Level,CurrentXp,XpToNextLevel,MaxHp,CurrentHp,Attack,SpAtk,SpDef,Speed, DefenseToCath, Type1,Type2,PokemonBagId,CreatedAt) values"
                + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ptst = this.connect.prepareStatement(sql);

            ptst.setInt(1, data.getPlayerId());
            ptst.setString(2, data.getPokemon().getName());
            ptst.setString(3, data.getPokemon().getDescription());

            ptst.setInt(4, data.getPokemon().getLevel());
            ptst.setInt(5, data.getPokemon().getCurrentXp());
            ptst.setInt(6, data.getPokemon().getXpToNextLevel());

            ptst.setInt(7, data.getPokemon().getMaxHp());
            ptst.setInt(8, data.getPokemon().getCurrentHp());

            ptst.setInt(9, data.getPokemon().getAttack());
            ptst.setInt(10, data.getPokemon().getSpAtk());
            ptst.setInt(11, data.getPokemon().getSpDef());
            ptst.setInt(12, data.getPokemon().getSpeed());

            ptst.setInt(13, data.getPokemon().getDefenseToCath());
            ptst.setString(14, data.getPokemon().getType1().toString());
            ptst.setString(15, data.getPokemon().getType2().toString());
            ptst.setInt(16, data.getPokemonBagId());
            ptst.setDate(17, new Date(System.currentTimeMillis()));

            ptst.execute();
            ptst.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean Update(PokemonCathed data) {
        String sql = " UPDATE " + TableName + " SET Level=?, CurrentXp=?, XpToNextLevel=?,MaxHp=?,CurrentHp=?,Attack=?,SpAtk=?,SpDef=?,Speed=?,DefenseToCath=?,PokemonBagId=?"
                + " WHERE " + TablePk + " = " + data.getPokemonCathedId();

        try {
            PreparedStatement ptst = this.connect.prepareStatement(sql);
            ptst.setInt(1, data.getPokemon().getLevel());
            ptst.setInt(2, data.getPokemon().getCurrentXp());
            ptst.setInt(3, data.getPokemon().getXpToNextLevel());

            ptst.setInt(4, data.getPokemon().getMaxHp());
            ptst.setInt(5, data.getPokemon().getCurrentHp());

            ptst.setInt(6, data.getPokemon().getAttack());
            ptst.setInt(7, data.getPokemon().getSpAtk());
            ptst.setInt(8, data.getPokemon().getSpDef());
            ptst.setInt(9, data.getPokemon().getSpeed());

            ptst.setInt(10, data.getPokemon().getDefenseToCath());
            
            ptst.setInt(11, data.getPokemonBagId());

            ptst.execute();
            ptst.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean Delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
