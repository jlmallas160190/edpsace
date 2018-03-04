/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.facade;

import edu.sangerardo.edspace.dao.AbstractDao;
import edu.sangerardo.edspace.proyecto.modelo.Collection;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author jorgemalla
 */
@Stateless
public class CollectionFacade extends AbstractDao<Collection> implements Serializable {

    public CollectionFacade() {
        super(Collection.class);
    }

}
