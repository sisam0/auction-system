package com.auction.auction;

import com.auction.repository.AuctionRepo;
import com.auction.repository.BidRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AuctionService {

    public final AuctionRepo auctionRepo;
    public final AuctionMapper auctionMapper;
    private final BidRepo bidRepo;

    public void createAuction(AuctionRequestDto dto){
        var auction = auctionMapper.toAuction(dto);
        auctionRepo.save(auction);
    }

    public List<AuctionResponseDto> findAllAuction(){

        List<Auction> auctions = auctionRepo.findAll();

        List<Integer> auctionId = auctions.stream()
                .map(Auction::getAuctionId)
                .collect(Collectors.toList());

        Map<Integer, BigDecimal> maxFindMaxBid = bidRepo.findMaxBidAmountByAuctionId(auctionId)
                .stream()
                .collect(Collectors.toMap(
                        row -> (Integer) row[0],
                        row -> (BigDecimal) row[1]
                ));

        return auctions.stream()
                .map(auction -> {
                    BigDecimal currentAmt = maxFindMaxBid.getOrDefault(auction.getAuctionId(), auction.getStartingPrice());
                    return auctionMapper.toAuctionResponseDto(auction, currentAmt);
                })
                .collect(Collectors.toList());
    }

}
