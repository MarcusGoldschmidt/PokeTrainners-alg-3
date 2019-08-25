/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.Pokemon;
import javax.ws.rs.Path;
import repository.interfaces.GenericRepository;

/**
 *
 * @author marcus
 */
@Path("v1/pokemon")
public class PokemonController extends BaseCrudController<Pokemon>{
    
    private GenericRepository<Pokemon> Repository;

    @Path("/")
    @Override
    public Pokemon Index() {
        return this.Repository.Index();
    }

    @Path("/{id}")
    @Override
    public Pokemon Show(int id) {
        return this.Repository.Show(id);
    }

    @Path("/")
    @Override
    public Pokemon Store(Pokemon data) {
         return this.Repository.Store(data);
    }

    @Path("/")
    @Override
    public Pokemon Update(Pokemon data) {
         return this.Repository.Update(data);
    }

    @Path("/")
    @Override
    public Pokemon Delete(int id) {
         return this.Repository.Delete(id);
    }    
}
