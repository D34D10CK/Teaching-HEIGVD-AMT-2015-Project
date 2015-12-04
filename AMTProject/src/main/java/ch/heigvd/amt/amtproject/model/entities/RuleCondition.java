/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    // A COMPLETETETASDJ OASJDIOAS DASDASDASDasd
    @NamedQuery(name = "Condition.findAllByRuleId", query = "...")
})
public class RuleCondition extends AbstractEntity<Long>{
    @Column(unique = true, nullable = false)
    private String key;
    
    @NotNull
    private String value;
    
    @ManyToOne
    private Rule rule;

    public RuleCondition() {
    }

    public RuleCondition(String key, String value, Rule rule) {
        this.key = key;
        this.value = value;
        this.rule = rule;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Rule getRule() {
        return rule;
    }
}
