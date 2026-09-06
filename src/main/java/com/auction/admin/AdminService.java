package com.auction.admin;

import com.auction.auction.Auction;
import com.auction.auction.AuctionMapper;
import com.auction.auction.AuctionResponseDto;
import com.auction.bid.Bid;
import com.auction.bid.BidMapper;
import com.auction.bid.BidResponseDto;
import com.auction.repository.AuctionRepo;
import com.auction.repository.BidRepo;
import com.auction.repository.UserRepo;
import com.auction.user.UserMapper;
import com.auction.user.UserResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AdminService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final AuctionRepo auctionRepo;
    private final AuctionMapper auctionMapper;
    private final BidRepo bidRepo;
    private final BidMapper bidMapper;

    public List<UserResponseDto> displayAllUser(){
        return userRepo.findAll()
                .stream()
                .map(userMapper::toUserResponseDto)
                .collect(Collectors.toList());
    }

    public List<AuctionResponseDto> viewAllAuctionByUser(Integer userId){

        List<Auction> auctions = auctionRepo.findAllAuctionByUserId(userId);

        List<Integer> auctionIds = auctions.stream()
                .map(Auction::getAuctionId)
                .collect(Collectors.toList());

        Map<Integer, BigDecimal> maxBids = bidRepo.findMaxBidAmountByAuctionId(auctionIds)
                .stream()
                .collect(Collectors.toMap(
                    row -> (Integer) row[0],
                    row -> (BigDecimal) row[1]
                ));

        return auctions.stream()
                .map(auction -> {
                    BigDecimal currentAmt = maxBids.getOrDefault(auction.getAuctionId(), auction.getStartingPrice());
                    return auctionMapper.toAuctionResponseDto(auction, currentAmt);
                })
                .collect(Collectors.toList());
    }

    public List<BidResponseDto> viewAllBidByAuction(Integer auctionId){
        List<Bid> bids = bidRepo.findByAuction_AuctionId(auctionId);

        return bids.stream()
                .map(bid -> {
                    String userName = bid.getUser().getUsername();
                    String sellerName = bid.getAuction().getSellerName();
                    return bidMapper.toBidResponseDto(bid, userName, sellerName);
                })
                .collect(Collectors.toList());
    }
}
