package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.entities.ApiKey;
import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.Badge;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.BadgeDAOLocal;
import ch.heigvd.amt.amtproject.rest.dto.BadgeDTO;
import ch.heigvd.amt.amtproject.rest.dto.BadgeCreationDTO;
import ch.heigvd.amt.amtproject.rest.dto.BadgeSummaryDTO;

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
     * @param apikey
     * @return l'URI de la nouvelle ressource
     */
    @POST
    @Consumes("application/json")
    public Response createBadge(BadgeCreationDTO newBadge, @HeaderParam("apiKey") String apikey) {
        Application app = applicationsDAO.getAppByApiKey(new ApiKey(apikey));

        Badge badge = new Badge();
        badge.setName(newBadge.getName());
        badge.setImageUrl(newBadge.getImageUrl());
        badge.setApp(app);

        long badgeId = badgesDAO.create(badge);
        URI href = uriInfo
                .getBaseUriBuilder()
                .path(BadgesResource.class)
                .path(BadgesResource.class, "getBadge")
                .build(badgeId);

        return Response
                .created(href)
                .build();

        // return Response.ok(123).build();
    }

    /**
     * Retourne la liste des badges existants liés à l'application
     *
     * @param apiKey - api-key unique identifiant l'application
     * @return la liste des badges
     */
    @GET
    @Produces("application/json")
    public List<BadgeSummaryDTO> getAppBadges(@HeaderParam("apiKey") String apiKey) {
        List<BadgeSummaryDTO> result = new ArrayList<>();
        List<Badge> appBadges = badgesDAO.getAppBadges(apiKey);
        for (Badge badge : appBadges) {
            BadgeSummaryDTO dto = new BadgeSummaryDTO();
            populateSummaryDTOFromEntity(badge, dto);
            result.add(dto);
        }
        return result;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public BadgeDTO getBadge(@PathParam(value = "id") long id) {
        Badge badge = badgesDAO.findById(id);
        BadgeDTO dto = new BadgeDTO();
        populateDTOFromEntity(badge, dto);
        return dto;
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBadge(@PathParam(value = "id") long id) {
        Badge badge = badgesDAO.findById(id);
        badgesDAO.delete(badge);
        return Response.ok().build();
    }

    private void populateSummaryDTOFromEntity(Badge badge, BadgeSummaryDTO dto) {
        long badgeId = badge.getId();
        URI badgeHref = uriInfo
                .getAbsolutePathBuilder()
                .path(BadgesResource.class, "getBadge")
                .build(badgeId);
        dto.setHref(badgeHref);
        dto.setName(badge.getName());
        dto.setImageUrl(badge.getImageUrl());
    }

    private void populateDTOFromEntity(Badge badge, BadgeDTO dto) {
        populateSummaryDTOFromEntity(badge, dto);
        dto.setImageUrl(badge.getImageUrl());
    }
}
