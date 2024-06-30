package org.launchcode.Walkabout_Backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

//    @Column(name = "username", nullable = false, unique = true)
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;


//    public User(String firstName, String lastName, String username, String email) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.email = email;
//    }
//
//
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public String getEmail() {
//        return email;
//    }
}
