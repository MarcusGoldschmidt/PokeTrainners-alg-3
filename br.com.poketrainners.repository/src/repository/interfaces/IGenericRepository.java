/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.interfaces;

import java.util.ArrayList;

/**
 *
 * @author marcus
 * @param <T>
 */
public interface IGenericRepository<T> {
    public ArrayList<T> Index();
    
    public T Show(int id);
    
    public T Store(T data);
    
    public T Update(T data);
    
    public T Delete(int id);
}
