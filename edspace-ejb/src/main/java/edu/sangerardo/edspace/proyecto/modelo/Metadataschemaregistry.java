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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "metadataschemaregistry")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metadataschemaregistry.findAll", query = "SELECT m FROM Metadataschemaregistry m")
    , @NamedQuery(name = "Metadataschemaregistry.findByMetadataSchemaId", query = "SELECT m FROM Metadataschemaregistry m WHERE m.metadataSchemaId = :metadataSchemaId")
    , @NamedQuery(name = "Metadataschemaregistry.findByNamespace", query = "SELECT m FROM Metadataschemaregistry m WHERE m.namespace = :namespace")
    , @NamedQuery(name = "Metadataschemaregistry.findByShortId", query = "SELECT m FROM Metadataschemaregistry m WHERE m.shortId = :shortId")})
public class Metadataschemaregistry implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "metadata_schema_id")
    private Integer metadataSchemaId;
    @Size(max = 256)
    @Column(name = "namespace")
    private String namespace;
    @Size(max = 32)
    @Column(name = "short_id")
    private String shortId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "metadataSchemaId")
    private List<Metadatafieldregistry> metadatafieldregistryList;

    public Metadataschemaregistry() {
    }

    public Metadataschemaregistry(Integer metadataSchemaId) {
        this.metadataSchemaId = metadataSchemaId;
    }

    public Integer getMetadataSchemaId() {
        return metadataSchemaId;
    }

    public void setMetadataSchemaId(Integer metadataSchemaId) {
        this.metadataSchemaId = metadataSchemaId;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getShortId() {
        return shortId;
    }

    public void setShortId(String shortId) {
        this.shortId = shortId;
    }

    @XmlTransient
    public List<Metadatafieldregistry> getMetadatafieldregistryList() {
        return metadatafieldregistryList;
    }

    public void setMetadatafieldregistryList(List<Metadatafieldregistry> metadatafieldregistryList) {
        this.metadatafieldregistryList = metadatafieldregistryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metadataSchemaId != null ? metadataSchemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metadataschemaregistry)) {
            return false;
        }
        Metadataschemaregistry other = (Metadataschemaregistry) object;
        if ((this.metadataSchemaId == null && other.metadataSchemaId != null) || (this.metadataSchemaId != null && !this.metadataSchemaId.equals(other.metadataSchemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Metadataschemaregistry[ metadataSchemaId=" + metadataSchemaId + " ]";
    }
    
}
