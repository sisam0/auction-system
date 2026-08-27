package com.auction.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "users"
)
public class User {

    @Id
    @GeneratedValue
    private Integer user_id;

    private String username;

    @Column(
            unique = true
    )
    private String email;

    private String password;

    private Integer phone;

    private String address;

    //one user creates many auction created
    @OneToMany(
            mappedBy = "user"
    )
    public List<Auction> auction;

    //one user places multiple bids
    @OneToMany(
            mappedBy = "user"
    )
    public List<Bid> bid;

    //one user has many watchlist
    @OneToMany(
            mappedBy = "user"
    )
    public List<Watchlist> w_list;
}