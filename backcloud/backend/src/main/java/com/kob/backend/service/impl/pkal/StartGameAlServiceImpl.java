package com.kob.backend.service.impl.pkal;

import com.kob.backend.consumer.WebSocketServer;
import com.kob.backend.service.pkal.StartGameAlService;
import org.springframework.stereotype.Service;

@Service
public class StartGameAlServiceImpl implements StartGameAlService {
    @Override
    public String startGameAl(Integer aId, Integer aBotId, Integer bId, Integer bBotId) {
        System.out.println("startGame" + aId + " " + bId);
        WebSocketServer.startGame(aId, aBotId, 1, 1);
        return "start game success";
    }
}
