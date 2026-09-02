package com.auction.watchlist;

import com.auction.auction.Auction;
import com.auction.user.User;
import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer watchlist_id;

    //one user can have multiple auction in watch list
    @ManyToOne
    @JoinColumn(
            name = "user_id" //this will be the column in the db which has the FK reference to user table
    )
    public User user;

    //one record in "watchList" can be tied to only one auction instance
    @ManyToOne
    @JoinColumn(
            name = "auction_id"
    )
    public Auction auction;


}
