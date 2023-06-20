package com.kob.backend.service.impl.pk;

import com.kob.backend.consumer.WebSocketServer;
import com.kob.backend.consumer.WebSocketServerAl;
import com.kob.backend.consumer.utils.Game;
import com.kob.backend.consumer.utils.GameAl;
import com.kob.backend.service.pk.ReceiveBotMoveService;
import org.springframework.stereotype.Service;

@Service
public class ReceiveBotMoveServiceImpl implements ReceiveBotMoveService {
    @Override
    public String receiveBotMove(Integer userId, Integer direction) {
        System.out.println(userId + " botmove" + " " + direction);
        System.out.println(WebSocketServer.users.get(userId) != null);
        System.out.println(WebSocketServerAl.users.get(userId) != null);
        if (WebSocketServer.users.get(userId) != null) {
            Game game = WebSocketServer.users.get(userId).game;

            if (game != null) {
                if (game.getPlayerA().getId().equals(userId)) {// 人工
                    game.setNextStepA(direction);
                } else if (game.getPlayerB().getId().equals(userId)) {
                    game.setNextStepB(direction);
                }
            }
            System.out.println("receive bot move" + userId + " " + direction);
        }

        if (WebSocketServerAl.users.get(userId) != null) {
            GameAl game = WebSocketServerAl.users.get(userId).game;
            if (game != null) {
                if (game.getPlayerA().getId().equals(userId)) {// 人工
                    game.setNextStepA(direction);
                } else if (game.getPlayerB().getId().equals(userId)) {
                    game.setNextStepB(direction);
                }
            }
            System.out.println("receive bot move  al" + userId + " " + direction);
        }
        return "receive bot move success";
    }
}
