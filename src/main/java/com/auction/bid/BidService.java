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

import java.math.BigDecimal;
import java.math.RoundingMode;

@AllArgsConstructor
@Service
public class BidService {

    private final BidRepo bidRepo;
    private final BidMapper bidMapper;
    private final AuctionRepo auctionRepo;
    private final UserRepo userRepo;

    public void createBid(BidRequestDto dto){

        Auction auction = auctionRepo.findById(dto.auctionId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Auction not found of id: " + dto.auctionId()
                ));

        User user = userRepo.findById(dto.userId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User not found of id: " + dto.userId()
                ));

        BigDecimal currentAmount = bidRepo.findHighestBidByAuctionId(dto.auctionId())
                .map(Bid::getAmount)
                .orElse(auction.getStartingPrice());

        BigDecimal minReq = currentAmount.add(
                currentAmount.multiply(BigDecimal.valueOf(auction.getIncrease()).divide(BigDecimal.valueOf(100), 4, RoundingMode.HALF_UP ))
        );//currentAmount + (currentAmount * (10/100))

        if(dto.amount().compareTo(minReq) < 0){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Bid must be at least" + minReq + " (min increase: " + auction.getIncrease() + "%)"
            );
        }

        var bid = bidMapper.toBid(auction, user, dto);
        bidRepo.save(bid);
    }
}