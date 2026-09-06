package com.auction.bid;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BidResponseDto(
        String sellerName,
        String userName,
        BigDecimal bidAmount,
        LocalDateTime bidTime
) {
}
