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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "workspaceitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Workspaceitem.findAll", query = "SELECT w FROM Workspaceitem w")
    , @NamedQuery(name = "Workspaceitem.findByWorkspaceItemId", query = "SELECT w FROM Workspaceitem w WHERE w.workspaceItemId = :workspaceItemId")
    , @NamedQuery(name = "Workspaceitem.findByMultipleTitles", query = "SELECT w FROM Workspaceitem w WHERE w.multipleTitles = :multipleTitles")
    , @NamedQuery(name = "Workspaceitem.findByPublishedBefore", query = "SELECT w FROM Workspaceitem w WHERE w.publishedBefore = :publishedBefore")
    , @NamedQuery(name = "Workspaceitem.findByMultipleFiles", query = "SELECT w FROM Workspaceitem w WHERE w.multipleFiles = :multipleFiles")
    , @NamedQuery(name = "Workspaceitem.findByStageReached", query = "SELECT w FROM Workspaceitem w WHERE w.stageReached = :stageReached")
    , @NamedQuery(name = "Workspaceitem.findByPageReached", query = "SELECT w FROM Workspaceitem w WHERE w.pageReached = :pageReached")})
public class Workspaceitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "workspace_item_id")
    private Integer workspaceItemId;
    @Column(name = "multiple_titles")
    private Boolean multipleTitles;
    @Column(name = "published_before")
    private Boolean publishedBefore;
    @Column(name = "multiple_files")
    private Boolean multipleFiles;
    @Column(name = "stage_reached")
    private Integer stageReached;
    @Column(name = "page_reached")
    private Integer pageReached;
    @JoinColumn(name = "collection_id", referencedColumnName = "collection_id")
    @ManyToOne
    private Collection collectionId;
    @JoinColumn(name = "item_id", referencedColumnName = "item_id")
    @ManyToOne
    private Item itemId;
    @OneToMany(mappedBy = "workspaceItemId")
    private List<Epersongroup2workspaceitem> epersongroup2workspaceitemList;

    public Workspaceitem() {
    }

    public Workspaceitem(Integer workspaceItemId) {
        this.workspaceItemId = workspaceItemId;
    }

    public Integer getWorkspaceItemId() {
        return workspaceItemId;
    }

    public void setWorkspaceItemId(Integer workspaceItemId) {
        this.workspaceItemId = workspaceItemId;
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

    public Integer getStageReached() {
        return stageReached;
    }

    public void setStageReached(Integer stageReached) {
        this.stageReached = stageReached;
    }

    public Integer getPageReached() {
        return pageReached;
    }

    public void setPageReached(Integer pageReached) {
        this.pageReached = pageReached;
    }

    public Collection getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Collection collectionId) {
        this.collectionId = collectionId;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    @XmlTransient
    public List<Epersongroup2workspaceitem> getEpersongroup2workspaceitemList() {
        return epersongroup2workspaceitemList;
    }

    public void setEpersongroup2workspaceitemList(List<Epersongroup2workspaceitem> epersongroup2workspaceitemList) {
        this.epersongroup2workspaceitemList = epersongroup2workspaceitemList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workspaceItemId != null ? workspaceItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Workspaceitem)) {
            return false;
        }
        Workspaceitem other = (Workspaceitem) object;
        if ((this.workspaceItemId == null && other.workspaceItemId != null) || (this.workspaceItemId != null && !this.workspaceItemId.equals(other.workspaceItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Workspaceitem[ workspaceItemId=" + workspaceItemId + " ]";
    }
    
}
