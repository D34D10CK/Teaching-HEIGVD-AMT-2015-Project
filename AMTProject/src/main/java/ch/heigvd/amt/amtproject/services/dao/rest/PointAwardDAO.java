package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.PointAward;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import javax.ejb.Stateless;

@Stateless
public class PointAwardDAO extends GenericDAO<PointAward, Long> implements PointAwardDAOLocal {

    @Override
    public long getPointsById(String userId, Application app) {
        return (Long)em.createNamedQuery("PointAward.getUserPoints")
                .setParameter("userId", userId)
                .setParameter("app", app)
                .getSingleResult();
    }
}
