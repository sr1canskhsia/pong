package com.github.sr1canskhsia.pong;

import com.github.sr1canskhsia.pong.core.*;
import com.github.sr1canskhsia.pong.music.*;
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
    private final int TICK = 10;

    private Screen screen;
    private Paddle paddle1;
    private Paddle paddle2;
    private PaddleKeys paddleKeys;
    private ScoreBoard scoreBoard;
    private Ball ball;
    private AI ai;
    private Timer timer;
    private int gameMode;

    private Music music;

    public Pong() {
        music = new Music();

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

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public Ball getBall() {
        return ball;
    }

    public Timer getTimer() {
        return timer;
    }

    public Music getMusic() {
        return music;
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

    public int getGameMode() {
        return gameMode;
    }

    public void setGameMode(int gameMode) {
        this.gameMode = gameMode;
    }

    public void init() {
        paddle1 = new Paddle("LEFT");
        paddle2 = new Paddle("RIGHT");
        paddleKeys = new PaddleKeys();
        scoreBoard = new ScoreBoard();
        ball = new Ball(scoreBoard);

        if (gameMode == 1) {
            ai = new AI(paddle1, ball);
        }

        timer = new Timer(TICK, update);
        timer.start();
    }

    private ActionListener update = e -> {
        movePaddle();
        updateBall();
        checkScore();
        repaint();
    };

    private void movePaddle() {
        if (gameMode == 1) {
            ai.movePaddle();
        } else {
            if (paddleKeys.pressedW()) {
                paddle1.moveUp();
            }
            if (paddleKeys.pressedS()) {
                paddle1.moveDown();
            }
        }

        if (paddleKeys.pressedUp()) {
            paddle2.moveUp();
        }
        if (paddleKeys.pressedDown()) {
            paddle2.moveDown();
        }
    }

    private void updateBall() {
        if (ball.checkBorderCollision()) {
            ball.bounceBorder();
        }
        if (ball.checkPaddleCollision(paddle1)) {
            ball.bouncePaddle(paddle1);
            paddle1.decreaseHeight();
            paddle2.decreaseHeight();
        }
        if (ball.checkPaddleCollision(paddle2)) {
            ball.bouncePaddle(paddle2);
            paddle1.decreaseHeight();
            paddle2.decreaseHeight();
        }
        ball.move();
    }

    private void checkScore() {
        if (ball.checkPaddle1Scored() || ball.checkPaddle2Scored()) {
            if (ball.checkPaddle1Scored()) {
                scoreBoard.incrementScore1();
            } else {
                scoreBoard.incrementScore2();
            }

            if (scoreBoard.getScore1() == 10 || scoreBoard.getScore2() == 10) {
                timer.stop();
                this.setScreen(new ResultScreen(this));
            } else {
                paddle1.resetHeight();
                paddle2.resetHeight();
                ball.spawn();
            }
        }
    }

    public static void main(String[] args) {
        new Pong();
    }
}
