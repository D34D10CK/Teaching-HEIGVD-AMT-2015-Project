/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model.entities;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Marc
 */
@NamedQueries({
    @NamedQuery(name="EndUser.findByApp", query ="select e from EndUser e where e.app = :app")
})
@Entity
public class EndUser extends AbstractEntity<Long>{
     
    @Column(nullable = false, unique = true)
    private String userId;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATION_TS", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable=false, updatable=false)
    private Calendar dateCrea;
    
    @ManyToOne
    private Application app;
    
    public EndUser() {
        userId = UUID.randomUUID().toString();
    }

    public EndUser(String userId, Calendar dateCrea, Application app) {
        this.userId = userId;
        this.dateCrea = dateCrea;
        this.app = app;
    }
    
    

    public String getUserId() {
        return userId;
    }

    public void setUserId(String UserId) {
        this.userId = UserId;
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
