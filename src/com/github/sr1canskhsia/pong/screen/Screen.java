package com.github.sr1canskhsia.pong.screen;

import com.github.sr1canskhsia.pong.Pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;

public abstract class Screen extends KeyAdapter {

    Pong pong;

    public Screen(Pong pong) {
        this.pong = pong;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

}
