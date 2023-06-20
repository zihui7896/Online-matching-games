package com.kob.backend.service.impl.pkal;

import com.kob.backend.consumer.WebSocketServerAl;
import com.kob.backend.service.pkal.AlStartGameService;
import org.springframework.stereotype.Service;

@Service
public class AlStartGameServiceImpl implements AlStartGameService {
    @Override
    public String startGameAl(Integer aId, Integer aBotId, Integer bId, Integer bBotId) {
        WebSocketServerAl.startGame(aId, aBotId, bId, bBotId);
        System.out.println("startGame" + aId + " " + bId + " al");
        return "start game success";
    }
}
