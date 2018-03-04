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
@Table(name = "resourcepolicy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resourcepolicy.findAll", query = "SELECT r FROM Resourcepolicy r")
    , @NamedQuery(name = "Resourcepolicy.findByPolicyId", query = "SELECT r FROM Resourcepolicy r WHERE r.policyId = :policyId")
    , @NamedQuery(name = "Resourcepolicy.findByResourceTypeId", query = "SELECT r FROM Resourcepolicy r WHERE r.resourceTypeId = :resourceTypeId")
    , @NamedQuery(name = "Resourcepolicy.findByResourceId", query = "SELECT r FROM Resourcepolicy r WHERE r.resourceId = :resourceId")
    , @NamedQuery(name = "Resourcepolicy.findByActionId", query = "SELECT r FROM Resourcepolicy r WHERE r.actionId = :actionId")
    , @NamedQuery(name = "Resourcepolicy.findByStartDate", query = "SELECT r FROM Resourcepolicy r WHERE r.startDate = :startDate")
    , @NamedQuery(name = "Resourcepolicy.findByEndDate", query = "SELECT r FROM Resourcepolicy r WHERE r.endDate = :endDate")
    , @NamedQuery(name = "Resourcepolicy.findByRpname", query = "SELECT r FROM Resourcepolicy r WHERE r.rpname = :rpname")
    , @NamedQuery(name = "Resourcepolicy.findByRptype", query = "SELECT r FROM Resourcepolicy r WHERE r.rptype = :rptype")
    , @NamedQuery(name = "Resourcepolicy.findByRpdescription", query = "SELECT r FROM Resourcepolicy r WHERE r.rpdescription = :rpdescription")
    ,
@NamedQuery(name = "Resourcepolicy.findByResource", query = "SELECT r FROM Resourcepolicy r WHERE r.resourceId=?1 and r.resourceTypeId = ?2")})
public class Resourcepolicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "policy_id")
    private Integer policyId;
    @Column(name = "resource_type_id")
    private Integer resourceTypeId;
    @Column(name = "resource_id")
    private Integer resourceId;
    @Column(name = "action_id")
    private Integer actionId;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Size(max = 30)
    @Column(name = "rpname")
    private String rpname;
    @Size(max = 30)
    @Column(name = "rptype")
    private String rptype;
    @Size(max = 100)
    @Column(name = "rpdescription")
    private String rpdescription;
    @JoinColumn(name = "eperson_id", referencedColumnName = "eperson_id")
    @ManyToOne
    private Eperson epersonId;
    @JoinColumn(name = "epersongroup_id", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup epersongroupId;

    public Resourcepolicy() {
    }

    public Resourcepolicy(Integer policyId) {
        this.policyId = policyId;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public Integer getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(Integer resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRpname() {
        return rpname;
    }

    public void setRpname(String rpname) {
        this.rpname = rpname;
    }

    public String getRptype() {
        return rptype;
    }

    public void setRptype(String rptype) {
        this.rptype = rptype;
    }

    public String getRpdescription() {
        return rpdescription;
    }

    public void setRpdescription(String rpdescription) {
        this.rpdescription = rpdescription;
    }

    public Eperson getEpersonId() {
        return epersonId;
    }

    public void setEpersonId(Eperson epersonId) {
        this.epersonId = epersonId;
    }

    public Epersongroup getEpersongroupId() {
        return epersongroupId;
    }

    public void setEpersongroupId(Epersongroup epersongroupId) {
        this.epersongroupId = epersongroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (policyId != null ? policyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resourcepolicy)) {
            return false;
        }
        Resourcepolicy other = (Resourcepolicy) object;
        if ((this.policyId == null && other.policyId != null) || (this.policyId != null && !this.policyId.equals(other.policyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Resourcepolicy[ policyId=" + policyId + " ]";
    }

}
