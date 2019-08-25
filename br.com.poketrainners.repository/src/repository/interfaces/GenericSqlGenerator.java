/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.interfaces;

/**
 *
 * @author marcus
 * @param <T>
 */
public abstract class GenericSqlGenerator<T> {
    
    public abstract String Index();
    
    public abstract String Show(int id);
    
    public abstract String Store(T data);
    
    public abstract String Update(int id, T data);
    
    public abstract String Delete(int id);
    
}
