package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.entities.ApiKey;
import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.EndUser;
import ch.heigvd.amt.amtproject.rest.dto.EndUserCreationDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.EndUserDAOLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Stateless
@Path("users")
public class EndUserResource {
    @EJB
    private ApplicationDAOLocal applicationsDAO;
    
    @EJB
    private EndUserDAOLocal endUsersDAO;
    
    @POST
    @Consumes("application/json")
    public Response createEndUser(EndUserCreationDTO newEndUser, @HeaderParam("apiKey") String apikey) {
        Application app = applicationsDAO.getAppByApiKey(new ApiKey(apikey));

        EndUser e = new EndUser();
        e.setApp(app);
        e.setUserId(newEndUser.getUserId());
        endUsersDAO.create(e);
        
        return Response.ok().build();
    }
}
