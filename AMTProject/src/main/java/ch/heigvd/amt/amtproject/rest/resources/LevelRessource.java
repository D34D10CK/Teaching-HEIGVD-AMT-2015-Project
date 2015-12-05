package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.model.entities.Level;
import ch.heigvd.amt.amtproject.rest.dto.LevelDTO;
import ch.heigvd.amt.amtproject.services.dao.rest.LevelDAOLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
@Path("levels")
public class LevelRessource {

    @EJB
    private LevelDAOLocal levelDAO;

    @GET
    @Produces("application/json")
    public List<LevelDTO> getLevels(@HeaderParam("api-key") String apiKey) {
        List<LevelDTO> dtos = new ArrayList<>();
        List<Level> levels = levelDAO.getLevels(apiKey);
        for (Level l : levels) {
            dtos.add(new LevelDTO(l));
        }

        return dtos;
    }

    @POST
    @Consumes("application/json")
    public Response createLevel() {
        return null;
    }
}
