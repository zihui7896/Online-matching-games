package com.kob.backend.controller.pkal;

import com.kob.backend.service.pk.StartGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class StartGameAlController {

    @Autowired
    private StartGameService startGameService;

    @PostMapping("/kob/pk/al/start/game/")
    public String startGameal(@RequestParam MultiValueMap<String, String> data) {
        Integer aId = Integer.parseInt(Objects.requireNonNull(data.getFirst("a_id")));
        Integer aBotId = Integer.parseInt(Objects.requireNonNull(data.getFirst("a_bot_id")));
        Integer bId = 1;
        Integer bBotId = 1;
        return startGameService.startGame(aId, aBotId, bId, bBotId);
    }
}
