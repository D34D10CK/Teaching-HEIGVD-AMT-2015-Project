package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.entities.Badge;
import ch.heigvd.amt.amtproject.rest.dto.ReputationDTO;
import ch.heigvd.amt.amtproject.services.dao.rest.BadgeAwardDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.PointAwardDAOLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Path("reputation")
public class ReputationRessource {

    @EJB
    private BadgeAwardDAOLocal badgeAwardDAO;

    @EJB
    private PointAwardDAOLocal pointAwardDAO;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public ReputationDTO getReputation(@PathParam(value = "id") long id) {
        int points = pointAwardDAO.getPointsById(id);
        List<Badge> badges = badgeAwardDAO.getBadgesById(id);

        ReputationDTO dto = new ReputationDTO();
        dto.setBadges(badges);
        dto.setPoints(points);

        return dto;
    }
}
