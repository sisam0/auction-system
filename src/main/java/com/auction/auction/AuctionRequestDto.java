package com.auction.auction;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record AuctionRequestDto(
        Integer userId,
        String sellerName,
        String title,
        String description,
        Integer increase,
        String status,
        BigDecimal startingPrice,
        LocalDateTime endTime
) {
}
