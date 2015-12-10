package ch.heigvd.amt.amtproject.rest.dto;

import java.util.Calendar;
import java.util.HashMap;

public class EventTriggerDTO {
    private String eventName;
    private String userId;
    private Calendar eventDate;
    private HashMap<String, String> conditions = new HashMap<>();

    public String getEventName() {
        return eventName;
    }

    public String getUserId() {
        return userId;
    }

    public Calendar getEventDate() {
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

    public void setEventDate(Calendar cal) {
        this.eventDate = cal;
    }

    public void setConditions(HashMap<String, String> conditions) {
        this.conditions = conditions;
    }
    
}
