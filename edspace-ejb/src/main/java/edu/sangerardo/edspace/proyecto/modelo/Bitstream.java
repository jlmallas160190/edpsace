/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.modelo;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "bitstream")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bitstream.findAll", query = "SELECT b FROM Bitstream b")
    , @NamedQuery(name = "Bitstream.findByBitstreamId", query = "SELECT b FROM Bitstream b WHERE b.bitstreamId = :bitstreamId")
    , @NamedQuery(name = "Bitstream.findByChecksum", query = "SELECT b FROM Bitstream b WHERE b.checksum = :checksum")
    , @NamedQuery(name = "Bitstream.findByChecksumAlgorithm", query = "SELECT b FROM Bitstream b WHERE b.checksumAlgorithm = :checksumAlgorithm")
    , @NamedQuery(name = "Bitstream.findByInternalId", query = "SELECT b FROM Bitstream b WHERE b.internalId = :internalId")
    , @NamedQuery(name = "Bitstream.findByDeleted", query = "SELECT b FROM Bitstream b WHERE b.deleted = :deleted")
    , @NamedQuery(name = "Bitstream.findByStoreNumber", query = "SELECT b FROM Bitstream b WHERE b.storeNumber = :storeNumber")
    , @NamedQuery(name = "Bitstream.findBySequenceId", query = "SELECT b FROM Bitstream b WHERE b.sequenceId = :sequenceId")
    , @NamedQuery(name = "Bitstream.findBySizeBytes", query = "SELECT b FROM Bitstream b WHERE b.sizeBytes = :sizeBytes")})
public class Bitstream implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bitstream_id")
    private Integer bitstreamId;
    @Size(max = 64)
    @Column(name = "checksum")
    private String checksum;
    @Size(max = 32)
    @Column(name = "checksum_algorithm")
    private String checksumAlgorithm;
    @Size(max = 256)
    @Column(name = "internal_id")
    private String internalId;
    @Column(name = "deleted")
    private Boolean deleted;
    @Column(name = "store_number")
    private Integer storeNumber;
    @Column(name = "sequence_id")
    private Integer sequenceId;
    @Column(name = "size_bytes")
    private BigInteger sizeBytes;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bitstream")
    private MostRecentChecksum mostRecentChecksum;
    @OneToMany(mappedBy = "bitstreamId")
    private List<Bundle2bitstream> bundle2bitstreamList;
    @OneToMany(mappedBy = "primaryBitstreamId")
    private List<Bundle> bundleList;
    @OneToMany(mappedBy = "logoBitstreamId")
    private List<Collection> collectionList;
    @OneToMany(mappedBy = "logoBitstreamId")
    private List<Community> communityList;
    @JoinColumn(name = "bitstream_format_id", referencedColumnName = "bitstream_format_id")
    @ManyToOne
    private Bitstreamformatregistry bitstreamFormatId;

    public Bitstream() {
    }

    public Bitstream(Integer bitstreamId) {
        this.bitstreamId = bitstreamId;
    }

    public Integer getBitstreamId() {
        return bitstreamId;
    }

    public void setBitstreamId(Integer bitstreamId) {
        this.bitstreamId = bitstreamId;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public String getChecksumAlgorithm() {
        return checksumAlgorithm;
    }

    public void setChecksumAlgorithm(String checksumAlgorithm) {
        this.checksumAlgorithm = checksumAlgorithm;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(Integer storeNumber) {
        this.storeNumber = storeNumber;
    }

    public Integer getSequenceId() {
        return sequenceId;
    }

    public void setSequenceId(Integer sequenceId) {
        this.sequenceId = sequenceId;
    }

    public BigInteger getSizeBytes() {
        return sizeBytes;
    }

    public void setSizeBytes(BigInteger sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    public MostRecentChecksum getMostRecentChecksum() {
        return mostRecentChecksum;
    }

    public void setMostRecentChecksum(MostRecentChecksum mostRecentChecksum) {
        this.mostRecentChecksum = mostRecentChecksum;
    }

    @XmlTransient
    public List<Bundle2bitstream> getBundle2bitstreamList() {
        return bundle2bitstreamList;
    }

    public void setBundle2bitstreamList(List<Bundle2bitstream> bundle2bitstreamList) {
        this.bundle2bitstreamList = bundle2bitstreamList;
    }

    @XmlTransient
    public List<Bundle> getBundleList() {
        return bundleList;
    }

    public void setBundleList(List<Bundle> bundleList) {
        this.bundleList = bundleList;
    }

    @XmlTransient
    public List<Collection> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<Collection> collectionList) {
        this.collectionList = collectionList;
    }

    @XmlTransient
    public List<Community> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(List<Community> communityList) {
        this.communityList = communityList;
    }

    public Bitstreamformatregistry getBitstreamFormatId() {
        return bitstreamFormatId;
    }

    public void setBitstreamFormatId(Bitstreamformatregistry bitstreamFormatId) {
        this.bitstreamFormatId = bitstreamFormatId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bitstreamId != null ? bitstreamId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitstream)) {
            return false;
        }
        Bitstream other = (Bitstream) object;
        if ((this.bitstreamId == null && other.bitstreamId != null) || (this.bitstreamId != null && !this.bitstreamId.equals(other.bitstreamId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Bitstream[ bitstreamId=" + bitstreamId + " ]";
    }
    
}
