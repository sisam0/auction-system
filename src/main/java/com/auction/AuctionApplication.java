package com.auction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class AuctionApplication {

    static {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kathmandu"));
    }
	public static void main(String[] args) {
		SpringApplication.run(AuctionApplication.class, args);
	}

}
