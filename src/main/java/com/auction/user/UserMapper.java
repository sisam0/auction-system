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

    public UserResponseDto toUserResponseDto(User user){
        return new UserResponseDto(
                user.getUsername(),
                user.getEmail(),
                user.getAddress(),
                user.getPhone()
        );
    }

}
