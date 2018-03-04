/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.modelo;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "collection")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Collection.findAll", query = "SELECT c FROM Collection c")
    , @NamedQuery(name = "Collection.findByCollectionId", query = "SELECT c FROM Collection c WHERE c.collectionId = :collectionId")})
public class Collection implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "collection_id")
    private Integer collectionId;
    @OneToMany(mappedBy = "collectionId")
    private List<Community2collection> community2collectionList;
    @OneToMany(mappedBy = "collectionId")
    private List<Subscription> subscriptionList;
    @OneToMany(mappedBy = "collectionId")
    private List<Workspaceitem> workspaceitemList;
    @OneToMany(mappedBy = "collectionId")
    private List<Collection2item> collection2itemList;
    @OneToMany(mappedBy = "collectionId")
    private List<Workflowitem> workflowitemList;
    @OneToMany(mappedBy = "collectionId")
    private List<HarvestedCollection> harvestedCollectionList;
    @JoinColumn(name = "logo_bitstream_id", referencedColumnName = "bitstream_id")
    @ManyToOne
    private Bitstream logoBitstreamId;
    @JoinColumn(name = "admin", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup admin;
    @JoinColumn(name = "submitter", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup submitter;
    @JoinColumn(name = "workflow_step_1", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup workflowStep1;
    @JoinColumn(name = "workflow_step_2", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup workflowStep2;
    @JoinColumn(name = "workflow_step_3", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup workflowStep3;
    @JoinColumn(name = "template_item_id", referencedColumnName = "item_id")
    @ManyToOne
    private Item templateItemId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "collection")
    private CollectionItemCount collectionItemCount;

    public Collection() {
    }

    public Collection(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    @XmlTransient
    public List<Community2collection> getCommunity2collectionList() {
        return community2collectionList;
    }

    public void setCommunity2collectionList(List<Community2collection> community2collectionList) {
        this.community2collectionList = community2collectionList;
    }

    @XmlTransient
    public List<Subscription> getSubscriptionList() {
        return subscriptionList;
    }

    public void setSubscriptionList(List<Subscription> subscriptionList) {
        this.subscriptionList = subscriptionList;
    }

    @XmlTransient
    public List<Workspaceitem> getWorkspaceitemList() {
        return workspaceitemList;
    }

    public void setWorkspaceitemList(List<Workspaceitem> workspaceitemList) {
        this.workspaceitemList = workspaceitemList;
    }

    @XmlTransient
    public List<Collection2item> getCollection2itemList() {
        return collection2itemList;
    }

    public void setCollection2itemList(List<Collection2item> collection2itemList) {
        this.collection2itemList = collection2itemList;
    }

    @XmlTransient
    public List<Workflowitem> getWorkflowitemList() {
        return workflowitemList;
    }

    public void setWorkflowitemList(List<Workflowitem> workflowitemList) {
        this.workflowitemList = workflowitemList;
    }

    @XmlTransient
    public List<HarvestedCollection> getHarvestedCollectionList() {
        return harvestedCollectionList;
    }

    public void setHarvestedCollectionList(List<HarvestedCollection> harvestedCollectionList) {
        this.harvestedCollectionList = harvestedCollectionList;
    }

    public Bitstream getLogoBitstreamId() {
        return logoBitstreamId;
    }

    public void setLogoBitstreamId(Bitstream logoBitstreamId) {
        this.logoBitstreamId = logoBitstreamId;
    }

    public Epersongroup getAdmin() {
        return admin;
    }

    public void setAdmin(Epersongroup admin) {
        this.admin = admin;
    }

    public Epersongroup getSubmitter() {
        return submitter;
    }

    public void setSubmitter(Epersongroup submitter) {
        this.submitter = submitter;
    }

    public Epersongroup getWorkflowStep1() {
        return workflowStep1;
    }

    public void setWorkflowStep1(Epersongroup workflowStep1) {
        this.workflowStep1 = workflowStep1;
    }

    public Epersongroup getWorkflowStep2() {
        return workflowStep2;
    }

    public void setWorkflowStep2(Epersongroup workflowStep2) {
        this.workflowStep2 = workflowStep2;
    }

    public Epersongroup getWorkflowStep3() {
        return workflowStep3;
    }

    public void setWorkflowStep3(Epersongroup workflowStep3) {
        this.workflowStep3 = workflowStep3;
    }

    public Item getTemplateItemId() {
        return templateItemId;
    }

    public void setTemplateItemId(Item templateItemId) {
        this.templateItemId = templateItemId;
    }

    public CollectionItemCount getCollectionItemCount() {
        return collectionItemCount;
    }

    public void setCollectionItemCount(CollectionItemCount collectionItemCount) {
        this.collectionItemCount = collectionItemCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (collectionId != null ? collectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Collection)) {
            return false;
        }
        Collection other = (Collection) object;
        if ((this.collectionId == null && other.collectionId != null) || (this.collectionId != null && !this.collectionId.equals(other.collectionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Collection[ collectionId=" + collectionId + " ]";
    }
    
}
