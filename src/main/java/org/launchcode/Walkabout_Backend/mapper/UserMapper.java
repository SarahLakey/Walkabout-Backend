package org.launchcode.Walkabout_Backend.mapper;

import org.launchcode.Walkabout_Backend.dto.UserDto;
import org.launchcode.Walkabout_Backend.entity.User;

public interface UserMapper {
//public class UserMapper {

    public static UserDto mapToUserDto (User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail()
                );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getUsername(),
                userDto.getEmail()
                );
    }

}

//TODO: If continue to get errors, refer to User entity and consider removing mapper