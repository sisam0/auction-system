package com.auction.auction;

import com.auction.user.User;
import org.springframework.stereotype.Service;

@Service
public class AuctionMapper {

    public Auction toAuction(AuctionRequestDto dto){
        User user = User.builder()
                .userId(1)
                .build();

        return Auction.builder()
                .user(user)
                .title(dto.title())
                .description(dto.description())
                .increase(dto.increase())
                .status(dto.status())
                .startingPrice(dto.startingPrice())
                .endTime(dto.endTime())
                .build();
    }
}
