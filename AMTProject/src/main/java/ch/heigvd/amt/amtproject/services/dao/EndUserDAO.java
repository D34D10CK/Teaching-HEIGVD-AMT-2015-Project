package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.Application;
import javax.ejb.Stateless;
import ch.heigvd.amt.amtproject.model.entities.EndUser;
import java.util.List;

@Stateless
public class EndUserDAO extends GenericDAO<EndUser, Long> implements EndUserDAOLocal {

    @Override
    public List<EndUser> getEndUserList(Application app) {
        return em.createNamedQuery("EndUser.findByApp").setParameter("app", app).getResultList();
    }

    @Override
    public List<EndUser> findByAppAndPage(Application app, int pageSize, int pageIndex) {
        return em.createNamedQuery("EndUser.findByApp").setParameter("app", app).setMaxResults(pageSize).setFirstResult(pageIndex * pageSize).getResultList();
    }
    
    @Override
    public EndUser findByAppAndUserId(Application app, String userId){
        return (EndUser) em.createNamedQuery("EndUser.findByAppAndUserId")
                .setParameter("app", app).setParameter("userid", userId)
                .getSingleResult();
    }
}
