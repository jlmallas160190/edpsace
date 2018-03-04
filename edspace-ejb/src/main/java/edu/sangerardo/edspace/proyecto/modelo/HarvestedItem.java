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
@Table(name = "harvested_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HarvestedItem.findAll", query = "SELECT h FROM HarvestedItem h")
    , @NamedQuery(name = "HarvestedItem.findByLastHarvested", query = "SELECT h FROM HarvestedItem h WHERE h.lastHarvested = :lastHarvested")
    , @NamedQuery(name = "HarvestedItem.findByOaiId", query = "SELECT h FROM HarvestedItem h WHERE h.oaiId = :oaiId")
    , @NamedQuery(name = "HarvestedItem.findById", query = "SELECT h FROM HarvestedItem h WHERE h.id = :id")})
public class HarvestedItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "last_harvested")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastHarvested;
    @Size(max = 2147483647)
    @Column(name = "oai_id")
    private String oaiId;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @ManyToOne
    private Item itemId;

    public HarvestedItem() {
    }

    public HarvestedItem(Integer id) {
        this.id = id;
    }

    public Date getLastHarvested() {
        return lastHarvested;
    }

    public void setLastHarvested(Date lastHarvested) {
        this.lastHarvested = lastHarvested;
    }

    public String getOaiId() {
        return oaiId;
    }

    public void setOaiId(String oaiId) {
        this.oaiId = oaiId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
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
        if (!(object instanceof HarvestedItem)) {
            return false;
        }
        HarvestedItem other = (HarvestedItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.HarvestedItem[ id=" + id + " ]";
    }
    
}
