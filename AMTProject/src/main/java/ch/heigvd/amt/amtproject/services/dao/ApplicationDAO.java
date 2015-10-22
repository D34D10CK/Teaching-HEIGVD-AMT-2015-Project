package ch.heigvd.amt.amtproject.services.dao;

import javax.ejb.Stateless;
import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.User;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Stateless
public class ApplicationDAO extends GenericDAO<Application, Long> implements ApplicationDAOLocal {

    @Override
    public String makeApiKey() {
       
        return UUID.randomUUID().toString();
        
    }

    @Override
    public List<Application> getAppList(User user) {
        return em.createNamedQuery("Application.findByUser").setParameter("user", user).getResultList();  
    }
    
    

    
    
}
