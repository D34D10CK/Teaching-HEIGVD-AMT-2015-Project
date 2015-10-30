/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.model.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Marc
 */
@Entity
public class Role extends AbstractEntity<Long>{
    
    @Column(nullable = false, unique = true)
    private String role;
    
    @ManyToMany
    List<User> users;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    
}
