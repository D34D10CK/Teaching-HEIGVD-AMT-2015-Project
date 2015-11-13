/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.Application;
import ch.heigvd.amt.amtproject.model.entities.Account;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marc
 */
@Local
public interface ApplicationDAOLocal extends IGenericDAO<Application, Long>{

    public String makeApiKey();

    List<Application> getAppList(Account user);

    
}
