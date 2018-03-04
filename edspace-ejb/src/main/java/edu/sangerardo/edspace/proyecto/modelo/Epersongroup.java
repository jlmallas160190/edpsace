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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "epersongroup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Epersongroup.findAll", query = "SELECT e FROM Epersongroup e")
    , @NamedQuery(name = "Epersongroup.findByEpersonGroupId", query = "SELECT e FROM Epersongroup e WHERE e.epersonGroupId = :epersonGroupId")})
public class Epersongroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "eperson_group_id")
    private Integer epersonGroupId;
    @OneToMany(mappedBy = "childId")
    private List<Group2groupcache> group2groupcacheList;
    @OneToMany(mappedBy = "parentId")
    private List<Group2groupcache> group2groupcacheList1;
    @OneToMany(mappedBy = "epersongroupId")
    private List<Resourcepolicy> resourcepolicyList;
    @OneToMany(mappedBy = "admin")
    private List<Collection> collectionList;
    @OneToMany(mappedBy = "submitter")
    private List<Collection> collectionList1;
    @OneToMany(mappedBy = "workflowStep1")
    private List<Collection> collectionList2;
    @OneToMany(mappedBy = "workflowStep2")
    private List<Collection> collectionList3;
    @OneToMany(mappedBy = "workflowStep3")
    private List<Collection> collectionList4;
    @OneToMany(mappedBy = "admin")
    private List<Community> communityList;
    @OneToMany(mappedBy = "epersonGroupId")
    private List<Epersongroup2eperson> epersongroup2epersonList;
    @OneToMany(mappedBy = "epersonGroupId")
    private List<Epersongroup2workspaceitem> epersongroup2workspaceitemList;
    @OneToMany(mappedBy = "childId")
    private List<Group2group> group2groupList;
    @OneToMany(mappedBy = "parentId")
    private List<Group2group> group2groupList1;

    public Epersongroup() {
    }

    public Epersongroup(Integer epersonGroupId) {
        this.epersonGroupId = epersonGroupId;
    }

    public Integer getEpersonGroupId() {
        return epersonGroupId;
    }

    public void setEpersonGroupId(Integer epersonGroupId) {
        this.epersonGroupId = epersonGroupId;
    }

    @XmlTransient
    public List<Group2groupcache> getGroup2groupcacheList() {
        return group2groupcacheList;
    }

    public void setGroup2groupcacheList(List<Group2groupcache> group2groupcacheList) {
        this.group2groupcacheList = group2groupcacheList;
    }

    @XmlTransient
    public List<Group2groupcache> getGroup2groupcacheList1() {
        return group2groupcacheList1;
    }

    public void setGroup2groupcacheList1(List<Group2groupcache> group2groupcacheList1) {
        this.group2groupcacheList1 = group2groupcacheList1;
    }

    @XmlTransient
    public List<Resourcepolicy> getResourcepolicyList() {
        return resourcepolicyList;
    }

    public void setResourcepolicyList(List<Resourcepolicy> resourcepolicyList) {
        this.resourcepolicyList = resourcepolicyList;
    }

    @XmlTransient
    public List<Collection> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(List<Collection> collectionList) {
        this.collectionList = collectionList;
    }

    @XmlTransient
    public List<Collection> getCollectionList1() {
        return collectionList1;
    }

    public void setCollectionList1(List<Collection> collectionList1) {
        this.collectionList1 = collectionList1;
    }

    @XmlTransient
    public List<Collection> getCollectionList2() {
        return collectionList2;
    }

    public void setCollectionList2(List<Collection> collectionList2) {
        this.collectionList2 = collectionList2;
    }

    @XmlTransient
    public List<Collection> getCollectionList3() {
        return collectionList3;
    }

    public void setCollectionList3(List<Collection> collectionList3) {
        this.collectionList3 = collectionList3;
    }

    @XmlTransient
    public List<Collection> getCollectionList4() {
        return collectionList4;
    }

    public void setCollectionList4(List<Collection> collectionList4) {
        this.collectionList4 = collectionList4;
    }

    @XmlTransient
    public List<Community> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(List<Community> communityList) {
        this.communityList = communityList;
    }

    @XmlTransient
    public List<Epersongroup2eperson> getEpersongroup2epersonList() {
        return epersongroup2epersonList;
    }

    public void setEpersongroup2epersonList(List<Epersongroup2eperson> epersongroup2epersonList) {
        this.epersongroup2epersonList = epersongroup2epersonList;
    }

    @XmlTransient
    public List<Epersongroup2workspaceitem> getEpersongroup2workspaceitemList() {
        return epersongroup2workspaceitemList;
    }

    public void setEpersongroup2workspaceitemList(List<Epersongroup2workspaceitem> epersongroup2workspaceitemList) {
        this.epersongroup2workspaceitemList = epersongroup2workspaceitemList;
    }

    @XmlTransient
    public List<Group2group> getGroup2groupList() {
        return group2groupList;
    }

    public void setGroup2groupList(List<Group2group> group2groupList) {
        this.group2groupList = group2groupList;
    }

    @XmlTransient
    public List<Group2group> getGroup2groupList1() {
        return group2groupList1;
    }

    public void setGroup2groupList1(List<Group2group> group2groupList1) {
        this.group2groupList1 = group2groupList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (epersonGroupId != null ? epersonGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Epersongroup)) {
            return false;
        }
        Epersongroup other = (Epersongroup) object;
        if ((this.epersonGroupId == null && other.epersonGroupId != null) || (this.epersonGroupId != null && !this.epersonGroupId.equals(other.epersonGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Epersongroup[ epersonGroupId=" + epersonGroupId + " ]";
    }
    
}
