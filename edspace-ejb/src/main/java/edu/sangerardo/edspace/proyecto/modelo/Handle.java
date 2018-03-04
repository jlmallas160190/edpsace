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
@Table(name = "handle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Handle.findAll", query = "SELECT h FROM Handle h")
    , @NamedQuery(name = "Handle.findByHandleId", query = "SELECT h FROM Handle h WHERE h.handleId = :handleId")
    , @NamedQuery(name = "Handle.findByHandle", query = "SELECT h FROM Handle h WHERE h.handle = :handle")
    , @NamedQuery(name = "Handle.findByResourceTypeId", query = "SELECT h FROM Handle h WHERE h.resourceTypeId = :resourceTypeId")
    , @NamedQuery(name = "Handle.findByResourceId", query = "SELECT h FROM Handle h WHERE h.resourceId = :resourceId")})
public class Handle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "handle_id")
    private Integer handleId;
    @Size(max = 256)
    @Column(name = "handle")
    private String handle;
    @Column(name = "resource_type_id")
    private Integer resourceTypeId;
    @Column(name = "resource_id")
    private Integer resourceId;

    public Handle() {
    }

    public Handle(Integer handleId) {
        this.handleId = handleId;
    }

    public Integer getHandleId() {
        return handleId;
    }

    public void setHandleId(Integer handleId) {
        this.handleId = handleId;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (handleId != null ? handleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Handle)) {
            return false;
        }
        Handle other = (Handle) object;
        if ((this.handleId == null && other.handleId != null) || (this.handleId != null && !this.handleId.equals(other.handleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Handle[ handleId=" + handleId + " ]";
    }
    
}
