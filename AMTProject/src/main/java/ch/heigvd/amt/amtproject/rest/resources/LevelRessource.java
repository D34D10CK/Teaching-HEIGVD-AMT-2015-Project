package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.rest.dto.LevelDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@Stateless
@Path("levels")
public class LevelRessource {

    @GET
    @Produces("application/json")
    public List<LevelDTO> getLevels(@Context HttpHeaders headers) {
        String apiKey = headers.getHeaderString("apiKey");
        List<LevelDTO> dtos = new ArrayList<>();

        return dtos;
    }
}
