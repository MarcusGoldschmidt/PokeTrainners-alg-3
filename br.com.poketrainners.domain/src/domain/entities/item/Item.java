/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities.item;

import domain.entities.enuns.ItemType;

/**
 *
 * @author marcus
 */
public class Item {
    protected int ItemId;
    
    protected String Name;
    protected String Description;
    
    protected double Price;
    protected double Weight;
    
    protected ItemType Type;
}
