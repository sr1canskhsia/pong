package com.github.sr1canskhsia.pong.core;

import com.github.sr1canskhsia.pong.Pong;

import java.awt.Color;
import java.awt.Graphics2D;

public class Paddle {

    private final int SPEED = 5;
    private final int WIDTH = 15;
    private final int DEFAULT_HEIGHT = 120;
    private int height = DEFAULT_HEIGHT; // Paddle height shall be decreasing over time.
    private int x;
    private int y;

    public Paddle(String position) {
        switch (position) {
            case "LEFT":
                x = 8;
                break;
            case "RIGHT":
                x = Pong.WIDTH - WIDTH - 8;
                break;
        }

        y = Pong.HEIGHT / 2 - height / 2;
    }

    public void moveUp() {
        if (!checkTopBorder())
            y -= SPEED;
    }

    public void moveDown() {
        if (!checkBottomBorder())
            y += SPEED;
    }

    private boolean checkTopBorder() {
        return y <= 0;
    }

    private boolean checkBottomBorder() {
        return y >= Pong.HEIGHT - height;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, WIDTH, height);
    }

}
