package com.auction.auction;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDateTime;

public record AuctionRequestDto(
        Integer userId,
        String title,
        String description,
        Integer increase,
        String status,
        Integer startingPrice,
        LocalDateTime endTime
) {
}
