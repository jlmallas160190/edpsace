/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.master.facade;

import edu.sangerardo.edspace.dao.AbstractDao;
import edu.sangerardo.edspace.master.modelo.Configuracion;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author jorgemalla
 */
@Stateless
public class ConfiguracionFacade extends AbstractDao<Configuracion> implements Serializable {

    public ConfiguracionFacade() {
        super(Configuracion.class);
    }

}
