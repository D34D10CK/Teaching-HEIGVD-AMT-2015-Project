package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.entities.Application;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class AppsManager implements AppsManagerLocal {
	@Override
	public List<Application> getAllApps() {
		// TODO Query DB
		return null;
	}
}
