package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.entities.Application;
import ch.heigvd.amt.amtproject.entities.Level;
import ch.heigvd.amt.amtproject.entities.ApiKey;
import ch.heigvd.amt.amtproject.entities.EndUser;
import ch.heigvd.amt.amtproject.entities.Account;
import ch.heigvd.amt.amtproject.entities.Badge;
import ch.heigvd.amt.amtproject.entities.EventCondition;
import ch.heigvd.amt.amtproject.entities.Rule;
import ch.heigvd.amt.amtproject.entities.EventAction;
import ch.heigvd.amt.amtproject.services.dao.ApplicationDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.UserDAOLocal;

import ch.heigvd.amt.amtproject.services.dao.ApiKeyDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.EndUserDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.RoleDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.LevelDAOLocal;
import ch.heigvd.amt.amtproject.services.dao.rest.*;

import java.util.ArrayList;
import java.util.List;

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
    EventConditionDAOLocal conditionsDAO;
    
    @EJB
    EventActionDAOLocal actionsDAO;
    
    @EJB
    RuleDAOLocal ruleDAO;

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
        Badge b1 = new Badge("Starter", "https://playfoursquare.s3.amazonaws.com/badge/300/local.png", a1);
        Badge b2 = new Badge("Winner", "https://playfoursquare.s3.amazonaws.com/badge/300/newbie.png", a1);
        badgeDAO.create(b1);
        badgeDAO.create(b2);
        // creation de deux levels
		Level l0 = new Level("Newbie", 0, a1);
        Level l1 = new Level("Rookie", 100, a1);
		Level l2 = new Level("Amateur", 200, a1);
		Level l3 = new Level("Enthusiast", 650, a1);
		Level l4 = new Level("Pro", 1000, a1);
		Level l5 = new Level("Super User", 5000, a1);
		Level l6 = new Level("Robot", 100000, a1);

		Level lGod = new Level("God", 1000000, a1);


		levelDAO.create(l0);
		levelDAO.create(l1);
		levelDAO.create(l2);
		levelDAO.create(l3);
		levelDAO.create(l4);
		levelDAO.create(l5);
		levelDAO.create(l6);

		levelDAO.create(lGod);

		// Creation d'une règle pour l'app 1
        Rule rule = new Rule();
        rule.setApp(a1);
        rule.setEventType("msgPosted");
        rule.setActions(null);
        rule.setConditions(null);
        ruleDAO.create(rule);
        // creation d'une condition a la règle
        EventCondition condition = new EventCondition();
        condition.setConditionName("difficulty");
        condition.setConditionValue("hard");
        condition.setRule(rule);
        conditionsDAO.create(condition);
        // creation d'une action associée à la règle
        // action -> points
        EventAction action1 = new EventAction();
        action1.setName("add110Pts");
        action1.setNbPoint(24);
        action1.setBadgeName(null);
        action1.setRule(rule);
        actionsDAO.create(action1);
        // action -> badge
        EventAction action2 = new EventAction();
        action2.setName("addNoobBadge");
        action2.setNbPoint(0);
        action2.setBadgeName("Starter");
        action2.setRule(rule);
        actionsDAO.create(action2);
        // ajout de(s) condition(s) et action(s) à la règle
        List<EventCondition> conditions = new ArrayList<>();
        conditions.add(condition);
        
        List<EventAction> actions = new ArrayList<>();
        actions.add(action1);
        actions.add(action2);
        
        rule.setConditions(conditions);
        rule.setActions(actions);
        ruleDAO.update(rule);
        
        /*
        // REGLE DE LEO 
        Rule r1 = new Rule();
        r1.setApp(a1);
        r1.setEventType("msgCommit");
        r1.setActions(null);
        r1.setConditions(new ArrayList<EventCondition>());
        ruleDAO.create(r1);
        
        EventAction ea1 = new EventAction();
        ea1.setName("give1point");
        ea1.setNbPoint(1);
        ea1.setBadgeName(null);
        ea1.setRule(r1);
        actionsDAO.create(ea1);
        
        List<EventAction> as1 = new ArrayList<>();
        as1.add(ea1);
        r1.setActions(as1);
        ruleDAO.update(r1);
        
        Rule r2 = new Rule();
        r2.setApp(a1);
        r2.setEventType("msgCommit");
        r2.setActions(null);
        r2.setConditions(null);
        ruleDAO.create(r2);
        
        EventCondition c1 = new EventCondition();
        c1.setConditionName("firstCommit");
        c1.setConditionValue("true");
        c1.setRule(r2);
        conditionsDAO.create(c1);
        
        EventAction ea2 = new EventAction();
        ea2.setName("giveFirstCommitBadge");
        ea2.setNbPoint(0);
        ea2.setBadgeName("firstCommit");
        ea2.setRule(r2);
        actionsDAO.create(ea2);
        
        List<EventAction> as2 = new ArrayList<>();
        as2.add(ea2);
        List<EventCondition> cs1 = new ArrayList<>();
        cs1.add(c1);
        r2.setActions(as2);
        r2.setConditions(cs1);
        ruleDAO.update(r2);
        
        Rule r3 = new Rule();
        r3.setApp(a1);
        r3.setEventType("newUser");
        r3.setActions(null);
        r3.setConditions(null);
        ruleDAO.create(r3);
        
        EventAction ea3 = new EventAction();
        ea3.setName("giveNewUserBadge");
        ea3.setNbPoint(0);
        ea3.setBadgeName("newUser");
        ea3.setRule(r3);
        actionsDAO.create(ea3);
        
        List<EventAction> as3 = new ArrayList<>();
        r3.setActions(as3);
        ruleDAO.update(r3);
        */
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
