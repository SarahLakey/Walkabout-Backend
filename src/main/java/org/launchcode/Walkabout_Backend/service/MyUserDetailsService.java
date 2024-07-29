//package org.launchcode.Walkabout_Backend.service;
//
//import org.launchcode.Walkabout_Backend.entity.User;
//import org.launchcode.Walkabout_Backend.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<org.springframework.security.core.userdetails.User> user = userRepository.findByUsername(username);
//        if (user.isPresent()){
//            var userObj = user.get();
//            return User.builder()
//                    .username(userObj.getUsername())
//                    .password(userObj.getPassword())
//                    .roles(getRoles(userObj))
//                    .build();
//        } else{
//            throw new UsernameNotFoundException(username);
//        }
//    }
//
//    private String[] getRoles(User user){
//        if (user.getRole() == null){
//            return new String[]{"USER"};
//        }
//        return user.getRole().split(",");
//    }
//}
