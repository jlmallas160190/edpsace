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
public class ViewCommunityDTO extends ResourceSolrDTO implements Serializable {

    private CommunityDTO communityDTO;

    public ViewCommunityDTO() {
    }

    public CommunityDTO getCommunityDTO() {
        return communityDTO;
    }

    public void setCommunityDTO(CommunityDTO communityDTO) {
        this.communityDTO = communityDTO;
    }

}
