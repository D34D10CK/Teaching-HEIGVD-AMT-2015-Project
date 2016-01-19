package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.EventCondition;
import ch.heigvd.amt.amtproject.entities.Rule;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class RuleDAO extends GenericDAO<Rule, Long> implements RuleDAOLocal{
    @Override
    public List<Rule> findAppRuleByEventAndConditions(String eventName, List<EventCondition> conditions){
        List<Rule> rules = em.createNamedQuery("Rule.findByEvent")
                .setParameter("event", eventName)
                .getResultList();
        List<Rule> result = new ArrayList<>();
        
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
                result.add(r);
            }
        }
        return result;
    }
    
    @Override
    public List<Rule> getAppRules(Application app){
        return em.createNamedQuery("Rule.findByApp")
                .setParameter("app", app)
                .getResultList();
    }
}
