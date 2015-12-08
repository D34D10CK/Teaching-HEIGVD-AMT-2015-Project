package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.model.entities.ApiKey;
import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.Level;
import ch.heigvd.amt.amtproject.rest.dto.LevelCreationDTO;
import ch.heigvd.amt.amtproject.rest.dto.LevelDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.LevelDAOLocal;
import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("levels")
public class LevelRessource {

    @EJB
    private LevelDAOLocal levelDAO;

    @EJB
    private ApplicationDAOLocal applicationDAO;

    @Context
    UriInfo uriInfo;

    @GET
    @Produces("application/json")
    public List<LevelDTO> getLevels(@HeaderParam("apiKey") String apiKey) {
        List<LevelDTO> dtos = new ArrayList<>();
        List<Level> levels = levelDAO.getLevels(apiKey);
        for (Level l : levels) {
            dtos.add(new LevelDTO(l));
        }

        return dtos;
    }

    @POST
    @Consumes("application/json")
    public Response createLevel(LevelCreationDTO newLevel) {
        Application app = applicationDAO.getAppByApiKey(newLevel.getApiKey());

        Level level = new Level();
        level.setApplication(app);
        level.setName(newLevel.getName());
        level.setRequiredPoints(newLevel.getRequiredPoints());

        long id = levelDAO.create(level);

        URI href = uriInfo
                .getBaseUriBuilder()
                .path(LevelRessource.class)
                .build(id);

        return Response.created(href).build();
    }
}
