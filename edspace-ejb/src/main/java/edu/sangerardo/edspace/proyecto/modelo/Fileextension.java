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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "fileextension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fileextension.findAll", query = "SELECT f FROM Fileextension f")
    , @NamedQuery(name = "Fileextension.findByFileExtensionId", query = "SELECT f FROM Fileextension f WHERE f.fileExtensionId = :fileExtensionId")
    , @NamedQuery(name = "Fileextension.findByExtension", query = "SELECT f FROM Fileextension f WHERE f.extension = :extension")})
public class Fileextension implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "file_extension_id")
    private Integer fileExtensionId;
    @Size(max = 16)
    @Column(name = "extension")
    private String extension;
    @JoinColumn(name = "bitstream_format_id", referencedColumnName = "bitstream_format_id")
    @ManyToOne
    private Bitstreamformatregistry bitstreamFormatId;

    public Fileextension() {
    }

    public Fileextension(Integer fileExtensionId) {
        this.fileExtensionId = fileExtensionId;
    }

    public Integer getFileExtensionId() {
        return fileExtensionId;
    }

    public void setFileExtensionId(Integer fileExtensionId) {
        this.fileExtensionId = fileExtensionId;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Bitstreamformatregistry getBitstreamFormatId() {
        return bitstreamFormatId;
    }

    public void setBitstreamFormatId(Bitstreamformatregistry bitstreamFormatId) {
        this.bitstreamFormatId = bitstreamFormatId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fileExtensionId != null ? fileExtensionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fileextension)) {
            return false;
        }
        Fileextension other = (Fileextension) object;
        if ((this.fileExtensionId == null && other.fileExtensionId != null) || (this.fileExtensionId != null && !this.fileExtensionId.equals(other.fileExtensionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Fileextension[ fileExtensionId=" + fileExtensionId + " ]";
    }
    
}
