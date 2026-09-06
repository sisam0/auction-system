package com.auction.repository;

import com.auction.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuctionRepo extends JpaRepository<Auction, Integer> {
    @Query("Select a from Auction a where a.user.userId = :userId")
    List<Auction> findAllAuctionByUserId(@Param("userId") Integer userId);


}
