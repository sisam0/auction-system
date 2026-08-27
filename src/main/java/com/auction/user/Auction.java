package com.auction.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer auction_id;

    private String title;

    private String description;

    private int increase;

    private String status;

    private int startingPrice;

    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime startTime;

    private LocalDateTime endTime;

    //many auction can be created by only one user i.e one user can create many auction
    @ManyToOne
    @JoinColumn(
            name = "user_id"
    )
    public User user;

    //many bids are made on one item.
    @OneToMany(
            mappedBy = "auction"
    )
    public List<Bid> bid;

    //one auction can be in many watchlist.
    @OneToMany(
            mappedBy = "auction"
    )
    public List<Watchlist> watchList;

    //before inserting into the db, we are initializing the value of startTime
    // as whatever it is right now
    @PrePersist
    protected void onCreate(){
        startTime = LocalDateTime.now();
    }

}
