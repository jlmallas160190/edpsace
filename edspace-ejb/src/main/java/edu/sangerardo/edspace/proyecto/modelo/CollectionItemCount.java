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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "collection_item_count")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CollectionItemCount.findAll", query = "SELECT c FROM CollectionItemCount c")
    , @NamedQuery(name = "CollectionItemCount.findByCollectionId", query = "SELECT c FROM CollectionItemCount c WHERE c.collectionId = :collectionId")
    , @NamedQuery(name = "CollectionItemCount.findByCount", query = "SELECT c FROM CollectionItemCount c WHERE c.count = :count")})
public class CollectionItemCount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "collection_id")
    private Integer collectionId;
    @Column(name = "count")
    private Integer count;
    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Collection collection;

    public CollectionItemCount() {
    }

    public CollectionItemCount(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionId != null ? collectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollectionItemCount)) {
            return false;
        }
        CollectionItemCount other = (CollectionItemCount) object;
        if ((this.collectionId == null && other.collectionId != null) || (this.collectionId != null && !this.collectionId.equals(other.collectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.CollectionItemCount[ collectionId=" + collectionId + " ]";
    }
    
}
