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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "bitstreamformatregistry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bitstreamformatregistry.findAll", query = "SELECT b FROM Bitstreamformatregistry b")
    , @NamedQuery(name = "Bitstreamformatregistry.findByBitstreamFormatId", query = "SELECT b FROM Bitstreamformatregistry b WHERE b.bitstreamFormatId = :bitstreamFormatId")
    , @NamedQuery(name = "Bitstreamformatregistry.findByMimetype", query = "SELECT b FROM Bitstreamformatregistry b WHERE b.mimetype = :mimetype")
    , @NamedQuery(name = "Bitstreamformatregistry.findByShortDescription", query = "SELECT b FROM Bitstreamformatregistry b WHERE b.shortDescription = :shortDescription")
    , @NamedQuery(name = "Bitstreamformatregistry.findByDescription", query = "SELECT b FROM Bitstreamformatregistry b WHERE b.description = :description")
    , @NamedQuery(name = "Bitstreamformatregistry.findBySupportLevel", query = "SELECT b FROM Bitstreamformatregistry b WHERE b.supportLevel = :supportLevel")
    , @NamedQuery(name = "Bitstreamformatregistry.findByInternal", query = "SELECT b FROM Bitstreamformatregistry b WHERE b.internal = :internal")})
public class Bitstreamformatregistry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bitstream_format_id")
    private Integer bitstreamFormatId;
    @Size(max = 256)
    @Column(name = "mimetype")
    private String mimetype;
    @Size(max = 128)
    @Column(name = "short_description")
    private String shortDescription;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @Column(name = "support_level")
    private Integer supportLevel;
    @Column(name = "internal")
    private Boolean internal;
    @OneToMany(mappedBy = "bitstreamFormatId")
    private List<Fileextension> fileextensionList;
    @OneToMany(mappedBy = "bitstreamFormatId")
    private List<Bitstream> bitstreamList;

    public Bitstreamformatregistry() {
    }

    public Bitstreamformatregistry(Integer bitstreamFormatId) {
        this.bitstreamFormatId = bitstreamFormatId;
    }

    public Integer getBitstreamFormatId() {
        return bitstreamFormatId;
    }

    public void setBitstreamFormatId(Integer bitstreamFormatId) {
        this.bitstreamFormatId = bitstreamFormatId;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSupportLevel() {
        return supportLevel;
    }

    public void setSupportLevel(Integer supportLevel) {
        this.supportLevel = supportLevel;
    }

    public Boolean getInternal() {
        return internal;
    }

    public void setInternal(Boolean internal) {
        this.internal = internal;
    }

    @XmlTransient
    public List<Fileextension> getFileextensionList() {
        return fileextensionList;
    }

    public void setFileextensionList(List<Fileextension> fileextensionList) {
        this.fileextensionList = fileextensionList;
    }

    @XmlTransient
    public List<Bitstream> getBitstreamList() {
        return bitstreamList;
    }

    public void setBitstreamList(List<Bitstream> bitstreamList) {
        this.bitstreamList = bitstreamList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bitstreamFormatId != null ? bitstreamFormatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitstreamformatregistry)) {
            return false;
        }
        Bitstreamformatregistry other = (Bitstreamformatregistry) object;
        if ((this.bitstreamFormatId == null && other.bitstreamFormatId != null) || (this.bitstreamFormatId != null && !this.bitstreamFormatId.equals(other.bitstreamFormatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Bitstreamformatregistry[ bitstreamFormatId=" + bitstreamFormatId + " ]";
    }
    
}
