package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Badge;
import ch.heigvd.amt.amtproject.entities.BadgeAward;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class BadgeAwardDAO extends GenericDAO<BadgeAward, Long> implements BadgeAwardDAOLocal {

    @Override
    public List<Badge> getBadgesById(long id) {
        return em.createNamedQuery("BadgeAward.getBadgesOfUser").setParameter("user", id).getResultList();
    }
}
