package com.auction.user;

public record UserResponseDto(
        String username,
        String email,
        String address,
        Integer phone
) {
}
