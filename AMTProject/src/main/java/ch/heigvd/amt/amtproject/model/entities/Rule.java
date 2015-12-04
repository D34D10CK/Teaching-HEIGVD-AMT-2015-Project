/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    // A COMPLETETETASDJ OASJDIOAS DASDASDASDasd
    @NamedQuery(name = "Rule.findAllByEventAndConditions", query = "...")
})
public class Rule extends AbstractEntity<Long>{
    @OneToMany
    private List<RuleCondition> conditions;
    
    @OneToMany
    private List<EventAction> actions;
    
    @Column(unique = true, nullable = true)
    private String eventType;
    
    @ManyToOne
    private Application app;

    public Rule() {
    }

    public Rule(List<RuleCondition> conditions, List<EventAction> actions, String eventType, Application app) {
        this.conditions = conditions;
        this.actions = actions;
        this.eventType = eventType;
        this.app = app;
    }

    public List<RuleCondition> getConditions() {
        return conditions;
    }

    public List<EventAction> getActions() {
        return actions;
    }

    public String getEventType() {
        return eventType;
    }

    public Application getApp() {
        return app;
    }

    public void setConditions(List<RuleCondition> conditions) {
        this.conditions = conditions;
    }

    public void setActions(List<EventAction> actions) {
        this.actions = actions;
    }
    
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setApp(Application app) {
        this.app = app;
    }
}
