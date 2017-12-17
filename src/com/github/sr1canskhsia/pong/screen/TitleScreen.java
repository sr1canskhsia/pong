package com.github.sr1canskhsia.pong.screen;

import com.github.sr1canskhsia.pong.Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class TitleScreen extends Screen {

    public TitleScreen(Pong pong) {
        super(pong);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 60));
        g.drawString("PONG", Pong.WIDTH / 2 - 75, 70);

        g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 30));
        g.drawString("1 - Single Player Mode", 120, 230);
        g.drawString("2 - Two Player Mode", 120, 280);
        g.drawString("M - Toggle Background Music", 120, 330); // To do
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_1:
                pong.setGameMode(1);
                pong.setScreen(new GameScreen(pong));
                pong.init();
                break;
            case KeyEvent.VK_2:
                pong.setGameMode(2);
                pong.setScreen(new GameScreen(pong));
                pong.init();
                break;
        }
    }
}
