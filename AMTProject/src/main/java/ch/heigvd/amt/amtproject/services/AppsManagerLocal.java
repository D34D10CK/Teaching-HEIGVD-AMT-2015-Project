package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.entities.Application;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AppsManagerLocal {
	List<Application> getAllApps();
}
