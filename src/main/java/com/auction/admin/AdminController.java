package com.auction.admin;


import com.auction.auction.AuctionResponseDto;
import com.auction.bid.BidResponseDto;
import com.auction.user.UserResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/view-user")
    public List<UserResponseDto> displayAllUser(){
        return adminService.displayAllUser();
    }

    @GetMapping("/auctions-by-user/{userId}")
    public List<AuctionResponseDto> viewAllAuctionByUser(
            @PathVariable Integer userId
    ){
        return adminService.viewAllAuctionByUser(userId);
    }

    @GetMapping("/bids-by-auction/{auctionId}")
    public List<BidResponseDto> viewBidsByAuction(
            @PathVariable Integer auctionId
    ){
        return adminService.viewAllBidByAuction(auctionId);
    }

}
