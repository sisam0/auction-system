package com.auction.watchlist;

import com.auction.repository.WatchRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WatchService {

    public final WatchRepo watchRepo;
    public final WatchMapper watchMapper;

    public void createWatchlist(WatchRequestDto dto){
        var wList = watchMapper.toWatchlist(dto);
        watchRepo.save(wList);
    }
}
