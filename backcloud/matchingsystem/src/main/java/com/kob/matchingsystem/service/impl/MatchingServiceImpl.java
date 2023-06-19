package com.kob.matchingsystem.service.impl;

import com.kob.matchingsystem.service.MatchingService;
import com.kob.matchingsystem.service.impl.utils.MatchingPool;
import org.springframework.stereotype.Service;


@Service
public class MatchingServiceImpl implements MatchingService {

    public final static MatchingPool matchingPool = new MatchingPool();
    @Override
    public String addPlayer(Integer userId, Integer rating, Integer botId) {

        matchingPool.addPlayer(userId, rating, botId);
        System.out.println("success add player" + userId + " " + botId);
        return "success add player";
    }

    @Override
    public String removePlayer(Integer userId) {
        matchingPool.removePlayer(userId);
        System.out.println("success remove player" + userId);
        return "success remove player";
    }
}
