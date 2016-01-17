package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.Badge;
import ch.heigvd.amt.amtproject.entities.BadgeAward;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BadgeAwardDAO extends GenericDAO<BadgeAward, Long> implements BadgeAwardDAOLocal {

    @Override
    public List<Badge> getBadgesById(String userId, Application app) {
        return (List<Badge>)em.createNamedQuery("BadgeAward.getBadgesOfUser")
                .setParameter("userId", userId)
                .setParameter("app", app)
                .getResultList();
    }
}
