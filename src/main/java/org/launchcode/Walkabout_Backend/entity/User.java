package org.launchcode.Walkabout_Backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email")
    private String email;



    public User(Long id, String firstName, String lastName, String username, String email) {
    }


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
