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
public class ResourceSolrGroupByDTO implements Serializable {

    private Integer numberOperation;
    private String groupBy;

    public ResourceSolrGroupByDTO() {
        numberOperation = 0;
    }

    public Integer getNumberOperation() {
        return numberOperation;
    }

    public void setNumberOperation(Integer numberOperation) {
        this.numberOperation = numberOperation;
    }

    public String getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String groupBy) {
        this.groupBy = groupBy;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.groupBy != null ? this.groupBy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResourceSolrGroupByDTO other = (ResourceSolrGroupByDTO) obj;
        return !((this.groupBy == null) ? (other.groupBy != null) : !this.groupBy.equals(other.groupBy));
    }

}
