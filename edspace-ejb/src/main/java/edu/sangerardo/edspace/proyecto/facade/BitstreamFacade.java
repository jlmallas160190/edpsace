/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.facade;

import edu.sangerardo.edspace.dao.AbstractDao;
import edu.sangerardo.edspace.proyecto.modelo.Bitstream;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author jorgemalla
 */
@Stateless
public class BitstreamFacade extends AbstractDao<Bitstream> implements Serializable{

    public BitstreamFacade() {
        super(Bitstream.class);
    }

    
}
