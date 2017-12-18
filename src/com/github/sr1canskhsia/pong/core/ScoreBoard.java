package com.github.sr1canskhsia.pong.core;

import com.github.sr1canskhsia.pong.Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class ScoreBoard {

    private int score1 = 0;
    private int score2 = 0;
    private int lastScored = 0;

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public void incrementScore1() {
        score1++;
        lastScored = 1;
    }

    public void incrementScore2() {
        score2++;
        lastScored = 2;
    }

    public int getLastScored() {
        return lastScored;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 55));
        g.drawString(String.valueOf(score1), Pong.WIDTH / 2 - 100, 50);
        g.drawString(String.valueOf(score2), Pong.WIDTH / 2 + 70, 50);
    }
}
