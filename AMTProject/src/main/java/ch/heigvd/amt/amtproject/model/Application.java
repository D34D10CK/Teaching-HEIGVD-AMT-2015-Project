/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model;

/**
 *
 * @author Marc
 */
public class Application {
    String name;
    String description;
    String APIkey;
    int userId;
    boolean enable;

    
    public Application(String name, String description, String APIkey, int userId, boolean enable) {
        this.name = name;
        this.description = description;
        this.APIkey = APIkey;
        this.userId = userId;
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAPIkey() {
        return APIkey;
    }

    public int getUserId() {
        return userId;
    }

    public boolean isEnable() {
        return enable;
    }
    
    
    
}
