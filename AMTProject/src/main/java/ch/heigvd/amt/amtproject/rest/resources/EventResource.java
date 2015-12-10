package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.model.entities.ApiKey;
import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.EventCondition;
import ch.heigvd.amt.amtproject.model.entities.Rule;
import ch.heigvd.amt.amtproject.rest.dto.EventTriggerDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.EventConditionDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.RuleDAOLocal;
import java.util.ArrayList;
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
    
    @Context
    UriInfo uriInfo;
    
    @POST
    @Consumes("application/json")
    public Response triggerEvent(EventTriggerDTO dto ,@HeaderParam("apiKey") String apiKey){
        // on recupere l'application
        Application app = appDAO.getAppByApiKey(new ApiKey(apiKey));
        // on extrait toutes les conditions liées a l'event
        List<EventCondition> conditions = extractCondition(dto.getConditions(), app);
        // on recupère la regle correspondant aux conditions et au type d'evenement
        Rule rule = rulesDAO.findAppRuleByEventAndConditions(dto.getEventName(), conditions);
        // une fois la regle recuperee, on applique les actions associees
        
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
}
