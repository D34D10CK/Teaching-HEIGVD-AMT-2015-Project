package ch.heigvd.amt.amtproject.rest.dto;

import ch.heigvd.amt.amtproject.entities.Application;

public class EndUserCreationDTO {
    private Application app;
    private String userId;

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }  
}
