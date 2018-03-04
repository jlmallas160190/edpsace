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
@Table(name = "catalogo_item", schema = "master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CatalogoItem.findAll", query = "SELECT c FROM CatalogoItem c")
    , @NamedQuery(name = "CatalogoItem.findByCodigo", query = "SELECT c FROM CatalogoItem c WHERE c.codigo = :codigo"),})
public class CatalogoItem implements Serializable {

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
    @NotNull
    private String descripcion;
    @ManyToOne
    private CatalogoItem padre;
    @OneToMany(mappedBy = "padre")
    private List<CatalogoItem> catalogoItems;
    @OneToMany(mappedBy = "catalogoItem")
    private List<ItemMaster> itemMasters;

    public CatalogoItem() {
        this.itemMasters = new ArrayList<ItemMaster>();
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

    public CatalogoItem getPadre() {
        return padre;
    }

    public void setPadre(CatalogoItem padre) {
        this.padre = padre;
    }

    public List<CatalogoItem> getCatalogoItems() {
        return catalogoItems;
    }

    public void setCatalogoItems(List<CatalogoItem> catalogoItems) {
        this.catalogoItems = catalogoItems;
    }

    public List<ItemMaster> getItemMasters() {
        return itemMasters;
    }

    public void setItemMasters(List<ItemMaster> itemMasters) {
        this.itemMasters = itemMasters;
    }

}
