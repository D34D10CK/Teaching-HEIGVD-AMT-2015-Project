/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.EventCondition;
import ch.heigvd.amt.amtproject.entities.Rule;
import ch.heigvd.amt.amtproject.services.dao.IGenericDAO;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RuleDAOLocal extends IGenericDAO<Rule, Long>{
    List<Rule> findAppRuleByEventAndConditions(String eventName, List<EventCondition> conditions);
    List<Rule> getAppRules(Application app);
}
