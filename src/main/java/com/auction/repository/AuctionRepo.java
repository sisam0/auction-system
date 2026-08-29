package com.auction.repository;

import com.auction.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepo extends JpaRepository<Auction, Integer> {
}
