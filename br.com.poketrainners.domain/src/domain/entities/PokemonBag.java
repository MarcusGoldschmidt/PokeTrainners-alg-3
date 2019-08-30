/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

import java.util.List;

/**
 *
 * @author marcus
 * Type
 * @param <T>
 */
public class PokemonBag {
    protected int           BagId;
    
    protected int           MaxSize;
    
    protected int           PlayerId;
    protected Player        Player;
    
    protected List<Pokemon> Pokemons;

    public PokemonBag(int maxSize) {
        this.MaxSize = maxSize;
    }

    public int getBagId() {
        return BagId;
    }

    public void setBagId(int BagId) {
        this.BagId = BagId;
    }

    public int getMaxSize() {
        return MaxSize;
    }

    public void setMaxSize(int MaxSize) {
        this.MaxSize = MaxSize;
    }

    public List<Pokemon> getPokemons() {
        return Pokemons;
    }

    public void setPokemons(List<Pokemon> Pokemons) {
        this.Pokemons = Pokemons;
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
    
    
    
}
