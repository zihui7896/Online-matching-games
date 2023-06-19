package com.kob.backend.service.impl.pk;

import com.kob.backend.consumer.WebSocketServerAl;
import com.kob.backend.service.pk.StartGameService;
import org.springframework.stereotype.Service;

@Service
public class StartGameServiceImpl implements StartGameService {
    @Override
    public String startGame(Integer aId, Integer aBotId, Integer bId, Integer bBotId) {
        System.out.println("startGame" + aId + " " + bId);
        WebSocketServerAl.startGameal(aId, aBotId, 1, 1);
        return "start game success";
    }
}
