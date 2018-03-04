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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "requestitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requestitem.findAll", query = "SELECT r FROM Requestitem r")
    , @NamedQuery(name = "Requestitem.findByRequestitemId", query = "SELECT r FROM Requestitem r WHERE r.requestitemId = :requestitemId")
    , @NamedQuery(name = "Requestitem.findByToken", query = "SELECT r FROM Requestitem r WHERE r.token = :token")
    , @NamedQuery(name = "Requestitem.findByItemId", query = "SELECT r FROM Requestitem r WHERE r.itemId = :itemId")
    , @NamedQuery(name = "Requestitem.findByBitstreamId", query = "SELECT r FROM Requestitem r WHERE r.bitstreamId = :bitstreamId")
    , @NamedQuery(name = "Requestitem.findByAllfiles", query = "SELECT r FROM Requestitem r WHERE r.allfiles = :allfiles")
    , @NamedQuery(name = "Requestitem.findByRequestEmail", query = "SELECT r FROM Requestitem r WHERE r.requestEmail = :requestEmail")
    , @NamedQuery(name = "Requestitem.findByRequestName", query = "SELECT r FROM Requestitem r WHERE r.requestName = :requestName")
    , @NamedQuery(name = "Requestitem.findByRequestDate", query = "SELECT r FROM Requestitem r WHERE r.requestDate = :requestDate")
    , @NamedQuery(name = "Requestitem.findByAcceptRequest", query = "SELECT r FROM Requestitem r WHERE r.acceptRequest = :acceptRequest")
    , @NamedQuery(name = "Requestitem.findByDecisionDate", query = "SELECT r FROM Requestitem r WHERE r.decisionDate = :decisionDate")
    , @NamedQuery(name = "Requestitem.findByExpires", query = "SELECT r FROM Requestitem r WHERE r.expires = :expires")
    , @NamedQuery(name = "Requestitem.findByRequestMessage", query = "SELECT r FROM Requestitem r WHERE r.requestMessage = :requestMessage")})
public class Requestitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "requestitem_id")
    private Integer requestitemId;
    @Size(max = 48)
    @Column(name = "token")
    private String token;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "bitstream_id")
    private Integer bitstreamId;
    @Column(name = "allfiles")
    private Boolean allfiles;
    @Size(max = 64)
    @Column(name = "request_email")
    private String requestEmail;
    @Size(max = 64)
    @Column(name = "request_name")
    private String requestName;
    @Column(name = "request_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date requestDate;
    @Column(name = "accept_request")
    private Boolean acceptRequest;
    @Column(name = "decision_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date decisionDate;
    @Column(name = "expires")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;
    @Size(max = 2147483647)
    @Column(name = "request_message")
    private String requestMessage;

    public Requestitem() {
    }

    public Requestitem(Integer requestitemId) {
        this.requestitemId = requestitemId;
    }

    public Integer getRequestitemId() {
        return requestitemId;
    }

    public void setRequestitemId(Integer requestitemId) {
        this.requestitemId = requestitemId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getBitstreamId() {
        return bitstreamId;
    }

    public void setBitstreamId(Integer bitstreamId) {
        this.bitstreamId = bitstreamId;
    }

    public Boolean getAllfiles() {
        return allfiles;
    }

    public void setAllfiles(Boolean allfiles) {
        this.allfiles = allfiles;
    }

    public String getRequestEmail() {
        return requestEmail;
    }

    public void setRequestEmail(String requestEmail) {
        this.requestEmail = requestEmail;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Boolean getAcceptRequest() {
        return acceptRequest;
    }

    public void setAcceptRequest(Boolean acceptRequest) {
        this.acceptRequest = acceptRequest;
    }

    public Date getDecisionDate() {
        return decisionDate;
    }

    public void setDecisionDate(Date decisionDate) {
        this.decisionDate = decisionDate;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestitemId != null ? requestitemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requestitem)) {
            return false;
        }
        Requestitem other = (Requestitem) object;
        if ((this.requestitemId == null && other.requestitemId != null) || (this.requestitemId != null && !this.requestitemId.equals(other.requestitemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Requestitem[ requestitemId=" + requestitemId + " ]";
    }
    
}
