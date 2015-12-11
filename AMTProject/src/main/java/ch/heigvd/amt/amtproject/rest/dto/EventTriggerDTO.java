package ch.heigvd.amt.amtproject.rest.dto;

import java.util.HashMap;

public class EventTriggerDTO {
    private String eventName;
    private String userId;
    private long eventDate;
    private HashMap<String, String> conditions;

    public String getEventName() {
        return eventName;
    }

    public String getUserId() {
        return userId;
    }

    public long getEventDate() {
        return eventDate;
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

    public void setEventDate(long date) {
        this.eventDate = date;
    }

    public void setConditions(HashMap<String, String> conditions) {
        this.conditions = conditions;
    }
    
}
