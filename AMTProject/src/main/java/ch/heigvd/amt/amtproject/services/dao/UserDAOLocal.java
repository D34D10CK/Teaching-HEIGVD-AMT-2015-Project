/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.User;
import javax.ejb.Local;

/**
 *
 * @author Marc
 */
@Local
public interface UserDAOLocal extends IGenericDAO<User, Long>{

    
}
