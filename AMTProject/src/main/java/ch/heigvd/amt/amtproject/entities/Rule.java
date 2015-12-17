/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "Rule.findByEventAndConditions", 
            query = "select r from Rule r where r.eventType = :event and r.conditions = :conditions")
})
public class Rule extends AbstractEntity<Long>{
    @OneToMany(mappedBy = "rule")
    private List<EventAction> actions;
    
    @OneToMany(mappedBy = "rule")
    private List<EventCondition> conditions;
    
    @Column(unique = false, nullable = false)
    private String eventType;
    
    @ManyToOne
    private Application app;

    public Rule() {
    }

    public Rule(List<EventAction> actions, List<EventCondition> conditions, String eventType, Application app) {
        this.actions = actions;
        this.conditions = conditions;
        this.eventType = eventType;
        this.app = app;
    }

    public List<EventAction> getActions() {
        return actions;
    }
    
    public List<EventCondition> getConditions() {
        return conditions;
    }

    public String getEventType() {
        return eventType;
    }

    public Application getApp() {
        return app;
    }

    public void setActions(List<EventAction> actions) {
        this.actions = actions;
    }
    
    public void setConditions(List<EventCondition> conditions){
        this.conditions = conditions;
    }
    
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setApp(Application app) {
        this.app = app;
    }
}
