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
@Table(name = "schema_version")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchemaVersion.findAll", query = "SELECT s FROM SchemaVersion s")
    , @NamedQuery(name = "SchemaVersion.findByVersionRank", query = "SELECT s FROM SchemaVersion s WHERE s.versionRank = :versionRank")
    , @NamedQuery(name = "SchemaVersion.findByInstalledRank", query = "SELECT s FROM SchemaVersion s WHERE s.installedRank = :installedRank")
    , @NamedQuery(name = "SchemaVersion.findByVersion", query = "SELECT s FROM SchemaVersion s WHERE s.version = :version")
    , @NamedQuery(name = "SchemaVersion.findByDescription", query = "SELECT s FROM SchemaVersion s WHERE s.description = :description")
    , @NamedQuery(name = "SchemaVersion.findByType", query = "SELECT s FROM SchemaVersion s WHERE s.type = :type")
    , @NamedQuery(name = "SchemaVersion.findByScript", query = "SELECT s FROM SchemaVersion s WHERE s.script = :script")
    , @NamedQuery(name = "SchemaVersion.findByChecksum", query = "SELECT s FROM SchemaVersion s WHERE s.checksum = :checksum")
    , @NamedQuery(name = "SchemaVersion.findByInstalledBy", query = "SELECT s FROM SchemaVersion s WHERE s.installedBy = :installedBy")
    , @NamedQuery(name = "SchemaVersion.findByInstalledOn", query = "SELECT s FROM SchemaVersion s WHERE s.installedOn = :installedOn")
    , @NamedQuery(name = "SchemaVersion.findByExecutionTime", query = "SELECT s FROM SchemaVersion s WHERE s.executionTime = :executionTime")
    , @NamedQuery(name = "SchemaVersion.findBySuccess", query = "SELECT s FROM SchemaVersion s WHERE s.success = :success")})
public class SchemaVersion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "version_rank")
    private int versionRank;
    @Basic(optional = false)
    @NotNull
    @Column(name = "installed_rank")
    private int installedRank;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "version")
    private String version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "script")
    private String script;
    @Column(name = "checksum")
    private Integer checksum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "installed_by")
    private String installedBy;
    @Basic(optional = false)
    @NotNull
    @Column(name = "installed_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date installedOn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "execution_time")
    private int executionTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "success")
    private boolean success;

    public SchemaVersion() {
    }

    public SchemaVersion(String version) {
        this.version = version;
    }

    public SchemaVersion(String version, int versionRank, int installedRank, String description, String type, String script, String installedBy, Date installedOn, int executionTime, boolean success) {
        this.version = version;
        this.versionRank = versionRank;
        this.installedRank = installedRank;
        this.description = description;
        this.type = type;
        this.script = script;
        this.installedBy = installedBy;
        this.installedOn = installedOn;
        this.executionTime = executionTime;
        this.success = success;
    }

    public int getVersionRank() {
        return versionRank;
    }

    public void setVersionRank(int versionRank) {
        this.versionRank = versionRank;
    }

    public int getInstalledRank() {
        return installedRank;
    }

    public void setInstalledRank(int installedRank) {
        this.installedRank = installedRank;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public Integer getChecksum() {
        return checksum;
    }

    public void setChecksum(Integer checksum) {
        this.checksum = checksum;
    }

    public String getInstalledBy() {
        return installedBy;
    }

    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
    }

    public Date getInstalledOn() {
        return installedOn;
    }

    public void setInstalledOn(Date installedOn) {
        this.installedOn = installedOn;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(int executionTime) {
        this.executionTime = executionTime;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (version != null ? version.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchemaVersion)) {
            return false;
        }
        SchemaVersion other = (SchemaVersion) object;
        if ((this.version == null && other.version != null) || (this.version != null && !this.version.equals(other.version))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.SchemaVersion[ version=" + version + " ]";
    }
    
}
