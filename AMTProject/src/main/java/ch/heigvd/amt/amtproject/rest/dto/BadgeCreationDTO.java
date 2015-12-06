/**
 * BadgeCreationDTO contient les éléments nécessaires à la création
 * d'un badge et de sa liaison avec une application (à l'aide l'apikey)
 * 
 * Ces informations DOIVENT être fournie par le client dans le corps de 
 * sa requête pour le bon déroulement de l'opération
 * 
 * appApiKey : apikey de l'application appelante
 * imgUrl    : url de l'image a utiliser pour le badge
 * imgName   : nom du badge en question
 */
package ch.heigvd.amt.amtproject.rest.dto;


public class BadgeCreationDTO {
    private String appApiKey;
    private String imgUrl;
    private String badgeName;
    
    public String getAppApiKey(){
        return appApiKey;
    }
    
    public void setAppApiKey(String apiKey){
        appApiKey = apiKey;
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
