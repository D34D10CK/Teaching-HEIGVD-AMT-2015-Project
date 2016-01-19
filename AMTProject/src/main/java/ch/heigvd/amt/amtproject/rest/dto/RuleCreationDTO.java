
package ch.heigvd.amt.amtproject.rest.dto;

import java.util.HashMap;
import java.util.List;


public class RuleCreationDTO {
    private String eventType;
    private List<EventActionDTO> actions;
    private HashMap<String, String> conditions;

    public List<EventActionDTO> getActions() {
        return actions;
    }

    public void setActions(List<EventActionDTO> actions) {
        this.actions = actions;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public HashMap<String, String> getConditions() {
        return conditions;
    }

    public void setConditions(HashMap<String, String> conditions) {
        this.conditions = conditions;
    }
    
}
