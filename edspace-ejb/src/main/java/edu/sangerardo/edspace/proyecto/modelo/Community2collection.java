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
@Table(name = "community2collection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Community2collection.findAll", query = "SELECT c FROM Community2collection c")
    , @NamedQuery(name = "Community2collection.findById", query = "SELECT c FROM Community2collection c WHERE c.id = :id")})
public class Community2collection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id")
    @ManyToOne
    private Collection collectionId;
    @JoinColumn(name = "community_id", referencedColumnName = "community_id")
    @ManyToOne
    private Community communityId;

    public Community2collection() {
    }

    public Community2collection(Integer id) {
        this.id = id;
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

    public Community getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Community communityId) {
        this.communityId = communityId;
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
        if (!(object instanceof Community2collection)) {
            return false;
        }
        Community2collection other = (Community2collection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Community2collection[ id=" + id + " ]";
    }
    
}
