/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entities;

import domain.entities.enuns.ItemType;

/**
 *
 * @author marcus
 */
public class Item {
    private int ItemId;
    
    private String Nome;
    private String Description;
    
    private double Peso;
    
    private ItemType Type;
}
