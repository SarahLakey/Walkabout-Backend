package org.launchcode.Walkabout_Backend.service;

import lombok.RequiredArgsConstructor;
import org.launchcode.Walkabout_Backend.entity.User;
import org.launchcode.Walkabout_Backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User postUser(User user){
        return userRepository.save(user);
    }

}
