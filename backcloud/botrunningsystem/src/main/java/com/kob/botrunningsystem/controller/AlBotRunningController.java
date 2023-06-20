package com.kob.botrunningsystem.controller;


import com.kob.botrunningsystem.service.AlBotRunningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class AlBotRunningController {
    @Autowired
    private AlBotRunningService alBotRunningService;

    @PostMapping("/bot/al/add/")
    public String addBotAl(@RequestParam MultiValueMap<String, String> data) {
        Integer userId = Integer.parseInt(Objects.requireNonNull(data.getFirst("user_id")));
        String botCode = data.getFirst("bot_code");
        String input = data.getFirst("input");

        return alBotRunningService.addBotAl(userId, botCode, input);
    }
}
