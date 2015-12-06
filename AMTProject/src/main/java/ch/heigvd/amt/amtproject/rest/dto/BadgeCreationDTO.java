/**
 * BadgeCreationDTO contient les éléments nécessaires à la création
 * d'un badge et de sa liaison avec une application (à l'aide l'apikey)
 * 
 * Ces informations DOIVENT être fournie par le client dans le corps de 
 * sa requête pour le bon déroulement de l'opération
 * 
 * apiKey : apikey de l'application appelante
 * imgUrl    : url de l'image a utiliser pour le badge
 * imgName   : nom du badge en question
 */
package ch.heigvd.amt.amtproject.rest.dto;


import ch.heigvd.amt.amtproject.model.entities.ApiKey;
import ch.heigvd.amt.amtproject.model.entities.Application;

public class BadgeCreationDTO {
    private Application app;
    private String imgUrl;
    private String badgeName;

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}
    
    public String getUrl(){
        return imgUrl;
    }
    
    public void setUrl(String url){
        imgUrl = url;
    }
    
    public String getBadgeName(){
        return badgeName;
    }
    
    public void setBadgeName(String name){
        badgeName = name;
    }
}
