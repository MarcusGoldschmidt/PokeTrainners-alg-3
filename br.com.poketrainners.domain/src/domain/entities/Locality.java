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
public class Locality {
    private int             LocalityId;
    private String          Name;
    
    private List<Pokemon>   PokemonsAvailable;
    private List<Player>    Npcs;
}
