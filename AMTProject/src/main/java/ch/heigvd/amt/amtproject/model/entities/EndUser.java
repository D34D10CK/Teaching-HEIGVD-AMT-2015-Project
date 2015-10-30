/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marc
 */
@Entity
public class EndUser extends AbstractEntity<Long>{
    
    @Column(nullable = false, unique = true)
    private String UserId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATION_TS", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    private Calendar dateCrea;
    
    @ManyToOne
    private Application app;
    
    public EndUser() {
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public Calendar getDateCrea() {
        return dateCrea;
    }

    public void setDateCrea(Calendar dateCrea) {
        this.dateCrea = dateCrea;
    }

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }
    
    
    
}
