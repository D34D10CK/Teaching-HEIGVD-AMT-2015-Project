package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.entities.ApiKey;
import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.EndUser;
import ch.heigvd.amt.amtproject.entities.PointAward;
import ch.heigvd.amt.amtproject.rest.dto.EndUserCreationDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.EndUserDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.PointAwardDAOLocal;
import java.util.Calendar;
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
    
    @EJB
    private PointAwardDAOLocal pointAwardsDAO;
    
    @POST
    @Consumes("application/json")
    public Response createEndUser(EndUserCreationDTO newEndUser, @HeaderParam("apiKey") String apikey) {
        Application app = applicationsDAO.getAppByApiKey(new ApiKey(apikey));

        EndUser e = new EndUser();
        e.setApp(app);
        e.setUserId(newEndUser.getUserId());
        endUsersDAO.create(e);
        
        // conversion long (timemillis) into a Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(newEndUser.getDate());
        // gestion des pts
        PointAward pa = new PointAward();
        pa.setReason("User creation");
        pa.setPoints(0);
        pa.setUser(e);
        pa.setObtainmentDate(calendar);
        pointAwardsDAO.create(pa);
        
        return Response.ok().build();
    }
}
