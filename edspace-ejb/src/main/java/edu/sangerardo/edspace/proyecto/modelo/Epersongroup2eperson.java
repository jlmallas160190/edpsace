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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "epersongroup2eperson")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Epersongroup2eperson.findAll", query = "SELECT e FROM Epersongroup2eperson e")
    , @NamedQuery(name = "Epersongroup2eperson.findById", query = "SELECT e FROM Epersongroup2eperson e WHERE e.id = :id")})
public class Epersongroup2eperson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "eperson_id", referencedColumnName = "eperson_id")
    @ManyToOne
    private Eperson epersonId;
    @JoinColumn(name = "eperson_group_id", referencedColumnName = "eperson_group_id")
    @ManyToOne
    private Epersongroup epersonGroupId;

    public Epersongroup2eperson() {
    }

    public Epersongroup2eperson(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Eperson getEpersonId() {
        return epersonId;
    }

    public void setEpersonId(Eperson epersonId) {
        this.epersonId = epersonId;
    }

    public Epersongroup getEpersonGroupId() {
        return epersonGroupId;
    }

    public void setEpersonGroupId(Epersongroup epersonGroupId) {
        this.epersonGroupId = epersonGroupId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Epersongroup2eperson)) {
            return false;
        }
        Epersongroup2eperson other = (Epersongroup2eperson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Epersongroup2eperson[ id=" + id + " ]";
    }
    
}
