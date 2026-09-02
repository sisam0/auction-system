package com.auction.repository;

import com.auction.watchlist.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WatchRepo extends JpaRepository<Watchlist, Integer> {

    Optional<Watchlist> findByAuction_AuctionIdAndUser_UserId(Integer auctionId, Integer userId);
}
