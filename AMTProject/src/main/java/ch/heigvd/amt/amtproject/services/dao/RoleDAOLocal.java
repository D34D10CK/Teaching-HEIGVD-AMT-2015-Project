/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.UserRole;
import javax.ejb.Local;

/**
 *
 * @author Marc
 */
@Local
public interface RoleDAOLocal extends IGenericDAO<UserRole, Long> {
    
}
