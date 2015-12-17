package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.EventCondition;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import javax.ejb.Stateless;

@Stateless
public class EventConditionDAO extends GenericDAO<EventCondition, Long> implements EventConditionDAOLocal {
    @Override
    public EventCondition findByKeyAndValueAndApp(String key, String value, Application app){
        return (EventCondition) em.createNamedQuery("EventCondition.findByKeyAndValueAndApp")
                .setParameter("key", key).setParameter("value", value)
                .setParameter("app", app).getSingleResult();
    }
}
