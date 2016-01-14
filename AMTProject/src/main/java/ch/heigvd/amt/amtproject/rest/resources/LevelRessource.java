package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.entities.ApiKey;
import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.Level;
import ch.heigvd.amt.amtproject.rest.dto.LevelCreationDTO;
import ch.heigvd.amt.amtproject.rest.dto.LevelDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.LevelDAOLocal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
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

        for (Level lvl : levels) {
            LevelDTO dto = new LevelDTO(lvl);
            URI href = uriInfo
                    .getBaseUriBuilder()
                    .path(LevelRessource.class)
                    .path(LevelRessource.class, "getLevel")
                    .build(lvl.getId());
            dto.setHref(href);
            dtos.add(dto);
        }

        return dtos;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public LevelDTO getLevel(@PathParam(value = "id") long id) {
        Level level = levelDAO.findById(id);
        LevelDTO dto = new LevelDTO(level);

        return dto;
    }

    @POST
    @Consumes("application/json")
    public Response createLevel(LevelCreationDTO newLevel, @HeaderParam("apiKey") String apiKey) {
        Application app = applicationDAO.getAppByApiKey(new ApiKey(apiKey));

        Level level = new Level();
        level.setApplication(app);
        level.setName(newLevel.getName());
        level.setRequiredPoints(newLevel.getRequiredPoints());

        long id = levelDAO.create(level);

        URI href = uriInfo
                .getBaseUriBuilder()
                .path(LevelRessource.class)
                .path(LevelRessource.class, "deleteLevel")
                .build(id);

        return Response.created(href).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLevel(@PathParam(value = "id") long id) {
        Level level = levelDAO.findById(id);
        levelDAO.delete(level);
        return Response.ok().build();
    }
}
