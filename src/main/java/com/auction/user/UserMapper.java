package com.auction.user;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public User toUser(UserRequestDto dto){
        return User.builder()
                .username(dto.username())
                .email(dto.email())
                .password(dto.password())
                .phone(dto.phone())
                .address(dto.address())
                .build();

    }

    public UserDto toUserDto(User user){
        return new UserDto(
                user.getUsername(),
                user.getEmail(),
                user.getAddress()
        );
    }

    public User toUser(UserDto dto){
        return new User(
                dto.username(),
                dto.email(),
                dto.address()
        );
    }
}
