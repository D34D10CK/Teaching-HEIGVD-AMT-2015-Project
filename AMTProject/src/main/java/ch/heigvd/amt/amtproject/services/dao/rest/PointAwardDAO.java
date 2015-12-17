package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.PointAward;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import javax.ejb.Stateless;

@Stateless
public class PointAwardDAO extends GenericDAO<PointAward, Long> implements PointAwardDAOLocal {

    @Override
    public int getPointsById(long id) {
        return em.createNamedQuery("PointAward.getPointsOfUser").setParameter("user", id).getFirstResult();
    }
}
