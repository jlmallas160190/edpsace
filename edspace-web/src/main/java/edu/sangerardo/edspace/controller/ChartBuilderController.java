/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.controller;

import edu.sangerardo.edspace.proyecto.dto.DownloadBitStreamDTO;
import edu.sangerardo.edspace.proyecto.dto.ResourceSolrGroupByDTO;
import edu.sangerardo.edspace.proyecto.dto.ViewCollectionDTO;
import edu.sangerardo.edspace.proyecto.dto.ViewCommunityDTO;
import edu.sangerardo.edspace.proyecto.dto.ViewItemDTO;
import edu.sangerardo.edspace.proyecto.service.BitStreamService;
import edu.sangerardo.edspace.proyecto.service.CollectionService;
import edu.sangerardo.edspace.proyecto.service.CommunityService;
import edu.sangerardo.edspace.proyecto.service.ItemService;
import edu.sangerardo.edspace.util.BaseEnum;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LegendPlacement;

/**
 *
 * @author jorgemalla
 */
@ManagedBean
@ViewScoped
public class ChartBuilderController implements Serializable {

    @EJB
    private CommunityService communityService;
    @EJB
    private CollectionService collectionService;
    @EJB
    private BitStreamService bitStreamService;
    @EJB
    private ItemService itemService;

    private Object chartModel;
    private String tipoChart;
    private String mensajeError;

    public void createChartVisitsCommunityGroupByMonth() {
        List<ViewCommunityDTO> viewCommunityDTOs = this.communityService.getViewGroupByMonth();
        if (!viewCommunityDTOs.isEmpty()) {
            tipoChart = BaseEnum.BAR_CHART.getTipo();
            BarChartModel barChartModel = new BarChartModel();
            int max = 0;
            for (ViewCommunityDTO viewCommunityDTO : viewCommunityDTOs) {
                ChartSeries chartSeriesViewCommunity = new ChartSeries();
                chartSeriesViewCommunity.setLabel(viewCommunityDTO.getCommunityDTO().getTitle());
                for (ResourceSolrGroupByDTO resourceSolrGroupByDTO : viewCommunityDTO.getResourceStatisticGroupBys()) {
                    chartSeriesViewCommunity.set(resourceSolrGroupByDTO.getGroupBy(), resourceSolrGroupByDTO.getNumberOperation());
                    if (resourceSolrGroupByDTO.getNumberOperation() > max) {
                        max = resourceSolrGroupByDTO.getNumberOperation();
                    }
                }
                barChartModel.addSeries(chartSeriesViewCommunity);
            }

            barChartModel.setTitle("Número de Visitas a Comunidades por Mes");
            barChartModel.setLegendPosition("e");
            barChartModel.setLegendPlacement(LegendPlacement.OUTSIDE);
            barChartModel.setZoom(true);
            barChartModel.setAnimate(true);
            barChartModel.setLegendCols(5);
            Axis xAxis = barChartModel.getAxis(AxisType.X);
            xAxis.setTickAngle(-50);
            xAxis.setLabel("Meses");

            Axis yAxis = barChartModel.getAxis(AxisType.Y);
            yAxis.setLabel("Visitas");
            yAxis.setMin(0);
            yAxis.setMax(max);
            chartModel = barChartModel;
        } else {
            chartModel = null;
            mensajeError = "No hay datos de comunidades que mostrar.";
        }
    }

    public void createChartVisitsCollectionsGroupByMonth() {
        List<ViewCollectionDTO> viewCollectionDTOs = this.collectionService.getViewGroupByMonth();
        tipoChart = BaseEnum.BAR_CHART.getTipo();
        if (!viewCollectionDTOs.isEmpty()) {
            BarChartModel barChartModel = new BarChartModel();
            int max = 0;
            for (ViewCollectionDTO viewCollectionDTO : viewCollectionDTOs) {
                ChartSeries chartSeriesViewCollection = new ChartSeries();
                chartSeriesViewCollection.setLabel(viewCollectionDTO.getCollectionDTO().getTitle());
                for (ResourceSolrGroupByDTO resourceSolrGroupByDTO : viewCollectionDTO.getResourceStatisticGroupBys()) {
                    chartSeriesViewCollection.set(resourceSolrGroupByDTO.getGroupBy(), resourceSolrGroupByDTO.getNumberOperation());
                    if (resourceSolrGroupByDTO.getNumberOperation() > max) {
                        max = resourceSolrGroupByDTO.getNumberOperation();
                    }
                }
                barChartModel.addSeries(chartSeriesViewCollection);
            }

            barChartModel.setTitle("Número de Visitas de Colecciones por Mes");
            barChartModel.setLegendPosition("e");
            barChartModel.setLegendPlacement(LegendPlacement.OUTSIDE);
            barChartModel.setZoom(true);
            barChartModel.setAnimate(true);
            barChartModel.setLegendCols(5);
            Axis xAxis = barChartModel.getAxis(AxisType.X);
            xAxis.setTickAngle(-50);
            xAxis.setLabel("Meses");

            Axis yAxis = barChartModel.getAxis(AxisType.Y);
            yAxis.setLabel("Visitas");
            yAxis.setMin(0);
            yAxis.setMax(max);
            chartModel = barChartModel;
        } else {
            chartModel = null;
            mensajeError = "No hay datos de colecciones que mostrar";
        }
    }

