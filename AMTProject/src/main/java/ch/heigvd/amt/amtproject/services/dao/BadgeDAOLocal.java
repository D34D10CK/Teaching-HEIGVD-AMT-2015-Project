/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services.dao;

import ch.heigvd.amt.amtproject.model.entities.Badge;
import javax.ejb.Local;

@Local
public interface BadgeDAOLocal extends IGenericDAO<Badge, Long>{
    
}
