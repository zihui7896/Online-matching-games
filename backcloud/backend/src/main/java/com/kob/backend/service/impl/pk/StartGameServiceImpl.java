package com.kob.backend.service.impl.pk;

import com.kob.backend.consumer.WebSocketServer;
import com.kob.backend.consumer.WebSocketServerAl;
import com.kob.backend.service.pk.StartGameService;
import org.springframework.stereotype.Service;

import java.util.InvalidPropertiesFormatException;

@Service
public class StartGameServiceImpl implements StartGameService {
    @Override
    public String startGame(Integer aId, Integer aBotId, Integer bId, Integer bBotId) {
        if (aId == 1 || bId == 1) {
            WebSocketServerAl.startGame(aId, aBotId, bId, bBotId);
            System.out.println("startGame Al" + aId + " " + bId);
        } else {
            WebSocketServer.startGame(aId, aBotId, bId, bBotId);
            System.out.println("startGame" + aId + " " + bId);
        }


        return "start game success";
    }
}
