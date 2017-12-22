package com.github.sr1canskhsia.pong.screen;

import com.github.sr1canskhsia.pong.Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class ResultScreen extends Screen {

    public ResultScreen(Pong pong) {
        super(pong);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.BOLD, 60));
        g.drawString("PONG", Pong.WIDTH / 2 - 75, 70);

        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.drawString(getResult(), Pong.WIDTH / 2 - (pong.getGameMode() == 1 ? 174 : 200), 170);

        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.drawString("Space - Play Again", 190, 250);
        g.drawString("ESC - Title Screen", 190, 300);
    }

    private String getResult() {
        String result;
        if (pong.getGameMode() == 1) {
            if (pong.getScoreBoard().getLastScored() == 1) {
                result = "The AI Wins!";
            } else {
                result = "Player Wins!";
            }
        } else {
            if (pong.getScoreBoard().getLastScored() == 1) {
                result = "Player 1 Wins!";
            } else {
                result = "Player 2 Wins!";
            }
        }
        return result;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        switch (e.getKeyCode()) {
            case (KeyEvent.VK_SPACE):
                pong.setScreen(new GameScreen(pong));
                pong.init();
                break;
        }
    }
}
