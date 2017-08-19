/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gitittech.syswriter.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ambrose Ariagiegbe
 */
@Entity
@Table(name = "log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT e FROM Log e")
    ,
    @NamedQuery(name = "Log.findById", query = "SELECT e FROM Log e WHERE e.id = :id")
    ,
    @NamedQuery(name = "Log.findByAppController", query = "SELECT e FROM Log e WHERE e.appController = :appController")
    ,
    @NamedQuery(name = "Log.findByDescription", query = "SELECT e FROM Log e WHERE e.description = :description")
    ,
    @NamedQuery(name = "Log.findByDateCreated", query = "SELECT e FROM Log e WHERE e.dateCreated = :dateCreated")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private BigInteger id;

    @Basic(optional = false)
    @Column(name = "level")
    private String level;
    
    @Basic(optional = false)
    @Column(name = "app_controller")
    private String appController;

    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    
    @Column(name = "stack_trace")
    private String stackTrace;

    @Basic(optional = false)
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();
    
    public Log() {
    }

    public Log(BigInteger errorId) {
        this.id = errorId;
    }

    public Log(String appController, String description, String stackTrace, String level) {
        this.appController = appController;
        this.description = description;
        this.stackTrace = stackTrace;
        this.level = level;
    }

    public Log(String controller, String description, String level) {
        this.appController = appController;
        this.description = description;
        this.level = level;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAppController() {
        return appController;
    }

    public void setAppController(String appController) {
        this.appController = appController;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    
    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Log[ id=" + id + " ]";
    }

}
