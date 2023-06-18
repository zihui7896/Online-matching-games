package com.kob.backend.consumer.utils;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private Integer id;
    private Integer botId; // -1 是本人上场 else bot
    private String botCode;
    private Integer sx;
    private Integer sy;
    private List<Integer> steps;


    private boolean check_tail_increasing(int step) {
        if (step <= 10) return true;
        if (step % 3 == 1) return true;
        return false;
    }

    public List<Cell> getCells() {
        List<Cell> res = new ArrayList<>();

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        int x = sx, y = sy;
        int step = 0;
        res.add(new Cell(x, y));

        for (int d : steps) {
            x += dx[d];
            y += dy[d];
            res.add(new Cell(x, y));
            if (!check_tail_increasing(++step)) {
                res.remove(0);
            }
        }
        return res;
    }

    public String getStepsString() {
        StringBuilder res = new StringBuilder();

        for (int d : steps) {
            res.append(d);
        }
        return res.toString();
    }
}
