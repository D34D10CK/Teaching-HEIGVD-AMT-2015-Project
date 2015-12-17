package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.Badge;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BadgeDAO extends GenericDAO<Badge, Long> implements BadgeDAOLocal {

    @Override
    public List<Badge> getAppBadges(String apiKey) {
        return em.createNamedQuery("Badge.findAllByApiKey").setParameter("apiKey", apiKey).getResultList();
    }
    
    @Override
    public Badge findByName(String name, Application app){
        return (Badge) em.createNamedQuery("Badge.findByNameAndApp")
                .setParameter("name", name)
                .setParameter("app", app)
                .getSingleResult();
    }
}
