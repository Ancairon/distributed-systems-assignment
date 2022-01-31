package org.hua.dit.dsproject.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    //The class that will be saved on the db as a row of a table
    @Id
    @Column(name = "idNumber")
    private String idNumber;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
  //  @Column(name = "active")
    //private boolean active;
    @Column(name = "role")
    private String role;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   // public boolean isActive() {
    //    return active;
   // }


    public User() {
    }

    public User(String idNumber, String userName, String password, String role) {
        this.idNumber = idNumber;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }


    //  public void setActive(boolean active) {
    //    this.active = active;
   // }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}