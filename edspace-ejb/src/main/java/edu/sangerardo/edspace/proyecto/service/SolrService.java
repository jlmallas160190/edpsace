/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.service;

import edu.sangerardo.edspace.master.facade.ConfiguracionFacade;
import edu.sangerardo.edspace.master.modelo.Configuracion;
import edu.sangerardo.edspace.master.modelo.DetalleConfiguracion;
import edu.sangerardo.edspace.master.service.ConfiguracionService;
import edu.sangerardo.edspace.util.ConfiguracionEnum;
import edu.sangerardo.edspace.util.DetalleConfiguracionEnum;
import edu.sangerardo.edspace.util.ServiceClient;
import edu.sangerardo.edspace.util.SolrEnum;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jorgemalla
 */
@Stateless
public class SolrService implements Serializable {

    @EJB
    private ServiceClient serviceClient;
    @EJB
    private ConfiguracionFacade configuracionFacade;
    @EJB
    private ConfiguracionService configuracionService;

    /**
     * Permite devolver en formato json las visitas a los recursos de dspace por
     * tipo
     *
     * @param type
     * @return
     */
    public JSONArray getStatisticsResourceByType(String type) {
        List<Configuracion> configuracionesGenerales = configuracionFacade.findByNamedQueryWithLimit("Configuracion.findByCodigo", 0, ConfiguracionEnum.GENERAL.getTipo());
        List<Configuracion> configuracionesApiSolr = configuracionFacade.findByNamedQueryWithLimit("Configuracion.findByCodigo", 0, ConfiguracionEnum.API_SOLR_STATISTICS.getTipo());

        Configuracion configuracionGeneral = !configuracionesGenerales.isEmpty() ? configuracionesGenerales.get(0) : null;
        DetalleConfiguracion detalleConfiguracionIp = configuracionService.getDetalleConfiguracionFilter(configuracionGeneral.getDetalleConfiguracions(), DetalleConfiguracionEnum.IP.getTipo());
        DetalleConfiguracion detalleConfiguracionPort = configuracionService.getDetalleConfiguracionFilter(configuracionGeneral.getDetalleConfiguracions(), DetalleConfiguracionEnum.PUERTO.getTipo());

        Configuracion configuracionApiSolr = !configuracionesApiSolr.isEmpty() ? configuracionesApiSolr.get(0) : null;
        DetalleConfiguracion detalleConfiguracionIndent = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(), SolrEnum.INDENT.getTipo());
        DetalleConfiguracion detalleConfiguracionStart = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(), SolrEnum.START.getTipo());
        DetalleConfiguracion detalleConfiguracionRows = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(), SolrEnum.ROWS.getTipo());
        DetalleConfiguracion detalleConfiguracionWt = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(), SolrEnum.WT.getTipo());
        DetalleConfiguracion detalleConfiguracionFacet = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(), SolrEnum.FACET.getTipo());
        DetalleConfiguracion detalleConfiguracionUrlStatitics = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(), DetalleConfiguracionEnum.URL_STATISTICS.getTipo());

        String url = String.format("%s:%s%s", detalleConfiguracionIp != null ? detalleConfiguracionIp.getValor() : "localhost:", detalleConfiguracionPort != null
                ? detalleConfiguracionPort.getValor() : "8080", detalleConfiguracionUrlStatitics != null ? detalleConfiguracionUrlStatitics.getValor() : "localhost:");
        String indent = String.format("%s", detalleConfiguracionIndent != null ? detalleConfiguracionIndent.getValor() : "on");
        String start = String.format("%s", detalleConfiguracionStart != null ? detalleConfiguracionStart.getValor() : "0");
        String rows = String.format("%s", detalleConfiguracionRows != null ? detalleConfiguracionRows.getValor() : "100");
        String wt = String.format("%s", detalleConfiguracionWt != null ? detalleConfiguracionWt.getValor() : "json");
        String facet = String.format("%s", detalleConfiguracionFacet != null ? detalleConfiguracionFacet.getValor() : "true");
        String q = "type:".concat(type);
        String query = String.format("indent=%s&start=%s&rows=%s&wt=%s&facet=%s&q=%s", indent, start,
                rows, wt, facet, q);
        String response = serviceClient.getResponse(url, query);
        JSONObject jSONObject = new JSONObject(response);
        JSONObject jSONResponse = jSONObject.getJSONObject(SolrEnum.RESPONSE.getTipo());
        JSONArray data = jSONResponse.getJSONArray(SolrEnum.DATA.getTipo());
        return data;
    }
}
