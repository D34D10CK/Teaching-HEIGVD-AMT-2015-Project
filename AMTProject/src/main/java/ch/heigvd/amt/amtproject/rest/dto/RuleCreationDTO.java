/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.rest.dto;

import ch.heigvd.amt.amtproject.model.entities.EventAction;

import java.util.List;


public class RuleCreationDTO {
    private String appApiKey;
    private String eventType;
    private List<EventAction> actions;

    public String getAppApiKey() {
        return appApiKey;
    }

    public String getEventType() {
        return eventType;
    }

    public List<EventAction> getActions() {
        return actions;
    }

    public void setAppApiKey(String appApiKey) {
        this.appApiKey = appApiKey;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setActions(List<EventAction> actions) {
        this.actions = actions;
    }
}
