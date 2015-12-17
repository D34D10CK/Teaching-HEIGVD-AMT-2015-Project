package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "EventCondition.findByKeyAndValueAndApp", 
                query = "select e from EventCondition e, Rule r where e.conditionName = :key and e.conditionValue = :value and e.rule = r and r.app = :app")
})
public class EventCondition extends AbstractEntity<Long>{
    @ManyToOne
    private Rule rule;
    
    @Column(nullable = false)
    private String conditionName;
    
    @Column(nullable = false)
    private String conditionValue;
    
    public EventCondition(){
        
    }
    
    public EventCondition(String conditionName, String conditionValue, Rule rule){
        this.rule = rule;
        this.conditionName = conditionName;
        this.conditionValue = conditionValue;
    }

    public Rule getRule() {
        return rule;
    }

    public String getConditionName() {
        return conditionName;
    }

    public String getConditionValue() {
        return conditionValue;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public void setConditionValue(String conditionValue) {
        this.conditionValue = conditionValue;
    }
    
    
}
