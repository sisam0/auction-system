package com.auction.auction;

import com.auction.bid.Bid;
import com.auction.watchlist.Watchlist;
import com.auction.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auctionId;

    private String title;

    private String description;

    private int increase;

    private String status;

    private BigDecimal startingPrice;

    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String sellerName;

    private BigDecimal currentPrice;

    //many auction can be created by only one user i.e one user can create many auction
    @ManyToOne
    @JoinColumn(
            name = "userId"
    )
    @JsonBackReference
    public User user;

    //many bids are made on one item.
    @OneToMany(
            mappedBy = "auction"
    )
    @JsonManagedReference
    public List<Bid> bid;

    //one auction can be in many watchlist.
    @OneToMany(
            mappedBy = "auction"
    )
    @JsonManagedReference
    public List<Watchlist> watchList;

    //before inserting into the db, we are initializing the value of startTime
    // as whatever it is right now
    @PrePersist
    protected void onCreate(){
        startTime = LocalDateTime.now();
    }

}
