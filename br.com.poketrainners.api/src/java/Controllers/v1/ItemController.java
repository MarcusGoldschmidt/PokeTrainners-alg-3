/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers.v1;

import domain.entities.item.Item;
import javax.ws.rs.Path;
import repository.interfaces.GenericRepository;

/**
 *
 * @author marcus
 */
@Path("v1/item")
public class ItemController extends BaseCrudController<Item>{
    

}
