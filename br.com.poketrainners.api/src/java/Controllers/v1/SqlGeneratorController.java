/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.Bag;
import domain.entities.Player;
import infraestruture.helpers.GenerateSql;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author marcus
 */
@Path("/v1/sql")
public class SqlGeneratorController extends BaseController{
    
    private GenerateSql<Player> teste;
    
    @Path("/")
    @GET
    public String index(){
        this.teste = new GenerateSql<>(Player.class);
        
        Player player = new Player(1,"Marcus", "Teste", null, null, null);
        
        return teste.Store(player);
    }
    
}
