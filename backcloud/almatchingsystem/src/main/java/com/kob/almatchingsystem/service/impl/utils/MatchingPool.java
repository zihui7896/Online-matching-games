package com.kob.almatchingsystem.service.impl.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class MatchingPool extends Thread{

    private static List<Player> players = new ArrayList<>();
    private final ReentrantLock lock = new ReentrantLock();

    private static RestTemplate restTemplate;
    private final static String startGameUrl = "http://127.0.0.1:3000/pk/start/game/";
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        MatchingPool.restTemplate = restTemplate;
    }
    public void addPlayer(Integer userId, Integer botId) {
        lock.lock();
        try {
            players.add(new Player(userId, botId));
        } finally {
            lock.unlock();
        }
    }
//    private void increaseWaitingTime() {
//        for (Player player : players) {
//            player.setWaitingTime(player.getWaitingTime() + 1);
//        }
//    }
//    private boolean checkMatches(Player a, Player b) {
//        int ratingDelta = Math.abs(a.getRating() - b.getRating());
//        int waitingTime = Math.min(a.getWaitingTime(), b.getWaitingTime());
//        return ratingDelta <= waitingTime * 10;
//    }
    private void sendResult(Player a, Player b) {
        System.out.println("send result " + a + " " + b);
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("a_id", a.getUserId().toString());
        data.add("a_bot_id", a.getBotId().toString());
        data.add("b_id", b.getUserId().toString());
        data.add("b_bot_id", b.getBotId().toString());
        restTemplate.postForObject(startGameUrl, data, String.class);
    }
    private void matchPlayers() {

        boolean[] used = new boolean[players.size()];
        for (int i = 0; i < players.size(); i ++) {
            used[i] = true;
            Player a = players.get(i);
            Player b = new Player(1, 1);
            sendResult(a, b);
        }

        List<Player> newPlayers = new ArrayList<>();
        for (int i = 0; i < players.size(); i ++) {
            if (!used[i]) {
                newPlayers.add(players.get(i));
            }
        }
        players = newPlayers;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                lock.lock();
                try {
                    matchPlayers();
                } finally {
                    lock.unlock();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
