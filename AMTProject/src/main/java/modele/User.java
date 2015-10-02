/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

/**
 *
 * @author Marc
 */
public class User {
    String email;
    String firstName;
    String lastName;
    int userId;

    public User(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User{" + "email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", userId=" + userId + '}';
    }
    
    
    
}
