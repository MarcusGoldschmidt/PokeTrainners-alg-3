package Controllers;

import javax.ws.rs.Path;

@Path("/pessoa")
public class Pessoa {
    @Path("/")
    public String index() {
        return "Teste";
    }
}
