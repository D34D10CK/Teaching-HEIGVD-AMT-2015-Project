package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.entities.*;
import ch.heigvd.amt.amtproject.rest.dto.BadgeCreationDTO;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.UserDAOLocal;

import ch.heigvd.amt.amtproject.services.dao.ApiKeyDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.EndUserDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.RoleDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.BadgeDAO;
import ch.heigvd.amt.amtproject.services.dao.rest.BadgeDAOLocal;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TestDataManager implements TestDataManagerLocal {
    
    @EJB
    UserDAOLocal userDAO;
    
    @EJB
    ApplicationDAOLocal applicationDAO;
    
    @EJB
    ApiKeyDAOLocal apiKeyDAO;
    
    @EJB
    RoleDAOLocal roleDAO;

	@EJB
	EndUserDAOLocal enduUserDAO;

	@EJB
	BadgeDAOLocal badgeDAOLocal;

    @Override
    public void generateTestData() {
        Account u = new Account("test@t.com", "t", "t", "t");
        Account u2 = new Account("marc@heig-vd.ch", "Marc", "Pellet", "bonjour");
        
        userDAO.create(u);
        userDAO.create(u2);
        
        ApiKey key1 = new ApiKey("c45e61bf-dbf1-4404-bf6d-7fcbb83d4d26");
        ApiKey key2 = new ApiKey();
        ApiKey key3 = new ApiKey();
        
        apiKeyDAO.create(key1);
        apiKeyDAO.create(key2);
        apiKeyDAO.create(key3);
        
        
        
        Application a1 = new Application(key1, u, "app1", "c'est la première app", true);
        Application a2 = new Application(key2, u2, "app2", "c'est une autre app", true);
        Application a3 = new Application(key3, u, "app3", "Et bim une troisième app", false);
        
        applicationDAO.create(a1);
        applicationDAO.create(a2);
        applicationDAO.create(a3);
        
        for(int i = 0; i < 154; i++){
            createEndUser(a3);
            createEndUser(a1);
            createEndUser(a2);
        }

		Badge b1 = new Badge("Test1", "https://playfoursquare.s3.amazonaws.com/badge/300/local.png", a1);
		Badge b2 = new Badge("Test2", "https://playfoursquare.s3.amazonaws.com/badge/300/newbie.png", a1);

		badgeDAOLocal.create(b1);
		badgeDAOLocal.create(b2);

        //UserRole r1 = new UserRole("admin");
        //UserRole r2 = new UserRole("developper");
        
        //roleDAO.create(r1);
        //roleDAO.create(r2);
    }
    
    private void createEndUser(Application app){
        EndUser e = new EndUser();
        e.setApp(app);
        enduUserDAO.create(e);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
