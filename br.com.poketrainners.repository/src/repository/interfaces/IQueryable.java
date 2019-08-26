/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.interfaces;

import java.util.List;

/**
 *
 * @author marcus
 * @param <T>
 */
public interface IQueryable<T> {
    
    public List<T> Get();
    
    public boolean Set();
    
}
