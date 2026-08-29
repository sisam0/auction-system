package com.auction;

import com.auction.auction.Auction;
import com.auction.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bid_id;

    private  int amount;

    private LocalDateTime bidTime;

     //many bid belongs to one item
    @ManyToOne
    @JoinColumn(
            name = "auction_id"
    )
    public Auction auction;

    //many bid is placed by one user
    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    public User user;

}
