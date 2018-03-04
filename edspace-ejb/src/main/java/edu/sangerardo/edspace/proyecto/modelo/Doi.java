/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "doi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doi.findAll", query = "SELECT d FROM Doi d")
    , @NamedQuery(name = "Doi.findByDoiId", query = "SELECT d FROM Doi d WHERE d.doiId = :doiId")
    , @NamedQuery(name = "Doi.findByDoi", query = "SELECT d FROM Doi d WHERE d.doi = :doi")
    , @NamedQuery(name = "Doi.findByResourceTypeId", query = "SELECT d FROM Doi d WHERE d.resourceTypeId = :resourceTypeId")
    , @NamedQuery(name = "Doi.findByResourceId", query = "SELECT d FROM Doi d WHERE d.resourceId = :resourceId")
    , @NamedQuery(name = "Doi.findByStatus", query = "SELECT d FROM Doi d WHERE d.status = :status")})
public class Doi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "doi_id")
    private Integer doiId;
    @Size(max = 256)
    @Column(name = "doi")
    private String doi;
    @Column(name = "resource_type_id")
    private Integer resourceTypeId;
    @Column(name = "resource_id")
    private Integer resourceId;
    @Column(name = "status")
    private Integer status;

    public Doi() {
    }

    public Doi(Integer doiId) {
        this.doiId = doiId;
    }

    public Integer getDoiId() {
        return doiId;
    }

    public void setDoiId(Integer doiId) {
        this.doiId = doiId;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public Integer getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Integer resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doiId != null ? doiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doi)) {
            return false;
        }
        Doi other = (Doi) object;
        if ((this.doiId == null && other.doiId != null) || (this.doiId != null && !this.doiId.equals(other.doiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Doi[ doiId=" + doiId + " ]";
    }
    
}
