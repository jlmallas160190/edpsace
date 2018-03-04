/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "community_item_count")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommunityItemCount.findAll", query = "SELECT c FROM CommunityItemCount c")
    , @NamedQuery(name = "CommunityItemCount.findByCommunityId", query = "SELECT c FROM CommunityItemCount c WHERE c.communityId = :communityId")
    , @NamedQuery(name = "CommunityItemCount.findByCount", query = "SELECT c FROM CommunityItemCount c WHERE c.count = :count")})
public class CommunityItemCount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "community_id")
    private Integer communityId;
    @Column(name = "count")
    private Integer count;
    @JoinColumn(name = "community_id", referencedColumnName = "community_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Community community;

    public CommunityItemCount() {
    }

    public CommunityItemCount(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
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
        if (!(object instanceof CommunityItemCount)) {
            return false;
        }
        CommunityItemCount other = (CommunityItemCount) object;
        if ((this.communityId == null && other.communityId != null) || (this.communityId != null && !this.communityId.equals(other.communityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.CommunityItemCount[ communityId=" + communityId + " ]";
    }
    
}
