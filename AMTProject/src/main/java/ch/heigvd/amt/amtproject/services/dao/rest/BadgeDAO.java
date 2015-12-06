package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.model.entities.ApiKey;
import ch.heigvd.amt.amtproject.model.entities.Badge;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BadgeDAO extends GenericDAO<Badge, Long> implements BadgeDAOLocal {

    @Override
    public List<Badge> getAppBadges(ApiKey apiKey) {
       return em.createNamedQuery("Badge.findAllByApiKey").setParameter("apiKey", apiKey).getResultList();
    }
}
