package org.launchcode.Walkabout_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

//    public UserDto(Long id, String firstName, String lastName, String username, String email) {
//    }


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

//UserDto class transfers data between the client and the server
