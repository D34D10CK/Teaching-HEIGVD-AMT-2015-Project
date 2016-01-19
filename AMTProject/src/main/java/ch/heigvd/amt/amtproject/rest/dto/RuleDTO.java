package ch.heigvd.amt.amtproject.rest.dto;

import java.util.List;

public class RuleDTO extends RuleSummaryDTO {
    private List<EventConditionDTO> conditions;
    private List<EventActionDTO> actions;

    public List<EventConditionDTO> getConditions() {
        return conditions;
    }

    public void setConditions(List<EventConditionDTO> conditions) {
        this.conditions = conditions;
    }

    public List<EventActionDTO> getActions() {
        return actions;
    }

    public void setActions(List<EventActionDTO> actions) {
        this.actions = actions;
    }
    
    
}
