/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.Player;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import repository.dao.PlayerDao;

/**
 *
 * @author marcus
 */
@Path("v1/player")
public class PlayerController extends BaseCrudController<Player>{
    
    private final PlayerDao playerDao = new PlayerDao();
   
    @Path("/")
    @GET
    public ArrayList<Player> Index() {
        return playerDao.Index();
    }

    @Path("/{id}")
    @GET
    public Player Show(int id) {
        return playerDao.Show(id);
    }

    @Path("/")
    @POST
    public boolean Store(Player data) {
         return playerDao.Store(data);
    }

    @Path("/")
    @PUT
    public boolean Update(Player data) {
         return playerDao.Update(data);
    }

    @Path("/")
    @DELETE
    public boolean Delete(int id) {
         return playerDao.Delete(id);
    }  
    
}
