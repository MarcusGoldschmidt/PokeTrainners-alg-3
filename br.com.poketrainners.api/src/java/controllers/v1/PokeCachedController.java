/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.v1;

import domain.entities.PokemonCathed;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import repository.dao.PokemonCathedDao;

/**
 *
 * @author marcus
 */
@Path("pokemon/cached")
public class PokeCachedController extends BaseCrudController<PokemonCathed>{

    private final PokemonCathedDao pokemonCathedDao = new PokemonCathedDao();
    
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<PokemonCathed> Index() {
        return this.pokemonCathedDao.Index();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PokemonCathed Show(@PathParam("id") int id) {
        return this.pokemonCathedDao.Show(id);
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Store(PokemonCathed data) {
        return this.pokemonCathedDao.Store(data);
    }

    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Update(PokemonCathed data) {
        return this.pokemonCathedDao.Update(data);
    }

    @Path("/")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Delete(int id) {
        return this.pokemonCathedDao.Delete(id);
    }
    
}
