/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.item.Item;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 *
 * @author marcus
 */
@Path("/v1/item")
public class ItemController extends BaseCrudController<Item>{
    
    @Path("/")
    @GET
    public Item Index() {
        return super.Index();
    }

    @Path("/{id}")
    @GET
    public Item Show(int id) {
        return super.Show(id);
    }

    @Path("/")
    @POST
    public Item Store(Item data) {
         return super.Store(data);
    }

    @Path("/")
    @PUT
    public Item Update(Item data) {
         return super.Update(data);
    }

    @Path("/")
    @DELETE
    public Item Delete(int id) {
         return super.Delete(id);
    }  

}
