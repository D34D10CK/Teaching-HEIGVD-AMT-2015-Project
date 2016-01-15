package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.EventAction;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import javax.ejb.Stateless;

@Stateless
public class EventActionDAO extends GenericDAO<EventAction, Long> implements EventActionDAOLocal {
    
}