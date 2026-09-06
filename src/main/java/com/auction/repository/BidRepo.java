package com.auction.repository;

import com.auction.auction.Auction;
import com.auction.bid.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BidRepo extends JpaRepository<Bid, Integer> {
    //returns the first entity from the list which is displayed descending way from bidAmount
//    Optional<Bid> findFirstByAuction_AuctionIdOrderByBidAmountDesc(Integer auctionId);

    @Query("SELECT b FROM Bid b WHERE b.auction.auctionId = :auctionId ORDER BY b.amount DESC")
    Optional<Bid> findHighestBidByAuctionId(@Param("auctionId") Integer auctionId);

    @Query("SELECT b.auction.auctionId, MAX(b.amount) FROM Bid b WHERE b.auction.auctionId IN :auctionIds Group By b.auction.auctionId")
    List<Object[]> findMaxBidAmountByAuctionId(@Param("auctionIds") List<Integer> auctionIds);

    List<Bid> findByAuction_AuctionId(Integer auctionId);
}
