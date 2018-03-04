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
@Table(name = "versionitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Versionitem.findAll", query = "SELECT v FROM Versionitem v")
    , @NamedQuery(name = "Versionitem.findByVersionitemId", query = "SELECT v FROM Versionitem v WHERE v.versionitemId = :versionitemId")
    , @NamedQuery(name = "Versionitem.findByVersionNumber", query = "SELECT v FROM Versionitem v WHERE v.versionNumber = :versionNumber")
    , @NamedQuery(name = "Versionitem.findByVersionDate", query = "SELECT v FROM Versionitem v WHERE v.versionDate = :versionDate")
    , @NamedQuery(name = "Versionitem.findByVersionSummary", query = "SELECT v FROM Versionitem v WHERE v.versionSummary = :versionSummary")})
public class Versionitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "versionitem_id")
    private Integer versionitemId;
    @Column(name = "version_number")
    private Integer versionNumber;
    @Column(name = "version_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date versionDate;
    @Size(max = 255)
    @Column(name = "version_summary")
    private String versionSummary;
    @JoinColumn(name = "eperson_id", referencedColumnName = "eperson_id")
    @ManyToOne
    private Eperson epersonId;
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @ManyToOne
    private Item itemId;
    @JoinColumn(name = "versionhistory_id", referencedColumnName = "versionhistory_id")
    @ManyToOne
    private Versionhistory versionhistoryId;

    public Versionitem() {
    }

    public Versionitem(Integer versionitemId) {
        this.versionitemId = versionitemId;
    }

    public Integer getVersionitemId() {
        return versionitemId;
    }

    public void setVersionitemId(Integer versionitemId) {
        this.versionitemId = versionitemId;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }

    public Date getVersionDate() {
        return versionDate;
    }

    public void setVersionDate(Date versionDate) {
        this.versionDate = versionDate;
    }

    public String getVersionSummary() {
        return versionSummary;
    }

    public void setVersionSummary(String versionSummary) {
        this.versionSummary = versionSummary;
    }

    public Eperson getEpersonId() {
        return epersonId;
    }

    public void setEpersonId(Eperson epersonId) {
        this.epersonId = epersonId;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public Versionhistory getVersionhistoryId() {
        return versionhistoryId;
    }

    public void setVersionhistoryId(Versionhistory versionhistoryId) {
        this.versionhistoryId = versionhistoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (versionitemId != null ? versionitemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Versionitem)) {
            return false;
        }
        Versionitem other = (Versionitem) object;
        if ((this.versionitemId == null && other.versionitemId != null) || (this.versionitemId != null && !this.versionitemId.equals(other.versionitemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Versionitem[ versionitemId=" + versionitemId + " ]";
    }
    
}
