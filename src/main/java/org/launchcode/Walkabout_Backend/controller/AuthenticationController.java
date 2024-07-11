package org.launchcode.Walkabout_Backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api")
//@RequiredArgsConstructor
//@CrossOrigin("*") //allows backend to communicate with frontend
@Controller
public class AuthenticationController {

    @GetMapping("/home")
    public String handleWelcome() {
        return "home";
    }

    @GetMapping("/admin/home")
    public String handleAdminDashboard(){
        return "home_admin";
    }

    @GetMapping("/user/home")
    public String handleUserDashboard(){
        return "home_user";
    }

}
