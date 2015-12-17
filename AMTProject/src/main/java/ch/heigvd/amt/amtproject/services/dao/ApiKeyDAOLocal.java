package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.entities.ApiKey;
import javax.ejb.Local;

@Local
public interface ApiKeyDAOLocal extends IGenericDAO<ApiKey, Long> {
    
}
