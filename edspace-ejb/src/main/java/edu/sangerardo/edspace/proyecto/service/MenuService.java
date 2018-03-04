/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.service;

import edu.sangerardo.edspace.dao.AbstractDao;
import edu.sangerardo.edspace.master.modelo.Menu;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author jorgemalla
 */
@Stateless
public class MenuService extends AbstractDao<Menu> implements Serializable {

    public MenuService() {
        super(Menu.class);
    }
}
