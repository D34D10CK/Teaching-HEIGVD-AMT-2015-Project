package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.entities.ApiKey;
import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.EventAction;
import ch.heigvd.amt.amtproject.entities.EventCondition;
import ch.heigvd.amt.amtproject.entities.Rule;
import ch.heigvd.amt.amtproject.rest.dto.EventActionDTO;
import ch.heigvd.amt.amtproject.rest.dto.EventConditionDTO;
import ch.heigvd.amt.amtproject.rest.dto.RuleCreationDTO;
import ch.heigvd.amt.amtproject.rest.dto.RuleDTO;
import ch.heigvd.amt.amtproject.rest.dto.RuleSummaryDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.EventActionDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.EventConditionDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.RuleDAOLocal;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;



@Stateless
@Path("rules")
public class RuleResource {
    @EJB
    private ApplicationDAOLocal appDAO;
    
    @EJB
    private EventConditionDAOLocal conditionsDAO;
    
    @EJB
    private EventActionDAOLocal actionsDAO;
    
    @EJB
    private RuleDAOLocal ruleDAO;
    
    @Context
    UriInfo uriInfo;
    
    @POST
    @Consumes("application/json")
    public Response createRule(RuleCreationDTO dto, @HeaderParam("apiKey") String apiKey){
        // on recupere l'application
        Application app = appDAO.getAppByApiKey(new ApiKey(apiKey));
        // on crée la règle et on l'ajoute à la DB
        Rule rule = new Rule();
        rule.setApp(app);
        rule.setActions(null);
        rule.setConditions(null);
        rule.setEventType(dto.getEventType());
        long ruleId = ruleDAO.create(rule);
        
        linkActions(dto.getActions(), rule);
        linkConditions(dto.getConditions(), rule);
        // on met a jour notre règles après lui avoir ajouté les actions et conditions
        ruleDAO.update(rule);
        
        URI href = uriInfo
                .getBaseUriBuilder()
                .path(RuleResource.class)
                .path(RuleResource.class, "getRule")
                .build(ruleId);
        
        return Response
                .created(href)
                .build();
        //return Response.ok().build();
    }
    
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public RuleDTO getRule(@PathParam(value = "id") long id) {
        Rule rule = ruleDAO.findById(id);
        RuleDTO dto = new RuleDTO();
        populateDTOFromEntity(rule, dto);
        return dto;
    }
    
    @GET
    @Produces("application/json")
    public List<RuleSummaryDTO> getAppRules(@HeaderParam("apiKey") String apiKey) {
        // on recupere l'application
        Application app = appDAO.getAppByApiKey(new ApiKey(apiKey));
        
        List<Rule> rules = ruleDAO.getAppRules(app);
        List<RuleSummaryDTO> result = new ArrayList<>();
        for (Rule rule : rules) {
            RuleSummaryDTO temp = new RuleSummaryDTO();
            populateSummaryDTOFromEntity(rule, temp);
            result.add(temp);
        }
        return result;
    }
    
    private void linkConditions(HashMap<String,String> conditions, Rule rule){
        List<EventCondition> conditionList = new ArrayList<>();
        // pacours de la hash map pour recuperer la clé et la valeur de chaque entree
        for (Map.Entry<String, String> entry : conditions.entrySet()){
            // on crée la condition, on la lie à la règle et on l'ajoute dans la DB
            EventCondition newCondition = new EventCondition();
            // on la complete
            newCondition.setConditionName(entry.getKey());
            newCondition.setConditionValue(entry.getValue());
            newCondition.setRule(rule);
            // on l'ajoute dans la DB
            conditionsDAO.create(newCondition);
            conditionList.add(newCondition);
        }
        // on lie les conditions à la règle
        rule.setConditions(conditionList);
    }
    
    private void linkActions(List<EventActionDTO> actions, Rule rule){
        // on créé les EventActions, on les lient à la règle et on les ajoutent à la DB
        List<EventAction> actionsList = new ArrayList<>();
        for (EventActionDTO a : actions){
            // on crée l'action
            EventAction newAction = new EventAction();
            // on la complète
            newAction.setBadgeName(a.getBadgeName());
            newAction.setName(a.getName());
            newAction.setNbPoint(a.getNbPoints());
            newAction.setRule(rule);
            // on l'ajoute à la DB
            actionsDAO.create(newAction);
            actionsList.add(newAction);
        }
        // on lie les actions à la règle
        rule.setActions(actionsList);
    }
    
    private void populateSummaryDTOFromEntity(Rule rule, RuleSummaryDTO dto) {
        long ruleId = rule.getId();
        URI ruleHref = uriInfo
                .getAbsolutePathBuilder()
                .path(RuleResource.class, "getRule")
                .build(ruleId);
        dto.setHref(ruleHref);
        dto.setEventType(rule.getEventType());
    }
    
    private void populateDTOFromEntity(Rule rule, RuleDTO dto) {
        populateSummaryDTOFromEntity(rule, dto);
        
        List<EventAction> actions = rule.getActions();
        List<EventActionDTO> actionsDTO = new ArrayList<>();
        for (EventAction action : actions){
            EventActionDTO actionDTO = new EventActionDTO();
            actionDTO.setBadgeName(action.getBadgeName());
            actionDTO.setName(action.getName());
            actionDTO.setNbPoints(action.getNbPoint());
            actionsDTO.add(actionDTO);
        }
        dto.setActions(actionsDTO);
        
        List<EventCondition> conditions = rule.getConditions();
        List<EventConditionDTO> conditionsDTO = new ArrayList<>();
        for (EventCondition condition : conditions){
            EventConditionDTO conditionDTO = new EventConditionDTO();
            conditionDTO.setKey(condition.getConditionName());
            conditionDTO.setValue(condition.getConditionValue());
            conditionsDTO.add(conditionDTO);
        }
        dto.setConditions(conditionsDTO);
    }
}
