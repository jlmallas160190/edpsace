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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "metadatavalue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metadatavalue.findAll", query = "SELECT m FROM Metadatavalue m")
    , @NamedQuery(name = "Metadatavalue.findByMetadataValueId", query = "SELECT m FROM Metadatavalue m WHERE m.metadataValueId = :metadataValueId")
    , @NamedQuery(name = "Metadatavalue.findByResourceId", query = "SELECT m FROM Metadatavalue m WHERE m.resourceId = :resourceId")
    , @NamedQuery(name = "Metadatavalue.findByTextValue", query = "SELECT m FROM Metadatavalue m WHERE m.textValue = :textValue")
    , @NamedQuery(name = "Metadatavalue.findByTextLang", query = "SELECT m FROM Metadatavalue m WHERE m.textLang = :textLang")
    , @NamedQuery(name = "Metadatavalue.findByPlace", query = "SELECT m FROM Metadatavalue m WHERE m.place = :place")
    , @NamedQuery(name = "Metadatavalue.findByAuthority", query = "SELECT m FROM Metadatavalue m WHERE m.authority = :authority")
    , @NamedQuery(name = "Metadatavalue.findByConfidence", query = "SELECT m FROM Metadatavalue m WHERE m.confidence = :confidence")
    , @NamedQuery(name = "Metadatavalue.findByResourceTypeId", query = "SELECT m FROM Metadatavalue m WHERE m.resourceTypeId = :resourceTypeId")
    ,
    @NamedQuery(name = "Metadatavalue.findByResource", query = "SELECT m FROM Metadatavalue m WHERE m.resourceId=?1 and m.resourceTypeId = ?2 and m.metadataFieldId.metadataFieldId=?3")
})
public class Metadatavalue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "metadata_value_id")
    private Integer metadataValueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resource_id")
    private int resourceId;
    @Size(max = 2147483647)
    @Column(name = "text_value")
    private String textValue;
    @Size(max = 24)
    @Column(name = "text_lang")
    private String textLang;
    @Column(name = "place")
    private Integer place;
    @Size(max = 100)
    @Column(name = "authority")
    private String authority;
    @Column(name = "confidence")
    private Integer confidence;
    @Basic(optional = false)
    @NotNull
    @Column(name = "resource_type_id")
    private int resourceTypeId;
    @JoinColumn(name = "metadata_field_id", referencedColumnName = "metadata_field_id")
    @ManyToOne
    private Metadatafieldregistry metadataFieldId;

    public Metadatavalue() {
    }

    public Metadatavalue(Integer metadataValueId) {
        this.metadataValueId = metadataValueId;
    }

    public Metadatavalue(Integer metadataValueId, int resourceId, int resourceTypeId) {
        this.metadataValueId = metadataValueId;
        this.resourceId = resourceId;
        this.resourceTypeId = resourceTypeId;
    }

    public Integer getMetadataValueId() {
        return metadataValueId;
    }

    public void setMetadataValueId(Integer metadataValueId) {
        this.metadataValueId = metadataValueId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getTextLang() {
        return textLang;
    }

    public void setTextLang(String textLang) {
        this.textLang = textLang;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getConfidence() {
        return confidence;
    }

    public void setConfidence(Integer confidence) {
        this.confidence = confidence;
    }

    public int getResourceTypeId() {
        return resourceTypeId;
    }

    public void setResourceTypeId(int resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public Metadatafieldregistry getMetadataFieldId() {
        return metadataFieldId;
    }

    public void setMetadataFieldId(Metadatafieldregistry metadataFieldId) {
        this.metadataFieldId = metadataFieldId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (metadataValueId != null ? metadataValueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metadatavalue)) {
            return false;
        }
        Metadatavalue other = (Metadatavalue) object;
        if ((this.metadataValueId == null && other.metadataValueId != null) || (this.metadataValueId != null && !this.metadataValueId.equals(other.metadataValueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Metadatavalue[ metadataValueId=" + metadataValueId + " ]";
    }

}
