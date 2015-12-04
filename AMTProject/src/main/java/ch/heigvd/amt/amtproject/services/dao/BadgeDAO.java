/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.ApiKey;
import ch.heigvd.amt.amtproject.model.entities.Badge;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BadgeDAO extends GenericDAO<Badge, Long> implements BadgeDAOLocal {
    @Override
    public List<Badge> getAppBadges(ApiKey apiKey){
        return em.createNamedQuery("Application.findByApiKey").setParameter("apiKey", apiKey).getResultList();
    }
}