package com.auction.watchlist;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class WatchController {

    public final WatchService watchService;

    @PostMapping("/watchlist")
    public void addToWatchlist(
            @RequestBody WatchRequestDto dto
    ){
        watchService.createWatchlist(dto);
        
    }
}
