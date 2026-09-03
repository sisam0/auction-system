package com.auction.bid;

import java.math.BigDecimal;

public record BidRequestDto(
        BigDecimal amount,
        Integer auctionId,
        Integer userId
) {
}
