package ch.heigvd.amt.amtproject.services.dao;

import javax.ejb.Stateless;
import ch.heigvd.amt.amtproject.model.entities.Application;
import java.util.Random;

@Stateless
public class ApplicationDAO extends GenericDAO<Application, Long> implements ApplicationDAOLocal {

    @Override
    public String makeApiKey() {
        String apiKey;
        
        do{
           apiKey = generateApiKey();
        }while(keyAlreadyExists(apiKey));

        return apiKey;
    }

    private String generateApiKey() {
        char[] chars = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            builder.append(chars[random.nextInt(chars.length)]);
        }
        return builder.toString();
    }

    @Override
    public boolean keyAlreadyExists(String apiKey) {
        Application app = null;
        try {
            app = (Application) em.createNamedQuery("Application.findByApiKey").setParameter("key", apiKey).getSingleResult();
        } catch (Exception e) {
        }
        return app != null;
    }
    
    
}
