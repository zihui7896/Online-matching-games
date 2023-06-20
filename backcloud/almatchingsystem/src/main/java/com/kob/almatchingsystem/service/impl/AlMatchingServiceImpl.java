package com.kob.almatchingsystem.service.impl;

import com.kob.almatchingsystem.service.AlMatchingService;
import com.kob.almatchingsystem.service.impl.utils.MatchingPool;
import org.springframework.stereotype.Service;


@Service
public class AlMatchingServiceImpl implements AlMatchingService {

    public final static MatchingPool matchingPool = new MatchingPool();
    @Override
    public String addPlayer(Integer userId, Integer botId) {
        matchingPool.addPlayer(userId, botId);
        System.out.println("success add player " + userId + " " + botId + "almatching");
        return "success add player";
    }

}
