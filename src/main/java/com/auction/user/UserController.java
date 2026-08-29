package com.auction.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {

    public final UserService userService;

    @PostMapping("/user")
    public void createUser(
            @RequestBody UserRequestDto dto
    ){
        userService.toCreateUser(dto);
    }
}
