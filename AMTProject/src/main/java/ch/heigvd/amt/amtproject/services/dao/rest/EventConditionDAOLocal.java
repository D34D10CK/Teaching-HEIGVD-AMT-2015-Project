package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.EventCondition;
import ch.heigvd.amt.amtproject.services.dao.IGenericDAO;
import javax.ejb.Local;

@Local
public interface EventConditionDAOLocal extends IGenericDAO<EventCondition, Long> {
    EventCondition findByKeyAndValueAndApp(String key, String value, Application app);
}
