package com.github.sr1canskhsia.pong.screen;

import com.github.sr1canskhsia.pong.Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class HelpScreen extends Screen {

    public HelpScreen(Pong pong) {
        super(pong);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 60));
        g.drawString("PONG", Pong.WIDTH / 2 - 75, 70);

        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        g.drawString("Left Paddle - W & S (2nd Player)", 65, 180);
        g.drawString("Right Paddle - Up & Down Arrows", 70, 230);
        g.drawString("Space - Pause Game", 190, 280);
        g.drawString("ESC - Back To Title", 182, 330);

        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));
        g.drawString("*PRESS SPACE TO START*", 55, 430);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_SPACE):
                pong.setScreen(new GameScreen(pong));
                pong.init();
                break;
            case (KeyEvent.VK_ESCAPE):
                pong.setScreen(new TitleScreen(pong));
                break;
        }
    }
}
