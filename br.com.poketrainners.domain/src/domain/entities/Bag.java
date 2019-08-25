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
public class Bag<T> {
    protected int BagId;
    
    protected int MaxSize;
    
    protected List<T> Itens;
}
