/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.v1;

import domain.entities.PokemonBag;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import repository.dao.PokemonBagDao;

/**
 *
 * @author marcus
 */
@Path("player/bag/pokemon")
public class PokeBagController extends BaseCrudController<PokemonBag>{
    
    private final PokemonBagDao pokemonBagDao = new PokemonBagDao();

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PokemonBag> Index() {
        return this.pokemonBagDao.Index();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PokemonBag Show(@PathParam("id") int id) {
        return this.pokemonBagDao.Show(id);
    }

    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Store(PokemonBag data) {
        return this.pokemonBagDao.Store(data);
    }

    @Path("/")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Update(PokemonBag data) {
        return this.pokemonBagDao.Update(data);
    }

    @Path("/")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public boolean Delete(int id) {
        return this.pokemonBagDao.Delete(id);
    }
    
}
