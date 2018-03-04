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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jorgemalla
 */
@Entity
@Table(name = "tasklistitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tasklistitem.findAll", query = "SELECT t FROM Tasklistitem t")
    , @NamedQuery(name = "Tasklistitem.findByTasklistId", query = "SELECT t FROM Tasklistitem t WHERE t.tasklistId = :tasklistId")})
public class Tasklistitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "tasklist_id")
    private Integer tasklistId;
    @JoinColumn(name = "eperson_id", referencedColumnName = "eperson_id")
    @ManyToOne
    private Eperson epersonId;
    @JoinColumn(name = "workflow_id", referencedColumnName = "workflow_id")
    @ManyToOne
    private Workflowitem workflowId;

    public Tasklistitem() {
    }

    public Tasklistitem(Integer tasklistId) {
        this.tasklistId = tasklistId;
    }

    public Integer getTasklistId() {
        return tasklistId;
    }

    public void setTasklistId(Integer tasklistId) {
        this.tasklistId = tasklistId;
    }

    public Eperson getEpersonId() {
        return epersonId;
    }

    public void setEpersonId(Eperson epersonId) {
        this.epersonId = epersonId;
    }

    public Workflowitem getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Workflowitem workflowId) {
        this.workflowId = workflowId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tasklistId != null ? tasklistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tasklistitem)) {
            return false;
        }
        Tasklistitem other = (Tasklistitem) object;
        if ((this.tasklistId == null && other.tasklistId != null) || (this.tasklistId != null && !this.tasklistId.equals(other.tasklistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.sangerardo.edspace.modelo.Tasklistitem[ tasklistId=" + tasklistId + " ]";
    }
    
}
