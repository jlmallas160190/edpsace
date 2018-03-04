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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "group2group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Group2group.findAll", query = "SELECT g FROM Group2group g")
    , @NamedQuery(name = "Group2group.findById", query = "SELECT g FROM Group2group g WHERE g.id = :id")})
public class Group2group implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "child_id", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup childId;
    @JoinColumn(name = "parent_id", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup parentId;

    public Group2group() {
    }

    public Group2group(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Epersongroup getChildId() {
        return childId;
    }

    public void setChildId(Epersongroup childId) {
        this.childId = childId;
    }

    public Epersongroup getParentId() {
        return parentId;
    }

    public void setParentId(Epersongroup parentId) {
        this.parentId = parentId;
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
        if (!(object instanceof Group2group)) {
            return false;
        }
        Group2group other = (Group2group) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Group2group[ id=" + id + " ]";
    }
    
}
