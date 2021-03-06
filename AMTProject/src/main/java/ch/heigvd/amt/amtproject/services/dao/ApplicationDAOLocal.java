package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.entities.ApiKey;
import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.Account;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ApplicationDAOLocal extends IGenericDAO<Application, Long> {

    public String makeApiKey();

    List<Application> getAppList(Account user);

    List<Object> getAppListWithNumber(Account user);

    Application getAppByApiKey(ApiKey apiKey);
}
