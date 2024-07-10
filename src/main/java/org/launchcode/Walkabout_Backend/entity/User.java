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

    @Column(name = "verifyPassword")
    private String verifyPassword;

    @Column(name = "email")
    private String email;


}
