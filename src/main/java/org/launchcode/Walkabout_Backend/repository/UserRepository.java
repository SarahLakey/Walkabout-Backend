package org.launchcode.Walkabout_Backend.repository;

import org.launchcode.Walkabout_Backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User findByUsername(String username);
//    User findById(Long id);

}
