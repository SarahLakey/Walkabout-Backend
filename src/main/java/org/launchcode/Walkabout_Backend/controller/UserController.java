package org.launchcode.Walkabout_Backend.controller;

import lombok.RequiredArgsConstructor;
import org.launchcode.Walkabout_Backend.entity.User;
import org.launchcode.Walkabout_Backend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public  class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        return userService.postUser(user);
    }

}