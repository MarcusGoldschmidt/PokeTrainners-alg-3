/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

import java.util.Date;

/**
 *
 * @author marcus
 */
public class PokemonCathed {
    
    private int             PokemonCathedId;
    
    private int             PlayerId;
    private Player          Player;
    
    private Pokemon         Pokemon;
    
    private int             PokemonBagId;
    private PokemonBag      PokemonBag;
    
    private Date            CreatedAt;

    public int getPokemonCathedId() {
        return PokemonCathedId;
    }

    public void setPokemonCathedId(int PokemonCathedId) {
        this.PokemonCathedId = PokemonCathedId;
    }

    public int getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(int PlayerId) {
        this.PlayerId = PlayerId;
    }

    public Player getPlayer() {
        return Player;
    }

    public void setPlayer(Player Player) {
        this.Player = Player;
    }

    public Pokemon getPokemon() {
        return Pokemon;
    }

    public void setPokemon(Pokemon Pokemon) {
        this.Pokemon = Pokemon;
    }

    public int getPokemonBagId() {
        return PokemonBagId;
    }

    public void setPokemonBagId(int PokemonBagId) {
        this.PokemonBagId = PokemonBagId;
    }

    public PokemonBag getPokemonBag() {
        return PokemonBag;
    }

    public void setPokemonBag(PokemonBag PokemonBag) {
        this.PokemonBag = PokemonBag;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }
    
    
}
