package com.auction.bid;

import com.auction.auction.Auction;
import com.auction.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid_id;

    private BigDecimal amount;

    private LocalDateTime bidTime;

     //many bid belongs to one item
    @ManyToOne
    @JoinColumn(
            name = "auction_id"
    )
    @JsonBackReference
    public Auction auction;

    //many bid is placed by one user
    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    @JsonBackReference
    public User user;

    @PrePersist
    protected void onCreate(){ bidTime = LocalDateTime.now(); }

}
