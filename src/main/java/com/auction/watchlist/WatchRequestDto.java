package com.auction.watchlist;

public record WatchRequestDto(
        Integer auctionId,
        Integer userId
) {
}
