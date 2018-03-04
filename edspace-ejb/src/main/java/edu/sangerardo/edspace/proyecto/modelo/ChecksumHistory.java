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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "checksum_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChecksumHistory.findAll", query = "SELECT c FROM ChecksumHistory c")
    , @NamedQuery(name = "ChecksumHistory.findByCheckId", query = "SELECT c FROM ChecksumHistory c WHERE c.checkId = :checkId")
    , @NamedQuery(name = "ChecksumHistory.findByBitstreamId", query = "SELECT c FROM ChecksumHistory c WHERE c.bitstreamId = :bitstreamId")
    , @NamedQuery(name = "ChecksumHistory.findByProcessStartDate", query = "SELECT c FROM ChecksumHistory c WHERE c.processStartDate = :processStartDate")
    , @NamedQuery(name = "ChecksumHistory.findByProcessEndDate", query = "SELECT c FROM ChecksumHistory c WHERE c.processEndDate = :processEndDate")
    , @NamedQuery(name = "ChecksumHistory.findByChecksumExpected", query = "SELECT c FROM ChecksumHistory c WHERE c.checksumExpected = :checksumExpected")
    , @NamedQuery(name = "ChecksumHistory.findByChecksumCalculated", query = "SELECT c FROM ChecksumHistory c WHERE c.checksumCalculated = :checksumCalculated")})
public class ChecksumHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "check_id")
    private Long checkId;
    @Column(name = "bitstream_id")
    private Integer bitstreamId;
    @Column(name = "process_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processStartDate;
    @Column(name = "process_end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processEndDate;
    @Size(max = 2147483647)
    @Column(name = "checksum_expected")
    private String checksumExpected;
    @Size(max = 2147483647)
    @Column(name = "checksum_calculated")
    private String checksumCalculated;
    @JoinColumn(name = "result", referencedColumnName = "result_code")
    @ManyToOne
    private ChecksumResults result;

    public ChecksumHistory() {
    }

    public ChecksumHistory(Long checkId) {
        this.checkId = checkId;
    }

    public Long getCheckId() {
        return checkId;
    }

    public void setCheckId(Long checkId) {
        this.checkId = checkId;
    }

    public Integer getBitstreamId() {
        return bitstreamId;
    }

    public void setBitstreamId(Integer bitstreamId) {
        this.bitstreamId = bitstreamId;
    }

    public Date getProcessStartDate() {
        return processStartDate;
    }

    public void setProcessStartDate(Date processStartDate) {
        this.processStartDate = processStartDate;
    }

    public Date getProcessEndDate() {
        return processEndDate;
    }

    public void setProcessEndDate(Date processEndDate) {
        this.processEndDate = processEndDate;
    }

    public String getChecksumExpected() {
        return checksumExpected;
    }

    public void setChecksumExpected(String checksumExpected) {
        this.checksumExpected = checksumExpected;
    }

    public String getChecksumCalculated() {
        return checksumCalculated;
    }

    public void setChecksumCalculated(String checksumCalculated) {
        this.checksumCalculated = checksumCalculated;
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
        hash += (checkId != null ? checkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecksumHistory)) {
            return false;
        }
        ChecksumHistory other = (ChecksumHistory) object;
        if ((this.checkId == null && other.checkId != null) || (this.checkId != null && !this.checkId.equals(other.checkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.ChecksumHistory[ checkId=" + checkId + " ]";
    }
    
}
