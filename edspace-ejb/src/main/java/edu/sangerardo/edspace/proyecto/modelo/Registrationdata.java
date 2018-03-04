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
@Table(name = "registrationdata")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrationdata.findAll", query = "SELECT r FROM Registrationdata r")
    , @NamedQuery(name = "Registrationdata.findByRegistrationdataId", query = "SELECT r FROM Registrationdata r WHERE r.registrationdataId = :registrationdataId")
    , @NamedQuery(name = "Registrationdata.findByEmail", query = "SELECT r FROM Registrationdata r WHERE r.email = :email")
    , @NamedQuery(name = "Registrationdata.findByToken", query = "SELECT r FROM Registrationdata r WHERE r.token = :token")
    , @NamedQuery(name = "Registrationdata.findByExpires", query = "SELECT r FROM Registrationdata r WHERE r.expires = :expires")})
public class Registrationdata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "registrationdata_id")
    private Integer registrationdataId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "email")
    private String email;
    @Size(max = 48)
    @Column(name = "token")
    private String token;
    @Column(name = "expires")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expires;

    public Registrationdata() {
    }

    public Registrationdata(Integer registrationdataId) {
        this.registrationdataId = registrationdataId;
    }

    public Integer getRegistrationdataId() {
        return registrationdataId;
    }

    public void setRegistrationdataId(Integer registrationdataId) {
        this.registrationdataId = registrationdataId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpires() {
        return expires;
    }

    public void setExpires(Date expires) {
        this.expires = expires;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (registrationdataId != null ? registrationdataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registrationdata)) {
            return false;
        }
        Registrationdata other = (Registrationdata) object;
        if ((this.registrationdataId == null && other.registrationdataId != null) || (this.registrationdataId != null && !this.registrationdataId.equals(other.registrationdataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Registrationdata[ registrationdataId=" + registrationdataId + " ]";
    }
    
}
