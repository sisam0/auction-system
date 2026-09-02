package com.auction.repository;

import com.auction.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuctionRepo extends JpaRepository<Auction, Integer> {
}
