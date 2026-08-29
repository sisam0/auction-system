package com.auction.user;

public record UserRequestDto(
        String username,
        String email,
        String password,
        Integer phone,
        String address
) {
}
