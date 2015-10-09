package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.User;
import ch.heigvd.amt.amtproject.model.entities.Application;

import javax.ejb.Singleton;
import java.util.LinkedList;
import java.util.List;

@Singleton
public class AppsDataStore implements AppsDataStoreLocal {
	private final List<Application> catalog = new LinkedList<>();

	public AppsDataStore() {
		// TODO fill catalog
	}

	@Override
	public List<Application> getAllApps() {
		return new LinkedList<>(catalog);
	}
}
