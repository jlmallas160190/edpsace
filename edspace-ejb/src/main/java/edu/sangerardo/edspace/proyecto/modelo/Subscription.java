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
@Table(name = "subscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subscription.findAll", query = "SELECT s FROM Subscription s")
    , @NamedQuery(name = "Subscription.findBySubscriptionId", query = "SELECT s FROM Subscription s WHERE s.subscriptionId = :subscriptionId")})
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "subscription_id")
    private Integer subscriptionId;
    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id")
    @ManyToOne
    private Collection collectionId;
    @JoinColumn(name = "eperson_id", referencedColumnName = "eperson_id")
    @ManyToOne
    private Eperson epersonId;

    public Subscription() {
    }

    public Subscription(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Collection getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Collection collectionId) {
        this.collectionId = collectionId;
    }

    public Eperson getEpersonId() {
        return epersonId;
    }

    public void setEpersonId(Eperson epersonId) {
        this.epersonId = epersonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subscriptionId != null ? subscriptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subscription)) {
            return false;
        }
        Subscription other = (Subscription) object;
        if ((this.subscriptionId == null && other.subscriptionId != null) || (this.subscriptionId != null && !this.subscriptionId.equals(other.subscriptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Subscription[ subscriptionId=" + subscriptionId + " ]";
    }
    
}
