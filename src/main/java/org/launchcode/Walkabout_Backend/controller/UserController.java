package org.launchcode.Walkabout_Backend.controller;

import lombok.AllArgsConstructor;
import org.launchcode.Walkabout_Backend.dto.UserDto;
import org.launchcode.Walkabout_Backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    //Build Add User REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody  UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}