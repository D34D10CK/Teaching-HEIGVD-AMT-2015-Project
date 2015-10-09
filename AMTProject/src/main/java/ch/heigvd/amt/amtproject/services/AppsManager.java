package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.entities.Application;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class AppsManager implements AppsManagerLocal {
	private static final int MAX_DATABASE_DELAY_MS = 0;
	//private static final int MAX_DATABASE_DELAY_MS = 10000;
	@EJB
	AppsDataStoreLocal appsDataStore;

	/**
	 * This method returns the list of all beers in the data store.
	 * @return a list of beers
	 */
	@Override
	public List<Application> getAllApps() {
		simulateDatabaseDelay();
		return appsDataStore.getAllApps();
	}

	private void simulateDatabaseDelay() {
		long simulatedDatabaseLookupTime = (long)(Math.random() * MAX_DATABASE_DELAY_MS);
		try {
			Thread.sleep(simulatedDatabaseLookupTime);
		} catch (InterruptedException ex) {
			Logger.getLogger(AppsManager.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

}
