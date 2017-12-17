package com.github.sr1canskhsia.pong;

import com.github.sr1canskhsia.pong.core.*;
import com.github.sr1canskhsia.pong.screen.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;

public class Pong extends JPanel {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;
    private final int TICK = 5;

    private Screen screen;
    private Paddle paddle1;
    private Paddle paddle2;
    private PaddleKeys paddleKeys;
    private int gameMode;

    public Pong() {
        JFrame frame = new JFrame();
        frame.setTitle("Pong");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.setFocusable(true);
        this.setScreen(new TitleScreen(this));
    }

    public Paddle getPaddle1() {
        return paddle1;
    }

    public Paddle getPaddle2() {
        return paddle2;
    }

    public PaddleKeys getPaddleKeys() {
        return paddleKeys;
    }

    public void setScreen(Screen screen) {
        this.removeKeyListener(this.screen);
        this.screen = screen;
        this.addKeyListener(screen);
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        screen.render((Graphics2D) g);
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public void init() {
        paddle1 = new Paddle("LEFT");
        paddle2 = new Paddle("RIGHT");
        paddleKeys = new PaddleKeys();

        Timer t = new Timer(TICK, update);
        t.start();
    }

    private ActionListener update = e -> {
        movePaddle();
        repaint();
    };

    private void movePaddle() {
        if (gameMode == 1) {
            // AI to be implemented
        } else {
            if (paddleKeys.pressedW())
                paddle1.moveUp();
            if (paddleKeys.pressedS())
                paddle1.moveDown();
        }

        if (paddleKeys.pressedUp())
            paddle2.moveUp();
        if (paddleKeys.pressedDown())
            paddle2.moveDown();
    }

    public static void main(String[] args) {
        new Pong();
    }
}
