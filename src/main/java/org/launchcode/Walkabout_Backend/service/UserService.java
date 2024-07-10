package org.launchcode.Walkabout_Backend.service;

import lombok.RequiredArgsConstructor;
import org.launchcode.Walkabout_Backend.entity.User;
import org.launchcode.Walkabout_Backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User postUser(User user){
        return userRepository.save(user);
    }

    //return list of all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //delete user
    public void deleteUser(Long id){

            //first check existence of user
        if (!userRepository.existsById(id)){
            throw new EntityNotFoundException("User with ID " + id + " not found");
        }
        userRepository.deleteById(id);

    }

    //Creating Get User by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
                //findById already exists through JPA
                //since the id may not exist/be null - need or else
    }

    public User updateUser(Long id, User user){
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()){
            User existingUser = optionalUser.get();

            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setVerifyPassword(user.getVerifyPassword());

            return  userRepository.save(existingUser);
        }
        return null;
    }
}
