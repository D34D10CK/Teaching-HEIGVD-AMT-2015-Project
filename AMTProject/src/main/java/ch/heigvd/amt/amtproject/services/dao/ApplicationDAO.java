package ch.heigvd.amt.amtproject.services.dao;

import javax.ejb.Stateless;
import ch.heigvd.amt.amtproject.model.entities.Application;
import java.util.Random;
import java.util.UUID;

@Stateless
public class ApplicationDAO extends GenericDAO<Application, Long> implements ApplicationDAOLocal {

    @Override
    public String makeApiKey() {
       
        return UUID.randomUUID().toString();
        
    }

    
    
}
