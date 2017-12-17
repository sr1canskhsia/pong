package com.github.sr1canskhsia.pong.screen;

import com.github.sr1canskhsia.pong.Pong;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class GameScreen extends Screen {

    public GameScreen(Pong pong) {
        super(pong);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.WHITE);
        g.setStroke(new BasicStroke(5f));
        g.drawLine(Pong.WIDTH / 2, 0, Pong.WIDTH / 2, Pong.HEIGHT);
        g.setStroke(new BasicStroke(2f));
        g.drawOval(Pong.WIDTH / 2 - 150, Pong.HEIGHT / 2 - 150, 300, 300);
        pong.getPaddle1().render(g);
        pong.getPaddle2().render(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                pong.getPaddleKeys().pressKey(e);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                pong.getPaddleKeys().releaseKey(e);
                break;
        }
    }
}