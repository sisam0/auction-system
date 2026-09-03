package com.auction.auction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AuctionResponseDto(
        String sellerName,
        String title,
        String description,
        int increase,
        LocalDateTime startTime,
        LocalDateTime endTime,
        BigDecimal startingPrice
) {
}
