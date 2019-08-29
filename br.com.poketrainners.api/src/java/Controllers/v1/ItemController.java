/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.item.Item;
import java.util.ArrayList;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import repository.dao.ItemDao;

/**
 *
 * @author marcus
 */
@Path("/v1/item")
public class ItemController extends BaseCrudController<Item> {
    
    private final ItemDao itemDao = new ItemDao();
    
    @Path("/")
    @GET
    public ArrayList<Item> Index() {
        return itemDao.Index();
    }

    @Path("/{id}")
    @GET
    public Item Show(int id) {
        return itemDao.Show(id);
    }

    @Path("/")
    @POST
    public Item Store(Item data) {
         return itemDao.Store(data);
    }

    @Path("/")
    @PUT
    public Item Update(Item data) {
         return itemDao.Update(data);
    }

    @Path("/")
    @DELETE
    public Item Delete(int id) {
         return itemDao.Delete(id);
    }  

}
