/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.master.modelo;

import java.io.Serializable;
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
@Table(name = "item_master", schema = "master")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemMaster.findAll", query = "SELECT c FROM ItemMaster c")
    , @NamedQuery(name = "ItemMaster.findByCodigo", query = "SELECT c FROM ItemMaster c WHERE c.codigo = :codigo"),})
public class ItemMaster implements Serializable {

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
    private ItemMaster padre;
    @ManyToOne
    private CatalogoItem catalogoItem;
    @OneToMany(mappedBy = "padre")
    private List<ItemMaster> itemMasters;

    public ItemMaster() {
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

    public ItemMaster getPadre() {
        return padre;
    }

    public void setPadre(ItemMaster padre) {
        this.padre = padre;
    }

    public CatalogoItem getCatalogoItem() {
        return catalogoItem;
    }

    public void setCatalogoItem(CatalogoItem catalogoItem) {
        this.catalogoItem = catalogoItem;
    }

    public List<ItemMaster> getItemMasters() {
        return itemMasters;
    }

    public void setItemMasters(List<ItemMaster> itemMasters) {
        this.itemMasters = itemMasters;
    }

}
