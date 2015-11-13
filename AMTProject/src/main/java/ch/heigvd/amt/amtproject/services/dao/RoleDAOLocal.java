package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.UserRole;
import javax.ejb.Local;

@Local
public interface RoleDAOLocal extends IGenericDAO<UserRole, Long> {
    
}
