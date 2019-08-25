/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import repository.interfaces.IGenericRepository;

/**
 *
 * @author marcus
 * @param <T>
 */
public abstract class BaseCrudController<T> extends BaseController{
    
    private IGenericRepository<T> Repository;
    
    public T Index() {
        return this.Repository.Index();
    }
    
    public T Show(int id) {
        return this.Repository.Show(id);
    }
    
    public T Store(T data) {
         return this.Repository.Store(data);
    }
    
    public T Update(T data) {
         return this.Repository.Update(data);
    }
    
    public T Delete(int id) {
         return this.Repository.Delete(id);
    }
  
}
