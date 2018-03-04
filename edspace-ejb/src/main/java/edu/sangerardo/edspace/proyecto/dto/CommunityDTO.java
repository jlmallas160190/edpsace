/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sangerardo.edspace.proyecto.dto;

import edu.sangerardo.edspace.proyecto.modelo.Community;

/**
 *
 * @author jorgemalla
 */
public class CommunityDTO {

    private Integer countColecctions;
    private Community community;
    private String title;

    public CommunityDTO() {

    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Integer getCountColecctions() {
        return countColecctions;
    }

    public void setCountColecctions(Integer countColecctions) {
        this.countColecctions = countColecctions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
