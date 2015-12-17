package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.PointAward;
import ch.heigvd.amt.amtproject.services.dao.IGenericDAO;
import javax.ejb.Local;

@Local

public interface PointAwardDAOLocal extends IGenericDAO<PointAward, Long> {

    int getPointsById(long id);
}
