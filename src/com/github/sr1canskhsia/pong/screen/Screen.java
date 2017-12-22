package com.github.sr1canskhsia.pong.screen;

import com.github.sr1canskhsia.pong.Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class Screen extends KeyAdapter {

    Pong pong;

    public Screen(Pong pong) {
        this.pong = pong;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Pong.WIDTH, Pong.HEIGHT);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.BOLD, 28));
        g.drawString("BGM: " + (pong.getMusic().isPlaying() ? "On" : "Off"), 40, 52);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                pong.getTimer().stop();
                pong.setScreen(new TitleScreen(pong));
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_M:
                if (pong.getMusic().isPlaying()) {
                    pong.getMusic().pause();
                    pong.repaint();
                } else {
                    pong.getMusic().resume();
                    pong.repaint();
                }
        }
    }
}
