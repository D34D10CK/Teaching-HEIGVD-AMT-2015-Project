package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.entities.ApiKey;
import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.Badge;
import ch.heigvd.amt.amtproject.entities.Level;
import ch.heigvd.amt.amtproject.rest.dto.BadgeDTO;
import ch.heigvd.amt.amtproject.rest.dto.ReputationDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.BadgeAwardDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.LevelDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.PointAwardDAOLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Stateless
@Path("reputation")
public class ReputationRessource {
    @EJB
    private ApplicationDAOLocal applicationDAO;

    @EJB
    private BadgeAwardDAOLocal badgeAwardDAO;

    @EJB
    private PointAwardDAOLocal pointAwardDAO;
    
    @EJB
    private LevelDAOLocal levelDAO;

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public ReputationDTO getReputation(@PathParam(value = "id") String userId, @HeaderParam("apiKey") String apikey) {
        // recupération de l'application concernée
        Application app = applicationDAO.getAppByApiKey(new ApiKey(apikey));
        // recupération des points de l'utilisateur concerné
        long points = pointAwardDAO.getPointsById(userId, app);
        // recupération des badges gagnés par l'utilisateur concerné
        List<Badge> badges = badgeAwardDAO.getBadgesById(userId, app);
        
        List<BadgeDTO> badgesDTO = new ArrayList<BadgeDTO>();
        for (Badge b : badges){
            BadgeDTO newBadge = new BadgeDTO();
            newBadge.setImageUrl(b.getImageUrl());
            newBadge.setName(b.getName());
            badgesDTO.add(newBadge);
        }
        
        // recupération du level courant de l'utilisateur
        Level level = levelDAO.getUserLvl((new Long(points)).intValue(), app);
        
        ReputationDTO dto = new ReputationDTO();
        dto.setPoints(points);
        dto.setBadges(badgesDTO);
        dto.setLevel(level.getName());
        return dto;
    }
}
