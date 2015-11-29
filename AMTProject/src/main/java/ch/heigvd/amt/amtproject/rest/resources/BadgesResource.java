/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.rest.dto.BadgeCreationDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.BadgeDAOLocal;
import ch.heigvd.amt.amtproject.rest.dto.BadgeDTO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author David
 */
@Stateless
@Path("badges")
public class BadgesResource {
    @EJB
    private BadgeDAOLocal badgesDAO;
    
    @EJB
    private ApplicationDAOLocal applicationsDAO;
    
    
    /**
     * Retourne la liste des badges existants liés à l'application
     * 
     * @param appApiKey - api key unique identifiant l'application
     * @return la liste des badges
     */
    @GET
    @Produces("application/json")
    public List<BadgeDTO> getAppBadges(@PathParam(value="apiKey") String appApiKey){
        return null;
    }
    
    @POST
    @Consumes("application/json")
    public Response createBadge(BadgeCreationDTO newBadge){
        return null;
    }
    
}
