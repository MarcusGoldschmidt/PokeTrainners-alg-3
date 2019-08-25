/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.item.Pokeball;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import repository.interfaces.GenericRepository;

/**
 *
 * @author marcus
 * @param <T>
 */
public class BaseCrudController<T> extends BaseController{
    
    private GenericRepository<T> Repository;
    
    @Path("/")
    @GET
    public T Index() {
        return this.Repository.Index();
    }

    @Path("/{id}")
    @GET
    public T Show(int id) {
        return this.Repository.Show(id);
    }

    @Path("/")
    @POST
    public T Store(T data) {
         return this.Repository.Store(data);
    }

    @Path("/")
    @PUT
    public T Update(T data) {
         return this.Repository.Update(data);
    }

    @Path("/")
    @DELETE
    public T Delete(int id) {
         return this.Repository.Delete(id);
    }  
    
}
