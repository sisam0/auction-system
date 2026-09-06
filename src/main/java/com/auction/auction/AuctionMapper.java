package com.auction.auction;

import com.auction.user.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AuctionMapper {

    public Auction toAuction(AuctionRequestDto dto){
        User user = User.builder()
                .userId(2)
                .build();

        return Auction.builder()
                .user(user)
                .sellerName(dto.sellerName())
                .title(dto.title())
                .description(dto.description())
                .increase(dto.increase())
                .status(dto.status())
                .startingPrice(dto.startingPrice())
                .endTime(dto.endTime())
                .build();
    }

    public AuctionResponseDto toAuctionResponseDto(Auction auction, BigDecimal currentAmt){
        return new AuctionResponseDto(
                auction.getSellerName(),
                auction.getTitle(),
                auction.getDescription(),
                auction.getIncrease(),
                auction.getStartTime(),
                auction.getEndTime(),
                currentAmt
        );
    }

}
