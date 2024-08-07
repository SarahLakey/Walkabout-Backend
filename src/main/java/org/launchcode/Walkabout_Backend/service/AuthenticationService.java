package org.launchcode.Walkabout_Backend.service;

import org.launchcode.Walkabout_Backend.entity.AuthenticationResponse;
import org.launchcode.Walkabout_Backend.entity.User;
import org.launchcode.Walkabout_Backend.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse register(User request){
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        user.setRole(user.getRole());

        user = userRepository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }





}
