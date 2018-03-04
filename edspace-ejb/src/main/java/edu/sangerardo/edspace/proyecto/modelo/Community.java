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
import javax.persistence.FetchType;
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
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "community")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Community.findAll", query = "SELECT c FROM Community c")
    , @NamedQuery(name = "Community.findByCommunityId", query = "SELECT c FROM Community c WHERE c.communityId = :communityId"),})
public class Community implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "community_id")
    private Integer communityId;
    @OneToMany(mappedBy = "communityId", fetch = FetchType.EAGER)
    private List<Community2collection> community2collectionList;
    @OneToMany(mappedBy = "communityId", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Communities2item> communities2itemList;
    @JoinColumn(name = "logo_bitstream_id", referencedColumnName = "bitstream_id")
    @ManyToOne
    private Bitstream logoBitstreamId;
    @JoinColumn(name = "admin", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup admin;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "community")
    private CommunityItemCount communityItemCount;
    @OneToMany(mappedBy = "childCommId", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Community2community> community2communityList;
    @OneToMany(mappedBy = "parentCommId", fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Community2community> community2communityList1;

    public Community() {
    }

    public Community(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    @XmlTransient
    public List<Community2collection> getCommunity2collectionList() {
        return community2collectionList;
    }

    public void setCommunity2collectionList(List<Community2collection> community2collectionList) {
        this.community2collectionList = community2collectionList;
    }

    @XmlTransient
    public List<Communities2item> getCommunities2itemList() {
        return communities2itemList;
    }

    public void setCommunities2itemList(List<Communities2item> communities2itemList) {
        this.communities2itemList = communities2itemList;
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

    public CommunityItemCount getCommunityItemCount() {
        return communityItemCount;
    }

    public void setCommunityItemCount(CommunityItemCount communityItemCount) {
        this.communityItemCount = communityItemCount;
    }

    @XmlTransient
    public List<Community2community> getCommunity2communityList() {
        return community2communityList;
    }

    public void setCommunity2communityList(List<Community2community> community2communityList) {
        this.community2communityList = community2communityList;
    }

    @XmlTransient
    public List<Community2community> getCommunity2communityList1() {
        return community2communityList1;
    }

    public void setCommunity2communityList1(List<Community2community> community2communityList1) {
        this.community2communityList1 = community2communityList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (communityId != null ? communityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Community)) {
            return false;
        }
        Community other = (Community) object;
        if ((this.communityId == null && other.communityId != null) || (this.communityId != null && !this.communityId.equals(other.communityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Community[ communityId=" + communityId + " ]";
    }

}
