/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.service;

import edu.sangerardo.edspace.proyecto.facade.MetaDataValueFacade;
import edu.sangerardo.edspace.master.facade.ConfiguracionFacade;
import edu.sangerardo.edspace.master.modelo.Configuracion;
import edu.sangerardo.edspace.master.modelo.DetalleConfiguracion;
import edu.sangerardo.edspace.master.service.ConfiguracionService;
import edu.sangerardo.edspace.proyecto.modelo.Metadatavalue;
import edu.sangerardo.edspace.util.ResourceTypeEnum;
import edu.sangerardo.edspace.proyecto.dto.CommunityDTO;
import edu.sangerardo.edspace.proyecto.dto.ResourceSolrGroupByDTO;
import edu.sangerardo.edspace.proyecto.dto.ViewCommunityDTO;
import edu.sangerardo.edspace.proyecto.facade.CommunityFacade;
import edu.sangerardo.edspace.util.BaseUtilService;
import edu.sangerardo.edspace.util.ConfiguracionEnum;
import edu.sangerardo.edspace.util.DetalleConfiguracionEnum;
import edu.sangerardo.edspace.util.MetaDataEnum;
import edu.sangerardo.edspace.util.SolrEnum;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jorgemalla
 */
@Stateless
public class CommunityService implements Serializable {

    @EJB
    private CommunityFacade communityFacade;
    @EJB
    private MetaDataValueFacade metaDataValueFacade;
    @EJB
    private BaseUtilService baseUtilService;
    @EJB
    private SolrService solrService;
    @EJB
    private ConfiguracionFacade configuracionFacade;
    @EJB
    private ConfiguracionService configuracionService;

