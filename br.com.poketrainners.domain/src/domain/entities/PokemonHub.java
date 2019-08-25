/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

/**
 *
 * @author marcus
 */
public class PokemonHub extends Bag<Pokemon>{
    
    private int     PokemonHubId;
    
    private Player  PlayerOwner;
    
    public PokemonHub(Player player) {
        this.PlayerOwner = player;
    }

    public int getPokemonHubId() {
        return PokemonHubId;
    }

    public void setPokemonHubId(int PokemonHubId) {
        this.PokemonHubId = PokemonHubId;
    }

    public Player getPlayerOwner() {
        return PlayerOwner;
    }

    public void setPlayerOwner(Player PlayerOwner) {
        this.PlayerOwner = PlayerOwner;
    }
    
    public boolean Add(Pokemon data){
        return this.Itens.add(data);
    }
}
