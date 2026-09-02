package com.auction.watchlist;

import com.auction.auction.Auction;
import com.auction.repository.AuctionRepo;
import com.auction.repository.UserRepo;
import com.auction.repository.WatchRepo;
import com.auction.user.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class WatchMapper {

    public final AuctionRepo auctionRepo;
    public final UserRepo userRepo;

    public Watchlist toWatchlist(WatchRequestDto dto){

        User user = userRepo.findById(dto.userId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "User doesnt exist with id: " + dto.userId()
                ));

        Auction auction = auctionRepo.findById(dto.auctionId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Auction doesnt exist with id: " + dto.auctionId()
                ));

        return Watchlist.builder()
                .user(user)
                .auction(auction)
                .build();
    }

}
