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

    public Bag(int maxSize) {
        this.MaxSize = maxSize;
    }
    
    public boolean add(T data){
        if (Itens.size() >= 6) {
            return false;
        }
        return Itens.add(data);
    }
    
    public boolean remove(T data){
        return Itens.remove(data);
    } 
    
    public T removeAt(int i){
        return Itens.remove(i);
    } 
    
}
