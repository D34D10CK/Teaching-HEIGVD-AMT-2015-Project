/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.rest.resources;

import ch.heigvd.amt.amtproject.model.entities.ApiKey;
import ch.heigvd.amt.amtproject.model.entities.Rule;
import ch.heigvd.amt.amtproject.rest.dto.RuleCreationDTO;
import ch.heigvd.amt.amtproject.rest.dto.RuleDTO;
import ch.heigvd.amt.amtproject.rest.dto.RuleSummaryDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.RuleDAOLocal;
import java.util.ArrayList;
import java.util.List;
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
public class RulesResource {
    @EJB
    private RuleDAOLocal rulesDAO;
    
    @EJB
    private ApplicationDAOLocal applicationsDAO;
    
    @Context
    UriInfo uriInfo;
    
    @POST
    @Consumes("application/json")
    public Response createRule(RuleCreationDTO newRule){
        /*Application app = applicationsDAO.getAppByApiKey(newRule.getAppApiKey());
                
        Rule rule = new Rule();
        rule.setActions(newRule.getActions());
        rule.setConditions(newRule.getConditions());
        rule.setEventType(newRule.getEventType());
        rule.setApp(app);
        
        long ruleId = rulesDAO.create(rule);
        
        URI href = uriInfo
        .getBaseUriBuilder()
        .path(RulesResource.class)
        .path(RulesResource.class, "getRule")
        .build(ruleId);

        return Response
        .created(href)
        .build();*/
        return null;
    }
    
    @GET
    @Produces("application/json")
    public List<RuleSummaryDTO> getAppRules(@HeaderParam("apiKey") ApiKey apiKey){
        /*
        List<RuleSummaryDTO> result = new ArrayList<>();
        List<Rule> appRules = rulesDAO.getAppRules(apiKey);
        for (Rule rule : appRules) {
            RuleSummaryDTO dto = new RuleSummaryDTO();
            populateSummaryDTOFromEntity(rule, dto);
            result.add(dto);
        }
        return result;*/
        return null;
    }
    
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public RuleDTO getRule(@PathParam(value = "id") long id){
        return null;
    }
    
    private void populateSummaryDTOFromEntity(Rule rule, RuleSummaryDTO dto){
        //TODO
    }
}
