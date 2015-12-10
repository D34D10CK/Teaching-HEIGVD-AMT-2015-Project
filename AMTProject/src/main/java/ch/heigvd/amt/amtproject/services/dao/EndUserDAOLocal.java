package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.EndUser;
import java.util.List;
import javax.ejb.Local;

@Local
public interface EndUserDAOLocal extends IGenericDAO<EndUser, Long>{
 
    List<EndUser> getEndUserList(Application app);

    List<EndUser> findByAppAndPage(Application app, int pageize, int pageIndex);
    
    EndUser findByAppAndUserId(Application app, String userId);
    
}
