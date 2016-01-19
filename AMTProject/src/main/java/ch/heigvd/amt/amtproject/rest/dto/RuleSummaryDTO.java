package ch.heigvd.amt.amtproject.rest.dto;

import java.net.URI;


public class RuleSummaryDTO {
    private URI href;
    private String eventType;

    public URI getHref() {
        return href;
    }

    public void setHref(URI href) {
        this.href = href;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
    
}
