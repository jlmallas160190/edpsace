/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.facade;

import edu.sangerardo.edspace.dao.AbstractDao;
import edu.sangerardo.edspace.proyecto.modelo.Item;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author jorgemalla
 */
@Stateless
public class ItemFacade extends AbstractDao<Item> implements Serializable {

    public ItemFacade() {
        super(Item.class);
    }

}
