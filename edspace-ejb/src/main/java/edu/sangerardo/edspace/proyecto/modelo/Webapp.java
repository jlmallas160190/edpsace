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
@Table(name = "webapp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Webapp.findAll", query = "SELECT w FROM Webapp w")
    , @NamedQuery(name = "Webapp.findByWebappId", query = "SELECT w FROM Webapp w WHERE w.webappId = :webappId")
    , @NamedQuery(name = "Webapp.findByAppname", query = "SELECT w FROM Webapp w WHERE w.appname = :appname")
    , @NamedQuery(name = "Webapp.findByUrl", query = "SELECT w FROM Webapp w WHERE w.url = :url")
    , @NamedQuery(name = "Webapp.findByStarted", query = "SELECT w FROM Webapp w WHERE w.started = :started")
    , @NamedQuery(name = "Webapp.findByIsui", query = "SELECT w FROM Webapp w WHERE w.isui = :isui")})
public class Webapp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "webapp_id")
    private Integer webappId;
    @Size(max = 32)
    @Column(name = "appname")
    private String appname;
    @Size(max = 2147483647)
    @Column(name = "url")
    private String url;
    @Column(name = "started")
    @Temporal(TemporalType.TIMESTAMP)
    private Date started;
    @Column(name = "isui")
    private Integer isui;

    public Webapp() {
    }

    public Webapp(Integer webappId) {
        this.webappId = webappId;
    }

    public Integer getWebappId() {
        return webappId;
    }

    public void setWebappId(Integer webappId) {
        this.webappId = webappId;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Integer getIsui() {
        return isui;
    }

    public void setIsui(Integer isui) {
        this.isui = isui;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (webappId != null ? webappId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Webapp)) {
            return false;
        }
        Webapp other = (Webapp) object;
        if ((this.webappId == null && other.webappId != null) || (this.webappId != null && !this.webappId.equals(other.webappId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Webapp[ webappId=" + webappId + " ]";
    }
    
}
