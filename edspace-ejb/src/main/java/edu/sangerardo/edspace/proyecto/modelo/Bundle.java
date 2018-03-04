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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bundle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bundle.findAll", query = "SELECT b FROM Bundle b")
    , @NamedQuery(name = "Bundle.findByBundleId", query = "SELECT b FROM Bundle b WHERE b.bundleId = :bundleId")})
public class Bundle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bundle_id")
    private Integer bundleId;
    @OneToMany(mappedBy = "bundleId")
    private List<Bundle2bitstream> bundle2bitstreamList;
    @OneToMany(mappedBy = "bundleId")
    private List<Item2bundle> item2bundleList;
    @JoinColumn(name = "primary_bitstream_id", referencedColumnName = "bitstream_id")
    @ManyToOne
    private Bitstream primaryBitstreamId;

    public Bundle() {
    }

    public Bundle(Integer bundleId) {
        this.bundleId = bundleId;
    }

    public Integer getBundleId() {
        return bundleId;
    }

    public void setBundleId(Integer bundleId) {
        this.bundleId = bundleId;
    }

    @XmlTransient
    public List<Bundle2bitstream> getBundle2bitstreamList() {
        return bundle2bitstreamList;
    }

    public void setBundle2bitstreamList(List<Bundle2bitstream> bundle2bitstreamList) {
        this.bundle2bitstreamList = bundle2bitstreamList;
    }

    @XmlTransient
    public List<Item2bundle> getItem2bundleList() {
        return item2bundleList;
    }

    public void setItem2bundleList(List<Item2bundle> item2bundleList) {
        this.item2bundleList = item2bundleList;
    }

    public Bitstream getPrimaryBitstreamId() {
        return primaryBitstreamId;
    }

    public void setPrimaryBitstreamId(Bitstream primaryBitstreamId) {
        this.primaryBitstreamId = primaryBitstreamId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bundleId != null ? bundleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bundle)) {
            return false;
        }
        Bundle other = (Bundle) object;
        if ((this.bundleId == null && other.bundleId != null) || (this.bundleId != null && !this.bundleId.equals(other.bundleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Bundle[ bundleId=" + bundleId + " ]";
    }
    
}
