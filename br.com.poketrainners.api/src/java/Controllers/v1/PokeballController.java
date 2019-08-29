/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.item.Pokeball;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import repository.dao.PokeballDao;
/**
 *
 * @author marcus
 */
@Path("v1/pokemon")
public class PokeballController extends BaseCrudController<Pokeball>{
   
    private final PokeballDao pokeballDao = new PokeballDao();
    
    @Path("/")
    @GET
    public ArrayList<Pokeball> Index() {
        return pokeballDao.Index();
    }

    @Path("/{id}")
    @GET
    public Pokeball Show(int id) {
        return pokeballDao.Show(id);
    }

    @Path("/")
    @POST
    public Pokeball Store(Pokeball data) {
         return pokeballDao.Store(data);
    }

    @Path("/")
    @PUT
    public Pokeball Update(Pokeball data) {
         return pokeballDao.Update(data);
    }

    @Path("/")
    @DELETE
    public Pokeball Delete(int id) {
         return pokeballDao.Delete(id);
    }  
    
}
