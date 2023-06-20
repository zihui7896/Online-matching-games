package com.kob.backend.controller.pkal;

import com.kob.backend.service.pkal.AlReceiveBotMoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AlReceiveBotMoveController {
    @Autowired
    private AlReceiveBotMoveService alReceiveBotMoveService;

    @PostMapping("/pk/al/receive/bot/move/")
    public String receiveBotMoveAl(@RequestParam MultiValueMap<String, String> data) {
        Integer userId = Integer.parseInt(Objects.requireNonNull(data.getFirst("user_id")));
        Integer direction = Integer.parseInt(Objects.requireNonNull(data.getFirst("direction")));
        return alReceiveBotMoveService.receiveBotMoveAl(userId, direction);
    }
}
