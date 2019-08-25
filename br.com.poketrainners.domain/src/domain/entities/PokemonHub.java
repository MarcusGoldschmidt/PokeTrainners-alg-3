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
 */
public class PokemonHub extends Bag<Pokemon>{
    
    private Player  PlayerOwner;

    public PokemonHub(Player player) {
        this.PlayerOwner = player;
    }
    
    public boolean Add(Pokemon data){
        return this.Itens.add(data);
    }
}
