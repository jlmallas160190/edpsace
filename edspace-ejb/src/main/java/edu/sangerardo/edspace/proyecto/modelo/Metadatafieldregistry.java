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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "metadatafieldregistry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metadatafieldregistry.findAll", query = "SELECT m FROM Metadatafieldregistry m")
    , @NamedQuery(name = "Metadatafieldregistry.findByMetadataFieldId", query = "SELECT m FROM Metadatafieldregistry m WHERE m.metadataFieldId = :metadataFieldId")
    , @NamedQuery(name = "Metadatafieldregistry.findByElement", query = "SELECT m FROM Metadatafieldregistry m WHERE m.element = :element")
    , @NamedQuery(name = "Metadatafieldregistry.findByQualifier", query = "SELECT m FROM Metadatafieldregistry m WHERE m.qualifier = :qualifier")
    , @NamedQuery(name = "Metadatafieldregistry.findByScopeNote", query = "SELECT m FROM Metadatafieldregistry m WHERE m.scopeNote = :scopeNote")})
public class Metadatafieldregistry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "metadata_field_id")
    private Integer metadataFieldId;
    @Size(max = 64)
    @Column(name = "element")
    private String element;
    @Size(max = 64)
    @Column(name = "qualifier")
    private String qualifier;
    @Size(max = 2147483647)
    @Column(name = "scope_note")
    private String scopeNote;
    @JoinColumn(name = "metadata_schema_id", referencedColumnName = "metadata_schema_id")
    @ManyToOne(optional = false)
    private Metadataschemaregistry metadataSchemaId;
    @OneToMany(mappedBy = "metadataFieldId")
    private List<Metadatavalue> metadatavalueList;

    public Metadatafieldregistry() {
    }

    public Metadatafieldregistry(Integer metadataFieldId) {
        this.metadataFieldId = metadataFieldId;
    }

    public Integer getMetadataFieldId() {
        return metadataFieldId;
    }

    public void setMetadataFieldId(Integer metadataFieldId) {
        this.metadataFieldId = metadataFieldId;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public String getScopeNote() {
        return scopeNote;
    }

    public void setScopeNote(String scopeNote) {
        this.scopeNote = scopeNote;
    }

    public Metadataschemaregistry getMetadataSchemaId() {
        return metadataSchemaId;
    }

    public void setMetadataSchemaId(Metadataschemaregistry metadataSchemaId) {
        this.metadataSchemaId = metadataSchemaId;
    }

    @XmlTransient
    public List<Metadatavalue> getMetadatavalueList() {
        return metadatavalueList;
    }

    public void setMetadatavalueList(List<Metadatavalue> metadatavalueList) {
        this.metadatavalueList = metadatavalueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metadataFieldId != null ? metadataFieldId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metadatafieldregistry)) {
            return false;
        }
        Metadatafieldregistry other = (Metadatafieldregistry) object;
        if ((this.metadataFieldId == null && other.metadataFieldId != null) || (this.metadataFieldId != null && !this.metadataFieldId.equals(other.metadataFieldId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Metadatafieldregistry[ metadataFieldId=" + metadataFieldId + " ]";
    }
    
}
