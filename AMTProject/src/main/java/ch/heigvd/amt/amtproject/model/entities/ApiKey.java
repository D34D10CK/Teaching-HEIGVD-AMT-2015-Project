/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model.entities;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Marc
 */
@Entity
public class ApiKey extends AbstractEntity<Long>{
    
    @Column(nullable = false, unique = true)
    private String apiKey;

    public ApiKey() {
        apiKey =  UUID.randomUUID().toString();
    }

    public ApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    
    
}
