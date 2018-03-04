/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jorgemalla
 */
public class ResourceSolrDTO implements Serializable {

    private String ip;
    private Integer id;
    private Date time;
    private String referrer;
    private String dns;
    private String userAgent;
    private Integer epersonId;
    private List<ResourceSolrGroupByDTO> resourceStatisticGroupBys;

    public ResourceSolrDTO(String ip, Integer bitStreamId, Date time, String referrer, String dns, String userAgent) {
        this.ip = ip;
        this.id = bitStreamId;
        this.time = time;
        this.referrer = referrer;
        this.dns = dns;
        this.userAgent = userAgent;
    }

    public ResourceSolrDTO() {
        this.resourceStatisticGroupBys = new ArrayList<ResourceSolrGroupByDTO>();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof ResourceSolrDTO) {
            return this.id.equals(((ResourceSolrDTO) object).id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    public Integer getEpersonId() {
        return epersonId;
    }

    public void setEpersonId(Integer epersonId) {
        this.epersonId = epersonId;
    }

    public List<ResourceSolrGroupByDTO> getResourceStatisticGroupBys() {
        return resourceStatisticGroupBys;
    }

    public void setResourceStatisticGroupBys(List<ResourceSolrGroupByDTO> resourceStatisticGroupBys) {
        this.resourceStatisticGroupBys = resourceStatisticGroupBys;
    }

}