    public void createChartDownloadGroupByMonth() {
        List<DownloadBitStreamDTO> downloadBitStreamDtos = this.bitStreamService.getDownloadGroupByMonth();
        if (!downloadBitStreamDtos.isEmpty()) {
            tipoChart = BaseEnum.BAR_CHART.getTipo();
            BarChartModel barChartModel = new BarChartModel();
            int max = 0;
            for (DownloadBitStreamDTO downloadBitStream : downloadBitStreamDtos) {
                ChartSeries chartSeriesDownloadBitStream = new ChartSeries();
                chartSeriesDownloadBitStream.setLabel(downloadBitStream.getBitStreamDTO().getTitle());
                for (ResourceSolrGroupByDTO resourceSolrGroupByDTO : downloadBitStream.getResourceStatisticGroupBys()) {
                    chartSeriesDownloadBitStream.set(resourceSolrGroupByDTO.getGroupBy(), resourceSolrGroupByDTO.getNumberOperation());
                    if (resourceSolrGroupByDTO.getNumberOperation() > max) {
                        max = resourceSolrGroupByDTO.getNumberOperation();
                    }
                }
                barChartModel.addSeries(chartSeriesDownloadBitStream);
            }

            barChartModel.setTitle("Número de Descargas por Mes");
            barChartModel.setLegendPosition("e");
            barChartModel.setLegendPlacement(LegendPlacement.OUTSIDE);
            barChartModel.setZoom(true);
            barChartModel.setAnimate(true);
            barChartModel.setLegendCols(5);
            Axis xAxis = barChartModel.getAxis(AxisType.X);
            xAxis.setTickAngle(-50);
            xAxis.setLabel("Meses");

            Axis yAxis = barChartModel.getAxis(AxisType.Y);
            yAxis.setLabel("Descargas");
            yAxis.setMin(0);
            yAxis.setMax(max);
            chartModel = barChartModel;
        } else {
            chartModel = null;
            mensajeError = "No hay datos de bitstreams que mostrar";
        }
    }

    public void createChartVisitsItemGroupByMonth() {
        List<ViewItemDTO> viewItemDTOs = this.itemService.getViewGroupByMonth();
        if (!viewItemDTOs.isEmpty()) {
            tipoChart = BaseEnum.BAR_CHART.getTipo();
            BarChartModel barChartModel = new BarChartModel();
            int max = 0;
            for (ViewItemDTO viewItemDTO : viewItemDTOs) {

                ChartSeries chartSeriesViewItem = new ChartSeries();
                chartSeriesViewItem.setLabel(viewItemDTO.getItemDTO().getTitle());
                for (ResourceSolrGroupByDTO resourceSolrGroupByDTO : viewItemDTO.getResourceStatisticGroupBys()) {
                    chartSeriesViewItem.set(resourceSolrGroupByDTO.getGroupBy(), resourceSolrGroupByDTO.getNumberOperation());
                    if (resourceSolrGroupByDTO.getNumberOperation() > max) {
                        max = resourceSolrGroupByDTO.getNumberOperation();
                    }
                }
                barChartModel.addSeries(chartSeriesViewItem);

            }

            barChartModel.setTitle("Número de Visitas de Items por Mes");
            barChartModel.setLegendPosition("e");
            barChartModel.setLegendPlacement(LegendPlacement.OUTSIDE);
            barChartModel.setAnimate(true);
            barChartModel.setLegendCols(5);
            Axis xAxis = barChartModel.getAxis(AxisType.X);
            xAxis.setTickAngle(-50);
            xAxis.setLabel("Meses");

            Axis yAxis = barChartModel.getAxis(AxisType.Y);
            yAxis.setLabel("Visitas");
            yAxis.setMin(0);
            yAxis.setMax(max);
            chartModel = barChartModel;
        } else {
            chartModel = null;
            mensajeError = "No hay datos de items que mostrar";
        }
    }

    public void graficar(String caso) {
        chartModel = new Object();
        switch (Integer.parseInt(caso)) {

            case 1:
                createChartVisitsCommunityGroupByMonth();
                break;
            case 2:
                createChartVisitsCollectionsGroupByMonth();
                break;
            case 3:
                createChartVisitsItemGroupByMonth();
                break;
            case 4:
                createChartDownloadGroupByMonth();
                break;
        }

    }

    public Object getChartModel() {
        return chartModel;
    }

    public void setChartModel(Object chartModel) {
        this.chartModel = chartModel;
    }

    public String getTipoChart() {
        return tipoChart;
    }

    public void setTipoChart(String tipoChart) {
        this.tipoChart = tipoChart;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

}
