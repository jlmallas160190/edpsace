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
@Table(name = "checksum_results")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChecksumResults.findAll", query = "SELECT c FROM ChecksumResults c")
    , @NamedQuery(name = "ChecksumResults.findByResultCode", query = "SELECT c FROM ChecksumResults c WHERE c.resultCode = :resultCode")
    , @NamedQuery(name = "ChecksumResults.findByResultDescription", query = "SELECT c FROM ChecksumResults c WHERE c.resultDescription = :resultDescription")})
public class ChecksumResults implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "result_code")
    private String resultCode;
    @Size(max = 2147483647)
    @Column(name = "result_description")
    private String resultDescription;
    @OneToMany(mappedBy = "result")
    private List<MostRecentChecksum> mostRecentChecksumList;
    @OneToMany(mappedBy = "result")
    private List<ChecksumHistory> checksumHistoryList;

    public ChecksumResults() {
    }

    public ChecksumResults(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDescription() {
        return resultDescription;
    }

    public void setResultDescription(String resultDescription) {
        this.resultDescription = resultDescription;
    }

    @XmlTransient
    public List<MostRecentChecksum> getMostRecentChecksumList() {
        return mostRecentChecksumList;
    }

    public void setMostRecentChecksumList(List<MostRecentChecksum> mostRecentChecksumList) {
        this.mostRecentChecksumList = mostRecentChecksumList;
    }

    @XmlTransient
    public List<ChecksumHistory> getChecksumHistoryList() {
        return checksumHistoryList;
    }

    public void setChecksumHistoryList(List<ChecksumHistory> checksumHistoryList) {
        this.checksumHistoryList = checksumHistoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resultCode != null ? resultCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChecksumResults)) {
            return false;
        }
        ChecksumResults other = (ChecksumResults) object;
        if ((this.resultCode == null && other.resultCode != null) || (this.resultCode != null && !this.resultCode.equals(other.resultCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.ChecksumResults[ resultCode=" + resultCode + " ]";
    }
    
}
