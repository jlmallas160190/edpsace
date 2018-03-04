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
@Table(name = "item2bundle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item2bundle.findAll", query = "SELECT i FROM Item2bundle i")
    , @NamedQuery(name = "Item2bundle.findById", query = "SELECT i FROM Item2bundle i WHERE i.id = :id")})
public class Item2bundle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "bundle_id", referencedColumnName = "bundle_id")
    @ManyToOne
    private Bundle bundleId;
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @ManyToOne
    private Item itemId;

    public Item2bundle() {
    }

    public Item2bundle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bundle getBundleId() {
        return bundleId;
    }

    public void setBundleId(Bundle bundleId) {
        this.bundleId = bundleId;
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
        if (!(object instanceof Item2bundle)) {
            return false;
        }
        Item2bundle other = (Item2bundle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Item2bundle[ id=" + id + " ]";
    }
    
}
