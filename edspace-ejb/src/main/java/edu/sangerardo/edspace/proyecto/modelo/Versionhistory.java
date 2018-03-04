/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "versionhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Versionhistory.findAll", query = "SELECT v FROM Versionhistory v")
    , @NamedQuery(name = "Versionhistory.findByVersionhistoryId", query = "SELECT v FROM Versionhistory v WHERE v.versionhistoryId = :versionhistoryId")})
public class Versionhistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "versionhistory_id")
    private Integer versionhistoryId;
    @OneToMany(mappedBy = "versionhistoryId")
    private List<Versionitem> versionitemList;

    public Versionhistory() {
    }

    public Versionhistory(Integer versionhistoryId) {
        this.versionhistoryId = versionhistoryId;
    }

    public Integer getVersionhistoryId() {
        return versionhistoryId;
    }

    public void setVersionhistoryId(Integer versionhistoryId) {
        this.versionhistoryId = versionhistoryId;
    }

    @XmlTransient
    public List<Versionitem> getVersionitemList() {
        return versionitemList;
    }

    public void setVersionitemList(List<Versionitem> versionitemList) {
        this.versionitemList = versionitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (versionhistoryId != null ? versionhistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Versionhistory)) {
            return false;
        }
        Versionhistory other = (Versionhistory) object;
        if ((this.versionhistoryId == null && other.versionhistoryId != null) || (this.versionhistoryId != null && !this.versionhistoryId.equals(other.versionhistoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Versionhistory[ versionhistoryId=" + versionhistoryId + " ]";
    }
    
}
