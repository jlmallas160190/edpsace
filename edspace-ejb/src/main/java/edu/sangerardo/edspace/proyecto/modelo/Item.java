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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")
    , @NamedQuery(name = "Item.findByItemId", query = "SELECT i FROM Item i WHERE i.itemId = :itemId")
    , @NamedQuery(name = "Item.findByInArchive", query = "SELECT i FROM Item i WHERE i.inArchive = :inArchive")
    , @NamedQuery(name = "Item.findByWithdrawn", query = "SELECT i FROM Item i WHERE i.withdrawn = :withdrawn")
    , @NamedQuery(name = "Item.findByOwningCollection", query = "SELECT i FROM Item i WHERE i.owningCollection = :owningCollection")
    , @NamedQuery(name = "Item.findByLastModified", query = "SELECT i FROM Item i WHERE i.lastModified = :lastModified")
    , @NamedQuery(name = "Item.findByDiscoverable", query = "SELECT i FROM Item i WHERE i.discoverable = :discoverable")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "in_archive")
    private Boolean inArchive;
    @Column(name = "withdrawn")
    private Boolean withdrawn;
    @Column(name = "owning_collection")
    private Integer owningCollection;
    @Column(name = "last_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;
    @Column(name = "discoverable")
    private Boolean discoverable;
    @OneToMany(mappedBy = "itemId")
    private List<HarvestedItem> harvestedItemList;
    @OneToMany(mappedBy = "itemId")
    private List<Item2bundle> item2bundleList;
    @OneToMany(mappedBy = "itemId")
    private List<Workspaceitem> workspaceitemList;
    @OneToMany(mappedBy = "itemId")
    private List<Collection2item> collection2itemList;
    @OneToOne(mappedBy = "itemId")
    private Workflowitem workflowitem;
    @JoinColumn(name = "submitter_id", referencedColumnName = "eperson_id")
    @ManyToOne
    private Eperson submitterId;
    @OneToMany(mappedBy = "itemId")
    private List<Communities2item> communities2itemList;
    @OneToMany(mappedBy = "templateItemId")
    private List<Collection> collectionList;
    @OneToMany(mappedBy = "itemId")
    private List<Versionitem> versionitemList;

    public Item() {
    }

    public Item(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Boolean getInArchive() {
        return inArchive;
    }

    public void setInArchive(Boolean inArchive) {
        this.inArchive = inArchive;
    }

    public Boolean getWithdrawn() {
        return withdrawn;
    }

    public void setWithdrawn(Boolean withdrawn) {
        this.withdrawn = withdrawn;
    }

    public Integer getOwningCollection() {
        return owningCollection;
    }

    public void setOwningCollection(Integer owningCollection) {
        this.owningCollection = owningCollection;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Boolean getDiscoverable() {
        return discoverable;
    }

    public void setDiscoverable(Boolean discoverable) {
        this.discoverable = discoverable;
    }

    @XmlTransient
    public List<HarvestedItem> getHarvestedItemList() {
        return harvestedItemList;
    }

    public void setHarvestedItemList(List<HarvestedItem> harvestedItemList) {
        this.harvestedItemList = harvestedItemList;
    }

    @XmlTransient
    public List<Item2bundle> getItem2bundleList() {
        return item2bundleList;
    }

    public void setItem2bundleList(List<Item2bundle> item2bundleList) {
        this.item2bundleList = item2bundleList;
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

    public Workflowitem getWorkflowitem() {
        return workflowitem;
    }

    public void setWorkflowitem(Workflowitem workflowitem) {
        this.workflowitem = workflowitem;
    }

    public Eperson getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(Eperson submitterId) {
        this.submitterId = submitterId;
    }

    @XmlTransient
    public List<Communities2item> getCommunities2itemList() {
        return communities2itemList;
    }

    public void setCommunities2itemList(List<Communities2item> communities2itemList) {
        this.communities2itemList = communities2itemList;
    }

    @XmlTransient
    public List<Collection> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<Collection> collectionList) {
        this.collectionList = collectionList;
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
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item)) {
            return false;
        }
        Item other = (Item) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Item[ itemId=" + itemId + " ]";
    }
    
}
