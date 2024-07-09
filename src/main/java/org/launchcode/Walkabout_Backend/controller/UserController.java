package org.launchcode.Walkabout_Backend.controller;

import lombok.RequiredArgsConstructor;
import org.launchcode.Walkabout_Backend.entity.User;
import org.launchcode.Walkabout_Backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*") //allows backend to communicate with frontend
public  class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        return userService.postUser(user);
    }


    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    //used Postman to check Get All Users API http://localhost:8080/api/users


    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ("id")Long id){
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>("User with ID " + id + " deleted successfully", HttpStatus.OK);
        } catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable ("id") Long id){
        User user = userService.getUserById(id);

        if(user == null) return  ResponseEntity.notFound().build();
        return  ResponseEntity.ok(user);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id,
    @RequestBody User user){
        User updateUser = userService.updateUser(id,user);

        if (updateUser ==null) return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return ResponseEntity.ok(updateUser);
    }
}