package org.launchcode.Walkabout_Backend.service;

import lombok.RequiredArgsConstructor;
import org.launchcode.Walkabout_Backend.entity.User;
import org.launchcode.Walkabout_Backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            var userObj = user.get();
            return User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .roles(getRoles(userObj))
                    .build();

        } else {
            throw new UsernameNotFoundException(username);
        }
    }

//    private String[] getRoles(User user) {
    private List<String> getRoles(User user) {
        if (user.getRole() == null){
            return new String[]{"USER"};

        }
            return user.getRole().split(",");
    }


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
