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

/**
 *
 * @author marcus
 */
@Path("v1/pokemon")
public class PokeballController extends BaseCrudController<Pokeball>{
   
    @Path("/")
    @GET
    public Pokeball Index() {
        return super.Index();
    }

    @Path("/{id}")
    @GET
    public Pokeball Show(int id) {
        return super.Show(id);
    }

    @Path("/")
    @POST
    public Pokeball Store(Pokeball data) {
         return super.Store(data);
    }

    @Path("/")
    @PUT
    public Pokeball Update(Pokeball data) {
         return super.Update(data);
    }

    @Path("/")
    @DELETE
    public Pokeball Delete(int id) {
         return super.Delete(id);
    }  
    
}