    public List<ViewCommunityDTO> getViewGroupByMonth() {
        List<ViewCommunityDTO> viewCommunityDTOs = new ArrayList<ViewCommunityDTO>();
        try {
            List<Configuracion> configuracionesApiSolr = configuracionFacade.findByNamedQueryWithLimit("Configuracion.findByCodigo", 0, ConfiguracionEnum.API_SOLR_STATISTICS.getTipo());

            Configuracion configuracionApiSolr = !configuracionesApiSolr.isEmpty() ? configuracionesApiSolr.get(0) : null;
            DetalleConfiguracion detalleConfiguracionRangeNumberMonth = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(),
                    DetalleConfiguracionEnum.RANGE_NUMBER_MONTH.getTipo());
            DetalleConfiguracion detalleConfiguracionRangeEndMonth = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(),
                    DetalleConfiguracionEnum.RANGE_END_MONTH.getTipo());
            DetalleConfiguracion detalleConfiguracionDateFormat1 = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(),
                    DetalleConfiguracionEnum.DATE_FORMAT1.getTipo());
            DetalleConfiguracion detalleConfiguracionDateFormat2 = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(),
                    DetalleConfiguracionEnum.DATE_FORMAT2.getTipo());
            DetalleConfiguracion detalleConfiguracionDateFormat3 = configuracionService.getDetalleConfiguracionFilter(configuracionApiSolr.getDetalleConfiguracions(),
                    DetalleConfiguracionEnum.DATE_FORMAT3.getTipo());

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(detalleConfiguracionDateFormat3 != null ? detalleConfiguracionDateFormat3.getValor() : "yyyy-MM-dd");
            Date dateEndRange = simpleDateFormat.parse(detalleConfiguracionRangeEndMonth != null ? detalleConfiguracionRangeEndMonth.getValor() : "");
            List<String> datesRangeString = baseUtilService.getDatesRangeString(detalleConfiguracionRangeNumberMonth != null
                    ? Integer.valueOf(detalleConfiguracionRangeNumberMonth.getValor()) : 0, dateEndRange,
                    detalleConfiguracionDateFormat1 != null ? detalleConfiguracionDateFormat1.getValor() : "MMMM yyyy");

            SimpleDateFormat fechaFormat = new SimpleDateFormat(detalleConfiguracionDateFormat2 != null ? detalleConfiguracionDateFormat2.getValor() : "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

            JSONArray data = solrService.getStatisticsResourceByType(ResourceTypeEnum.COMMUNITY.getTipo());

            //Construir la lista de descargar de los bitstream por meses.
            for (int i = 0; i < data.length(); i++) {
                JSONObject object = data.getJSONObject(i);
                Integer id = !object.isNull(SolrEnum.ID.getTipo()) ? object.getInt(SolrEnum.ID.getTipo()) : 0;
                Date time = fechaFormat.parse(object.getString(SolrEnum.TIME.getTipo()));
                ViewCommunityDTO viewCommunityDTO = getViewCommunityDTO(viewCommunityDTOs, id);
                if (viewCommunityDTO == null) {
                    viewCommunityDTO = new ViewCommunityDTO();
                    viewCommunityDTO.setId(id);
                    viewCommunityDTO.setIp(!object.isNull(SolrEnum.IP.getTipo()) ? object.getString(SolrEnum.IP.getTipo()) : "");
                    viewCommunityDTO.setEpersonId(!object.isNull(SolrEnum.EPERSON_ID.getTipo()) ? object.getInt(SolrEnum.EPERSON_ID.getTipo()) : 0);
                    CommunityDTO communityDTO = new CommunityDTO();
                    communityDTO.setCommunity(communityFacade.find(viewCommunityDTO.getId()));
                    List<Metadatavalue> metadatavalues = metaDataValueFacade.findByNamedQueryWithLimit("Metadatavalue.findByResource", 0, communityDTO.getCommunity().getCommunityId(),
                            Integer.parseInt(ResourceTypeEnum.COMMUNITY.getTipo()), Integer.parseInt(MetaDataEnum.TITLE.getTipo()));
                    communityDTO.setTitle(!metadatavalues.isEmpty() ? metadatavalues.get(0).getTextValue() : "");
                    viewCommunityDTO.setCommunityDTO(communityDTO);
                    viewCommunityDTO.setTime(time);
                    viewCommunityDTOs.add(viewCommunityDTO);
                }

                SimpleDateFormat fechaFormat1 = new SimpleDateFormat(detalleConfiguracionDateFormat1 != null ? detalleConfiguracionDateFormat1.getValor() : "MMMM yyyy");
                String key = fechaFormat1.format(time);
                for (String dateRangeString : datesRangeString) {
                    ResourceSolrGroupByDTO resourceSolrGroupByDTO = getViewCommunityGroupBy(viewCommunityDTO.getResourceStatisticGroupBys(), dateRangeString);
                    if (resourceSolrGroupByDTO == null) {
                        resourceSolrGroupByDTO = new ResourceSolrGroupByDTO();
                        resourceSolrGroupByDTO.setGroupBy(dateRangeString);
                        if (dateRangeString.equals(key)) {
                            resourceSolrGroupByDTO.setNumberOperation(resourceSolrGroupByDTO.getNumberOperation() + 1);
                        }
                        viewCommunityDTO.getResourceStatisticGroupBys().add(resourceSolrGroupByDTO);
                    } else {
                        if (dateRangeString.equals(key)) {
                            resourceSolrGroupByDTO.setNumberOperation(resourceSolrGroupByDTO.getNumberOperation() + 1);
                        }
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(BitStreamService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return viewCommunityDTOs;
    }

    private ViewCommunityDTO getViewCommunityDTO(List<ViewCommunityDTO> viewCommunityDTOs, Integer id) {
        for (ViewCommunityDTO viewCommunityDTO : viewCommunityDTOs) {
            if (id.equals(viewCommunityDTO.getId())) {
                return viewCommunityDTO;
            }
        }
        return null;
    }

    private ResourceSolrGroupByDTO getViewCommunityGroupBy(List<ResourceSolrGroupByDTO> resourceStatisticGroupByDtos, String date) {
        for (ResourceSolrGroupByDTO resourceStatisticGroupByDto : resourceStatisticGroupByDtos) {
            if (date.equals(resourceStatisticGroupByDto.getGroupBy())) {
                return resourceStatisticGroupByDto;
            }
        }
        return null;
    }

}
