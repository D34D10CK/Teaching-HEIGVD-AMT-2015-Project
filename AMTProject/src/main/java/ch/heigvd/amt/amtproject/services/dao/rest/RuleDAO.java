/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.model.entities.ApiKey;
import ch.heigvd.amt.amtproject.model.entities.Rule;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class RuleDAO extends GenericDAO<Rule, Long> implements RuleDAOLocal{
    @Override
    public List<Rule> getAppRules(ApiKey apiKey){
        return em.createNamedQuery("Application.findByApiKey").setParameter("apiKey", apiKey).getResultList();
    }
}
