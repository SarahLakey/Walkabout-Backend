package org.launchcode.Walkabout_Backend.repository;

import org.launchcode.Walkabout_Backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //user optional since sometimes username exists and sometimes it does not
    Optional<org.springframework.security.core.userdetails.User> findByUsername(String username);
}
