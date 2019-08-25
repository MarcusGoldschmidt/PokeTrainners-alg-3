/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.Pokemon;
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
public class PokemonController extends BaseCrudController<Pokemon>{

    @Path("/")
    @GET
    public Pokemon Index() {
        return super.Index();
    }

    @Path("/{id}")
    @GET
    public Pokemon Show(int id) {
        return super.Show(id);
    }

    @Path("/")
    @POST
    public Pokemon Store(Pokemon data) {
         return super.Store(data);
    }

    @Path("/")
    @PUT
    public Pokemon Update(Pokemon data) {
         return super.Update(data);
    }

    @Path("/")
    @DELETE
    public Pokemon Delete(int id) {
         return super.Delete(id);
    }    
}
