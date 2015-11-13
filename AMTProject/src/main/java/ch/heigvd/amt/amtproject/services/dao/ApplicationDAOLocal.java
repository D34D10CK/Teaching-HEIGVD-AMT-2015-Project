package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ApplicationDAOLocal extends IGenericDAO<Application, Long>{

    public String makeApiKey();

    List<Application> getAppList(User user);

    
}
