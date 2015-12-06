package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.model.entities.Level;
import ch.heigvd.amt.amtproject.services.dao.IGenericDAO;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LevelDAOLocal extends IGenericDAO<Level, Long>{

    List<Level> getLevels(String apiKey);
}
