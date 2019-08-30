/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.Player;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author marcus
 */
@Path("/app")
public class SpaController {
    @Path("/")
    @GET
    public String Index() {
        return playerDao.Index();
    }
}
