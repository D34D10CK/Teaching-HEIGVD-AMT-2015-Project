/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

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
    
    
}
