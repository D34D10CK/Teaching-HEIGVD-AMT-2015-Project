package ch.heigvd.amt.amtproject.services.dao;

import javax.ejb.Stateless;
import ch.heigvd.amt.amtproject.model.entities.UserRole;

@Stateless
public class RoleDAO extends GenericDAO<UserRole, Long> implements RoleDAOLocal {

}
