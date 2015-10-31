/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.EndUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marc
 */
@Local
public interface EndUserDAOLocal extends IGenericDAO<EndUser, Long>{
 
    List<EndUser> getEndUserList(Application app);

    List<EndUser> findByAppAndPage(Application app, int pageize, int pageIndex);
    
}
