package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.EventAction;
import ch.heigvd.amt.amtproject.services.dao.IGenericDAO;
import javax.ejb.Local;

@Local
public interface EventActionDAOLocal extends IGenericDAO<EventAction, Long> {
    
}
