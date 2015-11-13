package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.User;
import javax.ejb.Local;

@Local
public interface UserDAOLocal extends IGenericDAO<User, Long>{

    User testConnection(String username, String password);

    
}
