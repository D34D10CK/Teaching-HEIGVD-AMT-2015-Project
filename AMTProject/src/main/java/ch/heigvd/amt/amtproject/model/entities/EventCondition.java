package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "EventCondition.findByKeyAndValueAndApp", 
                query = "select e from EventCondition e, Rule r where e.key = :key and e.value = :value and e.rule = r and r.app = :app")
})
public class EventCondition extends AbstractEntity<Long>{
    @ManyToOne
    private Rule rule;
    
    @Column(nullable = false)
    private String key;
    
    @Column(nullable = false)
    private String value;
    
    public EventCondition(){
        
    }
    
    public EventCondition(String key, String value, Rule rule){
        this.rule = rule;
        this.key = key;
        this.value = value;
    }

    public Rule getRule() {
        return rule;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
