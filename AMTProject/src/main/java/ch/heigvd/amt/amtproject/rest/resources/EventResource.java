package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.model.entities.ApiKey;
import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.Badge;
import ch.heigvd.amt.amtproject.model.entities.BadgeAward;
import ch.heigvd.amt.amtproject.model.entities.EndUser;
import ch.heigvd.amt.amtproject.model.entities.EventAction;
import ch.heigvd.amt.amtproject.model.entities.EventCondition;
import ch.heigvd.amt.amtproject.model.entities.PointAward;
import ch.heigvd.amt.amtproject.model.entities.Rule;
import ch.heigvd.amt.amtproject.rest.dto.EventTriggerDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.EndUserDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.BadgeDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.EventConditionDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.RuleDAOLocal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("events")
public class EventResource {
    @EJB
    private ApplicationDAOLocal appDAO;
    
    @EJB
    private RuleDAOLocal rulesDAO;
    
    @EJB
    private EventConditionDAOLocal conditionsDAO;
    
    @EJB
    private EndUserDAOLocal endUsersDAO;
    
    @EJB
    private BadgeDAOLocal badgesDAO;
    
    @Context
    UriInfo uriInfo;
    
    @POST
    @Consumes("application/json")
    public Response triggerEvent(EventTriggerDTO dto ,@HeaderParam("apiKey") String apiKey){
        // on recupere l'application
        Application app = appDAO.getAppByApiKey(new ApiKey(apiKey));
        // on recupere l'utilisateur concerne
        EndUser user = endUsersDAO.findByAppAndUserId(app, dto.getUserId());
        // on extrait toutes les conditions liées a l'event
        List<EventCondition> conditions = extractCondition(dto.getConditions(), app);
        // on recupère la regle correspondant aux conditions et au type d'evenement
        Rule rule = rulesDAO.findAppRuleByEventAndConditions(dto.getEventName(), conditions);
        // une fois la regle recuperee, on applique les actions associees
        applyActions(rule.getActions(), user, dto.getEventDate(), app);
        
        return Response.ok().build();
    }
    
    private List<EventCondition> extractCondition(HashMap<String,String> conditions, Application app){
        List<EventCondition> temp = new ArrayList<>();
        // pacours de la hash map pour recuperer la clé et la valeur de chaque entree
        for (Entry<String, String> entry : conditions.entrySet()){
            // on recupere l'EventCondition correspondant et on l'ajoute a la liste
            temp.add(conditionsDAO.findByKeyAndValueAndApp(entry.getKey(), entry.getValue(), app));
        }
        // retourne la liste d'EventCondition extraite
        return temp;
    }
    
    private void applyActions(List<EventAction> actions, EndUser user, Calendar date, Application app){
        
        for (EventAction a : actions){
            // gestion des pts
            if (a.getNbPoint() != 0){
                PointAward pa = new PointAward();
                pa.setReason("none yet");
                pa.setPoints(a.getNbPoint());
                pa.setUser(user);
                pa.setObtainmentDate(date);
            }
            // gestion des badges
            if (!(a.getBadgeName().isEmpty())){
                // recuperation du badge
                Badge badge = badgesDAO.findByName(a.getBadgeName(), app);
                BadgeAward ba = new BadgeAward();
                ba.setReason("none yet");
                ba.setBadge(badge);
                ba.setUser(user);
                ba.setObtainmentDate(date);
            }
        }
    }
}
