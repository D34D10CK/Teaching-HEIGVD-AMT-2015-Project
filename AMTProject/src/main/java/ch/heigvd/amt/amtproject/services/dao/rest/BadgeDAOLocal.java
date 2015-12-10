package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.Badge;
import ch.heigvd.amt.amtproject.services.dao.IGenericDAO;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BadgeDAOLocal extends IGenericDAO<Badge, Long> {

    List<Badge> getAppBadges(String apiKey);
    Badge findByName(String name, Application app);
}
