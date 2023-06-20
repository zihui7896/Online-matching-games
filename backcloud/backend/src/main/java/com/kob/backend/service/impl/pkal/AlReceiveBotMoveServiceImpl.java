package com.kob.backend.service.impl.pkal;

import com.kob.backend.consumer.WebSocketServerAl;
import com.kob.backend.consumer.utils.Game;

import com.kob.backend.service.pkal.AlReceiveBotMoveService;
import org.springframework.stereotype.Service;

@Service
public class AlReceiveBotMoveServiceImpl implements AlReceiveBotMoveService {
    @Override
    public String receiveBotMoveAl(Integer userId, Integer direction) {
        System.out.println("receive bot move + al " + userId + " " + direction);

        if (WebSocketServerAl.users.get(userId) != null) {
            Game game = WebSocketServerAl.users.get(userId).game;

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
