/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.master.service;

import edu.sangerardo.edspace.master.modelo.DetalleConfiguracion;
import edu.sangerardo.edspace.proyecto.dto.ResourceSolrDTO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author jorgemalla
 */
@Stateless
public class ConfiguracionService implements Serializable {

    public ResourceSolrDTO getDownload(List<ResourceSolrDTO> dbses, ResourceSolrDTO downloadBitStream) {
        for (ResourceSolrDTO dbs : dbses) {
            if (dbs.equals(downloadBitStream)) {
                return dbs;
            }
        }
        return null;
    }

    /**
     * Permite devolver un detalle de configuración filtrado por codigo.
     *
     * @param detalleConfiguracions
     * @param filter
     * @return
     */
    public DetalleConfiguracion getDetalleConfiguracionFilter(List<DetalleConfiguracion> detalleConfiguracions, String filter) {
        for (DetalleConfiguracion detalleConfiguracion : detalleConfiguracions) {
            if (detalleConfiguracion.getCodigo().equals(filter)) {
                return detalleConfiguracion;
            }
        }
        return null;
    }
}
