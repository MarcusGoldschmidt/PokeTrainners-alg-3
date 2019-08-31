/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.v1;

import java.util.List;

/**
 *
 * @author marcus
 * @param <T>
 */
public abstract class BaseCrudController<T> extends BaseController{    
    /**
     *
     * @return
     */
    public abstract List<T> Index();
    
    public abstract T Show(int id);
    
    public abstract boolean Store(T data);
    
    public abstract boolean Update(T data);
    
    public abstract boolean Delete(int id);
  
}
