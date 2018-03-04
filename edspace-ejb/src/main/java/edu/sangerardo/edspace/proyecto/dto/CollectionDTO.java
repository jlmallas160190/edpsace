/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.dto;

import edu.sangerardo.edspace.proyecto.modelo.Collection;
import java.io.Serializable;

/**
 *
 * @author jorgemalla
 */
public class CollectionDTO implements Serializable {

    private Collection collection;
    private String title;

    public CollectionDTO() {
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
