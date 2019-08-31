/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.v1;

import domain.entities.Pokemon;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import repository.dao.PokemonDao;

/**
 *
 * @author marcus
 */
@Path("pokemon")
public class PokemonController extends BaseCrudController<Pokemon>{
    
    private final PokemonDao pokemonDao = new PokemonDao();
    
    @Path("/")
    @GET
    public ArrayList<Pokemon> Index() {
        return pokemonDao.Index();
    }

    @Path("/{id}")
    @GET
    public Pokemon Show(int id) {
        return pokemonDao.Show(id);
    }

    @Path("/")
    @POST
    public boolean Store(Pokemon data) {
         return pokemonDao.Store(data);
    }

    @Path("/")
    @PUT
    public boolean Update(Pokemon data) {
         return pokemonDao.Update(data);
    }

    @Path("/")
    @DELETE
    public boolean Delete(int id) {
         return pokemonDao.Delete(id);
    }    
}
