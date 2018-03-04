/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.master.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "configuracion", schema = "master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracion.findAll", query = "SELECT c FROM Configuracion c")
    , @NamedQuery(name = "Configuracion.findByCodigo", query = "SELECT c FROM Configuracion c WHERE c.codigo = ?1"),})
public class Configuracion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Column(name = "codigo", unique = true)
    @NotNull
    private String codigo;
    @Column(name = "nombre")
    @NotNull
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne
    private Configuracion padre;
    @OneToMany(mappedBy = "padre")
    private List<Configuracion> configuracions;
    @OneToMany(mappedBy = "configuracion", fetch = FetchType.EAGER)
    private List<DetalleConfiguracion> detalleConfiguracions;

    public Configuracion() {
        this.detalleConfiguracions = new ArrayList<DetalleConfiguracion>();
    }

    @Override
    public boolean equals(Object object) {
        if (object != null && object instanceof Configuracion) {
            return this.codigo.equals(((Configuracion) object).codigo);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Configuracion getPadre() {
        return padre;
    }

    public void setPadre(Configuracion padre) {
        this.padre = padre;
    }

    public List<Configuracion> getConfiguracions() {
        return configuracions;
    }

    public void setConfiguracions(List<Configuracion> configuracions) {
        this.configuracions = configuracions;
    }

    public List<DetalleConfiguracion> getDetalleConfiguracions() {
        return detalleConfiguracions;
    }

    public void setDetalleConfiguracions(List<DetalleConfiguracion> detalleConfiguracions) {
        this.detalleConfiguracions = detalleConfiguracions;
    }

}
