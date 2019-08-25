/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities.item;

import domain.entities.Player;
import domain.entities.enuns.ItemType;

/**
 *
 * @author marcus
 */
public abstract class Item {
    private int ItemId;
    
    private String Name;
    private String Description;
    
    private double Price;
    private double Weight;
    
    private ItemType Type;
}
