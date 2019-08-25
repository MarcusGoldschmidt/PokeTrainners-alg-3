/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.Player;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import repository.interfaces.IGenericRepository;

/**
 *
 * @author marcus
 */
@Path("v1/player")
public class PlayerController extends BaseCrudController<Player>{
    
    private IGenericRepository<Player> Repository;
   
    @Path("/")
    @GET
    public Player Index() {
        return super.Index();
    }

    @Path("/{id}")
    @GET
    public Player Show(int id) {
        return super.Show(id);
    }

    @Path("/")
    @POST
    public Player Store(Player data) {
         return super.Store(data);
    }

    @Path("/")
    @PUT
    public Player Update(Player data) {
         return super.Update(data);
    }

    @Path("/")
    @DELETE
    public Player Delete(int id) {
         return super.Delete(id);
    }  
    
}
