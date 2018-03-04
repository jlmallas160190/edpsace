/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.master.modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "detalle_configuracion", schema = "master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleConfiguracion.findAll", query = "SELECT c FROM DetalleConfiguracion c")
    , @NamedQuery(name = "DetalleConfiguracion.findByCodigo", query = "SELECT c FROM DetalleConfiguracion c WHERE c.codigo = :codigo"),})
public class DetalleConfiguracion implements Serializable {

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
    @Column(name = "valor")
    @NotNull
    private String valor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Configuracion configuracion;

    public DetalleConfiguracion() {
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

}
