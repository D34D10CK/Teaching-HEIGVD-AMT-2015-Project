package ch.heigvd.amt.amtproject.rest.dto;

import java.util.HashMap;

public class EventTriggerDTO {
    private String eventName;
    private String userId;
    private String timestanp;
    private HashMap<String, String> conditions = new HashMap<>();

    public String getEventName() {
        return eventName;
    }

    public String getUserId() {
        return userId;
    }

    public String getTimestanp() {
        return timestanp;
    }

    public HashMap<String, String> getConditions() {
        return conditions;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTimestanp(String timestanp) {
        this.timestanp = timestanp;
    }

    public void setConditions(HashMap<String, String> conditions) {
        this.conditions = conditions;
    }
    
}
