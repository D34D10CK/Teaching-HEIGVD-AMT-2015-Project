package ch.heigvd.amt.amtproject.services.dao;
import ch.heigvd.amt.amtproject.model.entities.Account;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

@Stateless
public class UserDAO extends GenericDAO<Account, Long> implements UserDAOLocal {

    @Override
    public Account testConnection(String username, String password) {
        Account u = null;
        try{
            u = (Account)em.createNamedQuery("Account.testConnection").setParameter("username", username).setParameter("password", password).getSingleResult();
        }catch(NoResultException e){
            
        }
        return u;
    }

    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
