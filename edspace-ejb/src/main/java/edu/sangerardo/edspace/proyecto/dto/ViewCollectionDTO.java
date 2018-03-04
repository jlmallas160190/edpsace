/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.dto;

import java.io.Serializable;

/**
 *
 * @author jorgemalla
 */
public class ViewCollectionDTO extends ResourceSolrDTO implements Serializable{

    private CollectionDTO collectionDTO;

    public ViewCollectionDTO() {
    }

    public CollectionDTO getCollectionDTO() {
        return collectionDTO;
    }

    public void setCollectionDTO(CollectionDTO collectionDTO) {
        this.collectionDTO = collectionDTO;
    }

}
