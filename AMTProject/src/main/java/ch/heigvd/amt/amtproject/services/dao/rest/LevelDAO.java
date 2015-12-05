package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.model.entities.Level;
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
}
