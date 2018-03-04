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
@Table(name = "bundle2bitstream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bundle2bitstream.findAll", query = "SELECT b FROM Bundle2bitstream b")
    , @NamedQuery(name = "Bundle2bitstream.findById", query = "SELECT b FROM Bundle2bitstream b WHERE b.id = :id")
    , @NamedQuery(name = "Bundle2bitstream.findByBitstreamOrder", query = "SELECT b FROM Bundle2bitstream b WHERE b.bitstreamOrder = :bitstreamOrder")})
public class Bundle2bitstream implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "bitstream_order")
    private Integer bitstreamOrder;
    @JoinColumn(name = "bitstream_id", referencedColumnName = "bitstream_id")
    @ManyToOne
    private Bitstream bitstreamId;
    @JoinColumn(name = "bundle_id", referencedColumnName = "bundle_id")
    @ManyToOne
    private Bundle bundleId;

    public Bundle2bitstream() {
    }

    public Bundle2bitstream(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBitstreamOrder() {
        return bitstreamOrder;
    }

    public void setBitstreamOrder(Integer bitstreamOrder) {
        this.bitstreamOrder = bitstreamOrder;
    }

    public Bitstream getBitstreamId() {
        return bitstreamId;
    }

    public void setBitstreamId(Bitstream bitstreamId) {
        this.bitstreamId = bitstreamId;
    }

    public Bundle getBundleId() {
        return bundleId;
    }

    public void setBundleId(Bundle bundleId) {
        this.bundleId = bundleId;
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
        if (!(object instanceof Bundle2bitstream)) {
            return false;
        }
        Bundle2bitstream other = (Bundle2bitstream) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Bundle2bitstream[ id=" + id + " ]";
    }
    
}
