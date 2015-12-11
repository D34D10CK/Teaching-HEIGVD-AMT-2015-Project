package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.model.entities.BadgeAward;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import javax.ejb.Stateless;

@Stateless
public class BadgeAwardDAO extends GenericDAO<BadgeAward, Long> implements BadgeAwardDAOLocal{
    
}
