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
    
    private int         PokemonCathedId;
    
    private int         PlayerId;
    private Player      Player;
    
    private Pokemon     Pokemon;
    
    private Date        CreatedAt;
}
