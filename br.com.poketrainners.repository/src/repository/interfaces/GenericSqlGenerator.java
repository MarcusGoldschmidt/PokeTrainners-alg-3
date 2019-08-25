/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.interfaces;

/**
 *
 * @author marcus
 */
public interface GenericSqlGenerator<T> {
    public String Index();
    
    public String Show(int id);
    
    public String Store(T data);
    
    public String Update(T data);
    
    public String Delete(int id);
}
