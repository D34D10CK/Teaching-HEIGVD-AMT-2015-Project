package ch.heigvd.amt.amtproject.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class UserRole extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String userRole;

    @ManyToMany
    private List<Account> users;

    public UserRole() {
    }

    public UserRole(String role) {
        this.userRole = role;
    }

    public String getRole() {
        return userRole;
    }

    public void setRole(String role) {
        this.userRole = role;
    }

    public List<Account> getUsers() {
        return users;
    }

    public void setUsers(List<Account> users) {
        this.users = users;
    }
}
