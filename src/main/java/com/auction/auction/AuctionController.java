package com.auction.auction;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuctionController {

    public final AuctionService auctionService;

    @PostMapping("/auction")
    public void createAuction(
            @RequestBody AuctionRequestDto dto
    ){
        auctionService.createAuction(dto);
    }
}
