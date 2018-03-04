/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "eperson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eperson.findAll", query = "SELECT e FROM Eperson e")
    , @NamedQuery(name = "Eperson.findByEpersonId", query = "SELECT e FROM Eperson e WHERE e.epersonId = :epersonId")
    , @NamedQuery(name = "Eperson.findByEmail", query = "SELECT e FROM Eperson e WHERE e.email = :email")
    , @NamedQuery(name = "Eperson.findByPassword", query = "SELECT e FROM Eperson e WHERE e.password = :password")
    , @NamedQuery(name = "Eperson.findByCanLogIn", query = "SELECT e FROM Eperson e WHERE e.canLogIn = :canLogIn")
    , @NamedQuery(name = "Eperson.findByRequireCertificate", query = "SELECT e FROM Eperson e WHERE e.requireCertificate = :requireCertificate")
    , @NamedQuery(name = "Eperson.findBySelfRegistered", query = "SELECT e FROM Eperson e WHERE e.selfRegistered = :selfRegistered")
    , @NamedQuery(name = "Eperson.findByLastActive", query = "SELECT e FROM Eperson e WHERE e.lastActive = :lastActive")
    , @NamedQuery(name = "Eperson.findBySubFrequency", query = "SELECT e FROM Eperson e WHERE e.subFrequency = :subFrequency")
    , @NamedQuery(name = "Eperson.findByNetid", query = "SELECT e FROM Eperson e WHERE e.netid = :netid")
    , @NamedQuery(name = "Eperson.findBySalt", query = "SELECT e FROM Eperson e WHERE e.salt = :salt")
    , @NamedQuery(name = "Eperson.findByDigestAlgorithm", query = "SELECT e FROM Eperson e WHERE e.digestAlgorithm = :digestAlgorithm")})
public class Eperson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "eperson_id")
    private Integer epersonId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "email")
    private String email;
    @Size(max = 128)
    @Column(name = "password")
    private String password;
    @Column(name = "can_log_in")
    private Boolean canLogIn;
    @Column(name = "require_certificate")
    private Boolean requireCertificate;
    @Column(name = "self_registered")
    private Boolean selfRegistered;
    @Column(name = "last_active")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastActive;
    @Column(name = "sub_frequency")
    private Integer subFrequency;
    @Size(max = 64)
    @Column(name = "netid")
    private String netid;
    @Size(max = 32)
    @Column(name = "salt")
    private String salt;
    @Size(max = 16)
    @Column(name = "digest_algorithm")
    private String digestAlgorithm;
    @OneToMany(mappedBy = "epersonId")
    private List<Subscription> subscriptionList;
    @OneToMany(mappedBy = "epersonId")
    private List<Tasklistitem> tasklistitemList;
    @OneToMany(mappedBy = "epersonId")
    private List<Resourcepolicy> resourcepolicyList;
    @OneToMany(mappedBy = "owner")
    private List<Workflowitem> workflowitemList;
    @OneToMany(mappedBy = "submitterId")
    private List<Item> itemList;
    @OneToMany(mappedBy = "epersonId")
    private List<Epersongroup2eperson> epersongroup2epersonList;
    @OneToMany(mappedBy = "epersonId")
    private List<Versionitem> versionitemList;

    public Eperson() {
    }

    public Eperson(Integer epersonId) {
        this.epersonId = epersonId;
    }

    public Integer getEpersonId() {
        return epersonId;
    }

    public void setEpersonId(Integer epersonId) {
        this.epersonId = epersonId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getCanLogIn() {
        return canLogIn;
    }

    public void setCanLogIn(Boolean canLogIn) {
        this.canLogIn = canLogIn;
    }

    public Boolean getRequireCertificate() {
        return requireCertificate;
    }

    public void setRequireCertificate(Boolean requireCertificate) {
        this.requireCertificate = requireCertificate;
    }

    public Boolean getSelfRegistered() {
        return selfRegistered;
    }

    public void setSelfRegistered(Boolean selfRegistered) {
        this.selfRegistered = selfRegistered;
    }

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

    public Integer getSubFrequency() {
        return subFrequency;
    }

    public void setSubFrequency(Integer subFrequency) {
        this.subFrequency = subFrequency;
    }

    public String getNetid() {
        return netid;
    }

    public void setNetid(String netid) {
        this.netid = netid;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    public void setDigestAlgorithm(String digestAlgorithm) {
        this.digestAlgorithm = digestAlgorithm;
    }

    @XmlTransient
    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    @XmlTransient
    public List<Tasklistitem> getTasklistitemList() {
        return tasklistitemList;
    }

    public void setTasklistitemList(List<Tasklistitem> tasklistitemList) {
        this.tasklistitemList = tasklistitemList;
    }

    @XmlTransient
    public List<Resourcepolicy> getResourcepolicyList() {
        return resourcepolicyList;
    }

    public void setResourcepolicyList(List<Resourcepolicy> resourcepolicyList) {
        this.resourcepolicyList = resourcepolicyList;
    }

    @XmlTransient
    public List<Workflowitem> getWorkflowitemList() {
        return workflowitemList;
    }

    public void setWorkflowitemList(List<Workflowitem> workflowitemList) {
        this.workflowitemList = workflowitemList;
    }

    @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @XmlTransient
    public List<Epersongroup2eperson> getEpersongroup2epersonList() {
        return epersongroup2epersonList;
    }

    public void setEpersongroup2epersonList(List<Epersongroup2eperson> epersongroup2epersonList) {
        this.epersongroup2epersonList = epersongroup2epersonList;
    }

    @XmlTransient
    public List<Versionitem> getVersionitemList() {
        return versionitemList;
    }

    public void setVersionitemList(List<Versionitem> versionitemList) {
        this.versionitemList = versionitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (epersonId != null ? epersonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eperson)) {
            return false;
        }
        Eperson other = (Eperson) object;
        if ((this.epersonId == null && other.epersonId != null) || (this.epersonId != null && !this.epersonId.equals(other.epersonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Eperson[ epersonId=" + epersonId + " ]";
    }
    
}
