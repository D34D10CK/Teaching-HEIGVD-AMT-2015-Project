package ch.heigvd.amt.amtproject.services.dao.rest;

import ch.heigvd.amt.amtproject.model.entities.Level;
import java.util.List;
import javax.ejb.Local;

@Local
public interface LevelDAOLocal {

    List<Level> getLevels(String apiKey);
}
