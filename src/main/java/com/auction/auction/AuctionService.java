package com.auction.auction;

import com.auction.repository.AuctionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AuctionService {

    public final AuctionRepo auctionRepo;
    public final AuctionMapper auctionMapper;

    public void createAuction(AuctionRequestDto dto){
        var auction = auctionMapper.toAuction(dto);
        auctionRepo.save(auction);
    }

    public List<AuctionResponseDto> findAllAuction(){
        return auctionRepo.findAll()//gives list of auction from db
                .stream()
                .map(auctionMapper::toAuctionResponseDto)
                .collect(Collectors.toList());
    }

}
