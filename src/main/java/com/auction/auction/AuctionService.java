package com.auction.auction;

import com.auction.repository.AuctionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuctionService {

    public final AuctionRepo auctionRepo;
    public final AuctionMapper auctionMapper;

    public void createAuction(AuctionRequestDto dto){
        var auction = auctionMapper.toAuction(dto);
        auctionRepo.save(auction);
    }
}
