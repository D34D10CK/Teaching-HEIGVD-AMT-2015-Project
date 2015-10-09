package ch.heigvd.amt.amtproject.services.dao;

import javax.ejb.Stateless;
import ch.heigvd.amt.amtproject.model.entities.Application;
import java.util.Random;

@Stateless
public class ApplicationDAO extends GenericDAO<Application, Long> implements ApplicationDAOLocal {

    public void makeApiKey() {
        String apiKey = generateApiKey();
        Application app = null;
        try {
            app = (Application) em.createNamedQuery("Application.findByApiKey").setParameter("key", apiKey).getSingleResult();
        } catch (Exception e) {
        }
        while (app != null) {
            apiKey = generateApiKey();
            try {
                app = (Application) em.createNamedQuery("Application.findByApiKey").setParameter("key", apiKey).getSingleResult();
            } catch (Exception e) {
            }
        }
        app = new Application();
        app.setApiKey(apiKey);
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
}
