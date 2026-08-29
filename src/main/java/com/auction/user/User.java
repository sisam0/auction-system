package com.auction.user;

import com.auction.auction.Auction;
import com.auction.Bid;
import com.auction.Watchlist;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

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

    public User(String username, String email, String address) {
        this.username = username;
        this.email = email;
        this.address = address;
    }
}