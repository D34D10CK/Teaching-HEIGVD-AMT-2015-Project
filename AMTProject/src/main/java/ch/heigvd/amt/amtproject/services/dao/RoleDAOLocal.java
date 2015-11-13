package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.Role;
import javax.ejb.Local;

@Local
public interface RoleDAOLocal extends IGenericDAO<Role, Long> {
    
}
