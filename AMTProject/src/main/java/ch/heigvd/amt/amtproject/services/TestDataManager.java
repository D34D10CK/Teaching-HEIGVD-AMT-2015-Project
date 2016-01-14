package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.Level;
import ch.heigvd.amt.amtproject.entities.ApiKey;
import ch.heigvd.amt.amtproject.entities.EndUser;
import ch.heigvd.amt.amtproject.entities.Account;
import ch.heigvd.amt.amtproject.entities.Badge;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.UserDAOLocal;

import ch.heigvd.amt.amtproject.services.dao.ApiKeyDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.EndUserDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.RoleDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.LevelDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.*;

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
    BadgeDAOLocal badgeDAO;

    @EJB
    LevelDAOLocal levelDAO;

    @EJB
    RuleDAOLocal RulelDAO;

    @Override
    public void generateTestData() {
        // creation de deux utilisateurs
        Account u = new Account("test@t.com", "t", "t", "t");
        Account u2 = new Account("marc@heig-vd.ch", "Marc", "Pellet", "bonjour");
        userDAO.create(u);
        userDAO.create(u2);
        // creation des apikey pour 3 applications
        ApiKey key1 = new ApiKey("c45e61bf-dbf1-4404-bf6d-7fcbb83d4d26");
        ApiKey key2 = new ApiKey();
        ApiKey key3 = new ApiKey();
        apiKeyDAO.create(key1);
        apiKeyDAO.create(key2);
        apiKeyDAO.create(key3);
        // creation de 3 applications
        Application a1 = new Application(key1, u, "app1", "c'est la première app", true);
        Application a2 = new Application(key2, u2, "app2", "c'est une autre app", true);
        Application a3 = new Application(key3, u, "app3", "Et bim une troisième app", false);
        applicationDAO.create(a1);
        applicationDAO.create(a2);
        applicationDAO.create(a3);

        // creation de 154 utilisateurs par application
        for (int i = 1; i < 155; i++) {
            createEndUser(a3, i);
            createEndUser(a1, i);
            createEndUser(a2, i);
        }
        // creation de deux badges
        Badge b1 = new Badge("Test1", "https://playfoursquare.s3.amazonaws.com/badge/300/local.png", a1);
        Badge b2 = new Badge("Test2", "https://playfoursquare.s3.amazonaws.com/badge/300/newbie.png", a1);
        badgeDAO.create(b1);
        badgeDAO.create(b2);
        // creation de deux levels
        Level l1 = new Level("Newbie", 100, a1);
        Level l2 = new Level("Rookie", 200, a1);
        levelDAO.create(l1);
        levelDAO.create(l2);
        
	//UserRole r1 = new UserRole("admin");
        //UserRole r2 = new UserRole("developper");
        //roleDAO.create(r1);
        //roleDAO.create(r2);
    }

    private void createEndUser(Application app, int id) {
        EndUser e = new EndUser();

        e.setApp(app);
        app.getEndUsers().add(e);
        e.setUserId("" + id);
        enduUserDAO.create(e);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
