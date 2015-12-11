/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.model.entities.EventCondition;
import ch.heigvd.amt.amtproject.model.entities.Rule;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class RuleDAO extends GenericDAO<Rule, Long> implements RuleDAOLocal{
    @Override
    public Rule findAppRuleByEventAndConditions(String eventName, List<EventCondition> conditions){
        List<Rule> rules = em.createNamedQuery("Rule.findByEvent")
                .setParameter("event", eventName)
                .getResultList();
        for (Rule r : rules){
            boolean passed = true;
            List<EventCondition> rConditions = r.getConditions();
            for (EventCondition c : conditions){
                if (!rConditions.contains(c)){
                    passed = false;
                    break;
                }
            }
            if (passed){
                return r;
            }
        }
        return null;
    }
}
