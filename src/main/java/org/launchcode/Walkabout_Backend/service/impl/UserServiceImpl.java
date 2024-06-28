package org.launchcode.Walkabout_Backend.service.impl;

import lombok.AllArgsConstructor;
import org.launchcode.Walkabout_Backend.dto.UserDto;
import org.launchcode.Walkabout_Backend.entity.User;
import org.launchcode.Walkabout_Backend.mapper.UserMapper;
import org.launchcode.Walkabout_Backend.repository.UserRepository;
import org.launchcode.Walkabout_Backend.service.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(savedUser);
    }
}
