/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.v1;

import domain.entities.Player;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import repository.dao.PlayerDao;

/**
 *
 * @author marcus
 */
@Path("player")
public class PlayerController extends BaseCrudController<Player>{
    
    private final PlayerDao playerDao = new PlayerDao();
   
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> Index() {
        return playerDao.Index();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Player Show(@PathParam("id") int id) {
        return playerDao.Show(id);
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Store(Player data) {
         return playerDao.Store(data);
    }

    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Update(Player data) {
         return playerDao.Update(data);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Delete(@PathParam("id") int id) {
         return playerDao.Delete(id);
    }  
    
}
