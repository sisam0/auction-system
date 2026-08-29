package com.auction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto increments the id PK
    private Integer admin_id;

    private String name;

    private String email;

    private String password;


}
