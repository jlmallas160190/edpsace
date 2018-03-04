/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "most_recent_checksum")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MostRecentChecksum.findAll", query = "SELECT m FROM MostRecentChecksum m")
    , @NamedQuery(name = "MostRecentChecksum.findByBitstreamId", query = "SELECT m FROM MostRecentChecksum m WHERE m.bitstreamId = :bitstreamId")
    , @NamedQuery(name = "MostRecentChecksum.findByToBeProcessed", query = "SELECT m FROM MostRecentChecksum m WHERE m.toBeProcessed = :toBeProcessed")
    , @NamedQuery(name = "MostRecentChecksum.findByExpectedChecksum", query = "SELECT m FROM MostRecentChecksum m WHERE m.expectedChecksum = :expectedChecksum")
    , @NamedQuery(name = "MostRecentChecksum.findByCurrentChecksum", query = "SELECT m FROM MostRecentChecksum m WHERE m.currentChecksum = :currentChecksum")
    , @NamedQuery(name = "MostRecentChecksum.findByLastProcessStartDate", query = "SELECT m FROM MostRecentChecksum m WHERE m.lastProcessStartDate = :lastProcessStartDate")
    , @NamedQuery(name = "MostRecentChecksum.findByLastProcessEndDate", query = "SELECT m FROM MostRecentChecksum m WHERE m.lastProcessEndDate = :lastProcessEndDate")
    , @NamedQuery(name = "MostRecentChecksum.findByChecksumAlgorithm", query = "SELECT m FROM MostRecentChecksum m WHERE m.checksumAlgorithm = :checksumAlgorithm")
    , @NamedQuery(name = "MostRecentChecksum.findByMatchedPrevChecksum", query = "SELECT m FROM MostRecentChecksum m WHERE m.matchedPrevChecksum = :matchedPrevChecksum")})
public class MostRecentChecksum implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "bitstream_id")
    private Integer bitstreamId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_be_processed")
    private boolean toBeProcessed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "expected_checksum")
    private String expectedChecksum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "current_checksum")
    private String currentChecksum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_process_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastProcessStartDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_process_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastProcessEndDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "checksum_algorithm")
    private String checksumAlgorithm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "matched_prev_checksum")
    private boolean matchedPrevChecksum;
    @JoinColumn(name = "bitstream_id", referencedColumnName = "bitstream_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Bitstream bitstream;
    @JoinColumn(name = "result", referencedColumnName = "result_code")
    @ManyToOne
    private ChecksumResults result;

    public MostRecentChecksum() {
    }

    public MostRecentChecksum(Integer bitstreamId) {
        this.bitstreamId = bitstreamId;
    }

    public MostRecentChecksum(Integer bitstreamId, boolean toBeProcessed, String expectedChecksum, String currentChecksum, Date lastProcessStartDate, Date lastProcessEndDate, String checksumAlgorithm, boolean matchedPrevChecksum) {
        this.bitstreamId = bitstreamId;
        this.toBeProcessed = toBeProcessed;
        this.expectedChecksum = expectedChecksum;
        this.currentChecksum = currentChecksum;
        this.lastProcessStartDate = lastProcessStartDate;
        this.lastProcessEndDate = lastProcessEndDate;
        this.checksumAlgorithm = checksumAlgorithm;
        this.matchedPrevChecksum = matchedPrevChecksum;
    }

    public Integer getBitstreamId() {
        return bitstreamId;
    }

    public void setBitstreamId(Integer bitstreamId) {
        this.bitstreamId = bitstreamId;
    }

    public boolean getToBeProcessed() {
        return toBeProcessed;
    }

    public void setToBeProcessed(boolean toBeProcessed) {
        this.toBeProcessed = toBeProcessed;
    }

    public String getExpectedChecksum() {
        return expectedChecksum;
    }

    public void setExpectedChecksum(String expectedChecksum) {
        this.expectedChecksum = expectedChecksum;
    }

    public String getCurrentChecksum() {
        return currentChecksum;
    }

    public void setCurrentChecksum(String currentChecksum) {
        this.currentChecksum = currentChecksum;
    }

    public Date getLastProcessStartDate() {
        return lastProcessStartDate;
    }

    public void setLastProcessStartDate(Date lastProcessStartDate) {
        this.lastProcessStartDate = lastProcessStartDate;
    }

    public Date getLastProcessEndDate() {
        return lastProcessEndDate;
    }

    public void setLastProcessEndDate(Date lastProcessEndDate) {
        this.lastProcessEndDate = lastProcessEndDate;
    }

    public String getChecksumAlgorithm() {
        return checksumAlgorithm;
    }

    public void setChecksumAlgorithm(String checksumAlgorithm) {
        this.checksumAlgorithm = checksumAlgorithm;
    }

    public boolean getMatchedPrevChecksum() {
        return matchedPrevChecksum;
    }

    public void setMatchedPrevChecksum(boolean matchedPrevChecksum) {
        this.matchedPrevChecksum = matchedPrevChecksum;
    }

    public Bitstream getBitstream() {
        return bitstream;
    }

    public void setBitstream(Bitstream bitstream) {
        this.bitstream = bitstream;
    }

    public ChecksumResults getResult() {
        return result;
    }

    public void setResult(ChecksumResults result) {
        this.result = result;
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
        if (!(object instanceof MostRecentChecksum)) {
            return false;
        }
        MostRecentChecksum other = (MostRecentChecksum) object;
        if ((this.bitstreamId == null && other.bitstreamId != null) || (this.bitstreamId != null && !this.bitstreamId.equals(other.bitstreamId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.MostRecentChecksum[ bitstreamId=" + bitstreamId + " ]";
    }
    
}
