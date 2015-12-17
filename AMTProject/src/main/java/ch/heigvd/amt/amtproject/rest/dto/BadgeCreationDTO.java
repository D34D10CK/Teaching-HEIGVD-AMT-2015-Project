/**
 * BadgeCreationDTO contient les éléments nécessaires à la création d'un badge
 * et de sa liaison avec une application (à l'aide l'apikey)
 *
 * Ces informations DOIVENT être fournie par le client dans le corps de sa
 * requête pour le bon déroulement de l'opération
 *
 * apiKey : apikey de l'application appelante imgUrl : url de l'image a utiliser
 * pour le badge name : nom du badge en question
 */
package ch.heigvd.amt.amtproject.rest.dto;

import ch.heigvd.amt.amtproject.entities.Application;

public class BadgeCreationDTO {

    private Application app;
    private String imageUrl;
    private String name;

    public Application getApp() {
        return app;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
