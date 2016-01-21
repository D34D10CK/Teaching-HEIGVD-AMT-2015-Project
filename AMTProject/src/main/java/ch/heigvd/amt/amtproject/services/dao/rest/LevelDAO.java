package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.Level;
import ch.heigvd.amt.amtproject.services.dao.GenericDAO;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class LevelDAO extends GenericDAO<Level, Long> implements LevelDAOLocal {

    /**
     * Retourne une list des Level correspondants à une ApiKey
     *
     * @param apiKey une String représentant l'ApiKey
     * @return une List de Level correspondants à l'api key donnée en paramètre
     */
    @Override
    public List<Level> getLevels(String apiKey) {
        return em.createNamedQuery("Level.findByApiKey").setParameter("apiKey", apiKey).getResultList();
    }
    
    @Override
    public Level getUserLvl(int nbPoints, Application app) {
        return (Level) em.createNamedQuery("Level.findUserLevel")
                .setParameter("nbPoints", nbPoints)
                .setParameter("app", app)
                .setMaxResults(1)
                .getSingleResult();
    }

	@Override
	public Level getUserNextLvl(int nbPoints, Application app) {
		return (Level) em.createNamedQuery("Level.findUserNextLevel")
				.setParameter("nbPoints", nbPoints)
				.setParameter("app", app)
				.setMaxResults(1)
				.getSingleResult();
	}
}
