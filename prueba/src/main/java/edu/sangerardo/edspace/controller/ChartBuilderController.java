/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.controller;

import edu.sangerardo.edspace.dto.CollectionDTO;
import edu.sangerardo.edspace.dto.CommunityDTO;
import edu.sangerardo.edspace.services.CollectionService;
import edu.sangerardo.edspace.services.CommunityService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author jorgemalla
 */
@Named
@ViewScoped
public class ChartBuilderController implements Serializable {

    @EJB
    private CommunityService communityService;
    @EJB
    private CollectionService collectionService;
    private PieChartModel pieModel;

    @PostConstruct
    public void init() {
        this.pieModel = null;
    }

    public void createPieModelColeccionesCommunity() {
        pieModel = new PieChartModel();
        List<CommunityDTO> communityDTOs = communityService.getCommunitiesParent();
        List<CommunityDTO> communityDTOsCollections = communityService.getCommunitiesParentCollections(communityDTOs);
        for (CommunityDTO communityDTO : communityDTOsCollections) {
            pieModel.set((!communityDTO.getMetadatavalues().isEmpty()
                    ? communityDTO.getMetadatavalues().get(0).getTextValue() : ""),
                    communityDTO.getCountColecctions());
        }
        pieModel.setTitle("Número de Colecciones por Comunidad");
        pieModel.setLegendPosition("e");
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(150);
    }

    public void createPieModelVisitsCommunity() {
        pieModel = new PieChartModel();
        List<CommunityDTO> communityDTOs = communityService.getCommunitiesParent();
        List<CommunityDTO> communityDTOsCollections = communityService.getCommunitiesParentVisits(communityDTOs);
        for (CommunityDTO communityDTO : communityDTOsCollections) {
            pieModel.set((!communityDTO.getMetadatavalues().isEmpty()
                    ? communityDTO.getMetadatavalues().get(0).getTextValue() : ""),
                    communityDTO.getVisits());
        }
        pieModel.setTitle("Número de Visitas por Comunidad");
        pieModel.setLegendPosition("e");
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(150);
    }

    public void createPieModelVisitsCollections() {
        pieModel = new PieChartModel();
        List<CollectionDTO> collectionDTOs = collectionService.getCollections();
        List<CollectionDTO> collectionDTOsVisits = collectionService.getCollectionsVisits(collectionDTOs);
        for (CollectionDTO collectionDTO : collectionDTOsVisits) {
            pieModel.set((!collectionDTO.getMetadatavalues().isEmpty()
                    ? collectionDTO.getMetadatavalues().get(0).getTextValue() : ""),
                    collectionDTO.getCountVisits());
        }
        pieModel.setTitle("Número de Visitas por Collección");
        pieModel.setLegendPosition("e");
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(150);
    }

    public void graficar(String caso) {
        this.pieModel = null;
        switch (Integer.parseInt(caso)) {

            case 1:
                createPieModelColeccionesCommunity();
                break;
            case 2:
                createPieModelVisitsCommunity();
                break;
            case 3:
                createPieModelVisitsCollections();
                break;
        }

    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

}
