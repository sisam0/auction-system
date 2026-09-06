package com.auction.bid;

import com.auction.auction.Auction;
import com.auction.repository.AuctionRepo;
import com.auction.repository.BidRepo;
import com.auction.repository.UserRepo;
import com.auction.user.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@Service
public class BidMapper {

    public final AuctionRepo auctionRepo;
    public final UserRepo userRepo;

    public Bid toBid(Auction auction, User user, BidRequestDto dto){
        return Bid.builder()
                .auction(auction)
                .user(user)
                .amount(dto.amount())
                .build();
    }

    public BidResponseDto toBidResponseDto(Bid bid, String uName, String sName){
        return new BidResponseDto(
                sName,
                uName,
                bid.getAmount(),
                bid.getBidTime()
        );
    }
}
