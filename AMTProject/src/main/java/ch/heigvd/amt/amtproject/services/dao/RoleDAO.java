/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao;

import javax.ejb.Stateless;
import ch.heigvd.amt.amtproject.model.entities.Role;
/**
 *
 * @author Marc
 */
@Stateless
public class RoleDAO extends GenericDAO<Role, Long>implements RoleDAOLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}