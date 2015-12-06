package ch.heigvd.amt.amtproject.services.dao;

import javax.ejb.Stateless;

import ch.heigvd.amt.amtproject.model.entities.ApiKey;
import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.Account;
import java.util.List;
import java.util.UUID;

@Stateless
public class ApplicationDAO extends GenericDAO<Application, Long> implements ApplicationDAOLocal {

    @Override
    public String makeApiKey() {
        return UUID.randomUUID().toString();
    }

    @Override
    public List<Application> getAppList(Account user) {
        return em.createNamedQuery("Application.findByUser").setParameter("user", user).getResultList();
    }

    @Override
    public List<Object> getAppListWithNumber(Account user) {
        return em.createNamedQuery("Application.findNumberByUser").setParameter("user", user).getResultList();
    }

    @Override
    public Application getAppByApiKey(ApiKey apiKey) {
        return (Application) em.createNamedQuery("Application.findByApiKey").setParameter("apiKey", apiKey).getSingleResult();
    }
}
