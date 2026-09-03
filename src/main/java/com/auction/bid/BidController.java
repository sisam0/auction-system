package com.auction.bid;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class BidController {

    public final BidService bidService;

    @PostMapping("/create-bid")
    public void createBid(
            @RequestBody BidRequestDto dto
    ){
        bidService.createBid(dto);
    }

}
