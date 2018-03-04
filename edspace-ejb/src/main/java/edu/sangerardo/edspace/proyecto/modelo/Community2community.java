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
@Table(name = "community2community")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Community2community.findAll", query = "SELECT c FROM Community2community c")
    , @NamedQuery(name = "Community2community.findById", query = "SELECT c FROM Community2community c WHERE c.id = :id")
    ,
  @NamedQuery(name = "Community2community.findByCommunity", query = "SELECT c FROM Community2community c WHERE c.parentCommId = :id")})
public class Community2community implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "child_comm_id", referencedColumnName = "community_id")
    @ManyToOne
    private Community childCommId;
    @JoinColumn(name = "parent_comm_id", referencedColumnName = "community_id")
    @ManyToOne
    private Community parentCommId;

    public Community2community() {
    }

    public Community2community(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Community getChildCommId() {
        return childCommId;
    }

    public void setChildCommId(Community childCommId) {
        this.childCommId = childCommId;
    }

    public Community getParentCommId() {
        return parentCommId;
    }

    public void setParentCommId(Community parentCommId) {
        this.parentCommId = parentCommId;
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
        if (!(object instanceof Community2community)) {
            return false;
        }
        Community2community other = (Community2community) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Community2community[ id=" + id + " ]";
    }

}
