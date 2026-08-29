package com.auction.user;

import com.auction.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    public final UserRepo userRepo;
    public final UserMapper userMapper;

    public void toCreateUser(UserRequestDto dto){
        var user = userMapper.toUser(dto);
        userRepo.save(user);
    }
}
