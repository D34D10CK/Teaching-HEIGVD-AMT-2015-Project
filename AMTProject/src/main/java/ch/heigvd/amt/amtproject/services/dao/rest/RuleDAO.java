/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.ApiKey;
import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.EventCondition;
import ch.heigvd.amt.amtproject.entities.Rule;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class RuleDAO extends GenericDAO<Rule, Long> implements RuleDAOLocal{
    @Override
    public Rule findAppRuleByEventAndConditions(String eventName, List<EventCondition> conditions){
        return (Rule)em.createNamedQuery("Rule.findByEventAndConditions")
                .setParameter("event", eventName)
                .setParameter("conditions", conditions)
                .getSingleResult();
    }
}
