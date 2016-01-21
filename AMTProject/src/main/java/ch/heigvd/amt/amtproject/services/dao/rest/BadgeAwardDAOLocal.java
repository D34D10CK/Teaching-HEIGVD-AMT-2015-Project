package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.Badge;
import ch.heigvd.amt.amtproject.entities.BadgeAward;
import ch.heigvd.amt.amtproject.services.dao.IGenericDAO;
import java.util.List;
import javax.ejb.Local;

@Local
public interface BadgeAwardDAOLocal extends IGenericDAO<BadgeAward, Long> {

    List<Badge> getBadgesById(String userId, Application app);
    
}
