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
@Table(name = "workflowitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workflowitem.findAll", query = "SELECT w FROM Workflowitem w")
    , @NamedQuery(name = "Workflowitem.findByWorkflowId", query = "SELECT w FROM Workflowitem w WHERE w.workflowId = :workflowId")
    , @NamedQuery(name = "Workflowitem.findByState", query = "SELECT w FROM Workflowitem w WHERE w.state = :state")
    , @NamedQuery(name = "Workflowitem.findByMultipleTitles", query = "SELECT w FROM Workflowitem w WHERE w.multipleTitles = :multipleTitles")
    , @NamedQuery(name = "Workflowitem.findByPublishedBefore", query = "SELECT w FROM Workflowitem w WHERE w.publishedBefore = :publishedBefore")
    , @NamedQuery(name = "Workflowitem.findByMultipleFiles", query = "SELECT w FROM Workflowitem w WHERE w.multipleFiles = :multipleFiles")})
public class Workflowitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "workflow_id")
    private Integer workflowId;
    @Column(name = "state")
    private Integer state;
    @Column(name = "multiple_titles")
    private Boolean multipleTitles;
    @Column(name = "published_before")
    private Boolean publishedBefore;
    @Column(name = "multiple_files")
    private Boolean multipleFiles;
    @OneToMany(mappedBy = "workflowId")
    private List<Tasklistitem> tasklistitemList;
    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id")
    @ManyToOne
    private Collection collectionId;
    @JoinColumn(name = "owner", referencedColumnName = "eperson_id")
    @ManyToOne
    private Eperson owner;
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @OneToOne
    private Item itemId;

    public Workflowitem() {
    }

    public Workflowitem(Integer workflowId) {
        this.workflowId = workflowId;
    }

    public Integer getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Integer workflowId) {
        this.workflowId = workflowId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Boolean getMultipleTitles() {
        return multipleTitles;
    }

    public void setMultipleTitles(Boolean multipleTitles) {
        this.multipleTitles = multipleTitles;
    }

    public Boolean getPublishedBefore() {
        return publishedBefore;
    }

    public void setPublishedBefore(Boolean publishedBefore) {
        this.publishedBefore = publishedBefore;
    }

    public Boolean getMultipleFiles() {
        return multipleFiles;
    }

    public void setMultipleFiles(Boolean multipleFiles) {
        this.multipleFiles = multipleFiles;
    }

    @XmlTransient
    public List<Tasklistitem> getTasklistitemList() {
        return tasklistitemList;
    }

    public void setTasklistitemList(List<Tasklistitem> tasklistitemList) {
        this.tasklistitemList = tasklistitemList;
    }

    public Collection getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Collection collectionId) {
        this.collectionId = collectionId;
    }

    public Eperson getOwner() {
        return owner;
    }

    public void setOwner(Eperson owner) {
        this.owner = owner;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workflowId != null ? workflowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workflowitem)) {
            return false;
        }
        Workflowitem other = (Workflowitem) object;
        if ((this.workflowId == null && other.workflowId != null) || (this.workflowId != null && !this.workflowId.equals(other.workflowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Workflowitem[ workflowId=" + workflowId + " ]";
    }
    
}
