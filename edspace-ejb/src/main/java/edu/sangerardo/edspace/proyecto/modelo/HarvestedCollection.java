/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "harvested_collection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HarvestedCollection.findAll", query = "SELECT h FROM HarvestedCollection h")
    , @NamedQuery(name = "HarvestedCollection.findByHarvestType", query = "SELECT h FROM HarvestedCollection h WHERE h.harvestType = :harvestType")
    , @NamedQuery(name = "HarvestedCollection.findByOaiSource", query = "SELECT h FROM HarvestedCollection h WHERE h.oaiSource = :oaiSource")
    , @NamedQuery(name = "HarvestedCollection.findByOaiSetId", query = "SELECT h FROM HarvestedCollection h WHERE h.oaiSetId = :oaiSetId")
    , @NamedQuery(name = "HarvestedCollection.findByHarvestMessage", query = "SELECT h FROM HarvestedCollection h WHERE h.harvestMessage = :harvestMessage")
    , @NamedQuery(name = "HarvestedCollection.findByMetadataConfigId", query = "SELECT h FROM HarvestedCollection h WHERE h.metadataConfigId = :metadataConfigId")
    , @NamedQuery(name = "HarvestedCollection.findByHarvestStatus", query = "SELECT h FROM HarvestedCollection h WHERE h.harvestStatus = :harvestStatus")
    , @NamedQuery(name = "HarvestedCollection.findByHarvestStartTime", query = "SELECT h FROM HarvestedCollection h WHERE h.harvestStartTime = :harvestStartTime")
    , @NamedQuery(name = "HarvestedCollection.findByLastHarvested", query = "SELECT h FROM HarvestedCollection h WHERE h.lastHarvested = :lastHarvested")
    , @NamedQuery(name = "HarvestedCollection.findById", query = "SELECT h FROM HarvestedCollection h WHERE h.id = :id")})
public class HarvestedCollection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "harvest_type")
    private Integer harvestType;
    @Size(max = 2147483647)
    @Column(name = "oai_source")
    private String oaiSource;
    @Size(max = 2147483647)
    @Column(name = "oai_set_id")
    private String oaiSetId;
    @Size(max = 2147483647)
    @Column(name = "harvest_message")
    private String harvestMessage;
    @Size(max = 2147483647)
    @Column(name = "metadata_config_id")
    private String metadataConfigId;
    @Column(name = "harvest_status")
    private Integer harvestStatus;
    @Column(name = "harvest_start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date harvestStartTime;
    @Column(name = "last_harvested")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastHarvested;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id")
    @ManyToOne
    private Collection collectionId;

    public HarvestedCollection() {
    }

    public HarvestedCollection(Integer id) {
        this.id = id;
    }

    public Integer getHarvestType() {
        return harvestType;
    }

    public void setHarvestType(Integer harvestType) {
        this.harvestType = harvestType;
    }

    public String getOaiSource() {
        return oaiSource;
    }

    public void setOaiSource(String oaiSource) {
        this.oaiSource = oaiSource;
    }

    public String getOaiSetId() {
        return oaiSetId;
    }

    public void setOaiSetId(String oaiSetId) {
        this.oaiSetId = oaiSetId;
    }

    public String getHarvestMessage() {
        return harvestMessage;
    }

    public void setHarvestMessage(String harvestMessage) {
        this.harvestMessage = harvestMessage;
    }

    public String getMetadataConfigId() {
        return metadataConfigId;
    }

    public void setMetadataConfigId(String metadataConfigId) {
        this.metadataConfigId = metadataConfigId;
    }

    public Integer getHarvestStatus() {
        return harvestStatus;
    }

    public void setHarvestStatus(Integer harvestStatus) {
        this.harvestStatus = harvestStatus;
    }

    public Date getHarvestStartTime() {
        return harvestStartTime;
    }

    public void setHarvestStartTime(Date harvestStartTime) {
        this.harvestStartTime = harvestStartTime;
    }

    public Date getLastHarvested() {
        return lastHarvested;
    }

    public void setLastHarvested(Date lastHarvested) {
        this.lastHarvested = lastHarvested;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Collection collectionId) {
        this.collectionId = collectionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HarvestedCollection)) {
            return false;
        }
        HarvestedCollection other = (HarvestedCollection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.HarvestedCollection[ id=" + id + " ]";
    }
    
}
