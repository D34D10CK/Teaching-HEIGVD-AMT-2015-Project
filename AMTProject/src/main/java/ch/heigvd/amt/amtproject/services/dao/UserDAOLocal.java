package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.Account;
import javax.ejb.Local;

@Local
public interface UserDAOLocal extends IGenericDAO<Account, Long>{

    Account testConnection(String username, String password);

    
}
