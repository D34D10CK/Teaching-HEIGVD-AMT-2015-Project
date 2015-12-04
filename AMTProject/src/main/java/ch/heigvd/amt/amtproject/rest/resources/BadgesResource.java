/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.Badge;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.BadgeDAOLocal;
import ch.heigvd.amt.amtproject.rest.dto.BadgeDTO;
import ch.heigvd.amt.amtproject.rest.dto.BadgeCreationDTO;
import ch.heigvd.amt.amtproject.rest.dto.BadgeSummaryDTO;
import java.net.URI;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

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
    
    @Context
    UriInfo uriInfo;
    
    /**
     * Ajoute et lie un nouveau badge à l'application
     * 
     * @param newBadge - informations nécessaires à la creation du badge
     * @return l'URI de la nouvelle ressource
     */
    @POST
    @Consumes("application/json")
    public Response createBadge(BadgeCreationDTO newBadge){
        Application app = applicationsDAO.getAppByApiKey(newBadge.getAppApiKey());
                
        Badge badge = new Badge();
        badge.setName(newBadge.getBadgeName());
        badge.setPictureUrl(newBadge.getUrl());
        badge.setApp(app);
        
        long badgeId = badgesDAO.create(badge);
        
        URI href = uriInfo
        .getBaseUriBuilder()
        .path(BadgesResource.class)
        .path(BadgesResource.class, "getCompany")
        .build(badgeId);

        return Response
        .created(href)
        .build();
    }
    
    /**
     * Retourne la liste des badges existants liés à l'application
     * 
     * @param appApiKey - api key unique identifiant l'application
     * @return la liste des badges
     */
    @GET
    @Produces("application/json")
    public List<BadgeSummaryDTO> getAppBadges(@PathParam(value="apiKey") String appApiKey){
        return null;
    }
    
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public BadgeDTO getBadge(@PathParam(value = "id") long id){
        return null;
    }
    
}
