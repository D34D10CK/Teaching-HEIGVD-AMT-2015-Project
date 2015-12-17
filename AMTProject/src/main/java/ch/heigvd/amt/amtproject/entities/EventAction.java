package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	// TODO add query
	// @NamedQuery(name = "Action.findAllByApiKey", query = "...")
})
public class EventAction extends AbstractEntity<Long>{
    @Column(unique = true, nullable = false)
    private String name;
    
    @ManyToOne
    private Rule rule;
    
    private int nbPoint;
    
    private String badgeName;
    
    public EventAction(){
    }
    
    public EventAction(String name, String badgeName, int nbPoint, Rule rule){
        this.name = name;
        this.nbPoint = nbPoint;
        this.badgeName = badgeName;
        this.rule = rule;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setNbPoint(int nbPoint) {
        this.nbPoint = nbPoint;
    }
    
    public int getNbPoint() {
        return nbPoint;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }
    
    public String getBadgeName() {
        return badgeName;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public Rule getRule() {
        return rule;
    }
}
