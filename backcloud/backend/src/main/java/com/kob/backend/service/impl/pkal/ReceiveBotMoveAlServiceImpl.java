package com.kob.backend.service.impl.pkal;

import com.kob.backend.consumer.WebSocketServer;
import com.kob.backend.consumer.utils.Game;
import com.kob.backend.service.pkal.ReceiveBotMoveAlService;
import org.springframework.stereotype.Service;

@Service
public class ReceiveBotMoveAlServiceImpl implements ReceiveBotMoveAlService {
    @Override
    public String receiveBotMoveAl(Integer userId, Integer direction) {
        System.out.println("receive bot move" + userId + " " + direction);

        if (WebSocketServer.users.get(userId) != null) {
            Game game = WebSocketServer.users.get(userId).game;

            if (game != null) {
                if (game.getPlayerA().getId().equals(userId)) {// 人工
                    game.setNextStepA(direction);
                } else if (game.getPlayerB().getId().equals(userId)) {
                    game.setNextStepB(direction);
                }
            }

        }

        return "receive bot move success";
    }
}
