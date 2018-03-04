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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "epersongroup2workspaceitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Epersongroup2workspaceitem.findAll", query = "SELECT e FROM Epersongroup2workspaceitem e")
    , @NamedQuery(name = "Epersongroup2workspaceitem.findById", query = "SELECT e FROM Epersongroup2workspaceitem e WHERE e.id = :id")})
public class Epersongroup2workspaceitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "eperson_group_id", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup epersonGroupId;
    @JoinColumn(name = "workspace_item_id", referencedColumnName = "workspace_item_id")
    @ManyToOne
    private Workspaceitem workspaceItemId;

    public Epersongroup2workspaceitem() {
    }

    public Epersongroup2workspaceitem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Epersongroup getEpersonGroupId() {
        return epersonGroupId;
    }

    public void setEpersonGroupId(Epersongroup epersonGroupId) {
        this.epersonGroupId = epersonGroupId;
    }

    public Workspaceitem getWorkspaceItemId() {
        return workspaceItemId;
    }

    public void setWorkspaceItemId(Workspaceitem workspaceItemId) {
        this.workspaceItemId = workspaceItemId;
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
        if (!(object instanceof Epersongroup2workspaceitem)) {
            return false;
        }
        Epersongroup2workspaceitem other = (Epersongroup2workspaceitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Epersongroup2workspaceitem[ id=" + id + " ]";
    }
    
}
