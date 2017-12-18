package com.github.sr1canskhsia.pong.core;

import com.github.sr1canskhsia.pong.Pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball {

    private final int DIAMETER = 20;
    private final int VELOCITY = 10;
    private double velocityX;
    private double velocityY;
    private double x;
    private double y;

    private ScoreBoard scoreBoard;
    private Random random = new Random();

    public Ball(ScoreBoard scoreboard) {
        this.scoreBoard = scoreboard;
        spawn();
    }

    public void spawn() {
        x = Pong.WIDTH / 2 - DIAMETER / 2;
        y = Pong.HEIGHT / 2 - DIAMETER / 2;

        switch (scoreBoard.getLastScored()) {
            case 0:
                velocityX = random.nextBoolean() ? 6 : -6;
                break;
            case 1:
                velocityX = -6;
                break;
            case 2:
                velocityX = 6;
                break;
        }

        velocityY = random.nextBoolean() ? 8 : -8;
    }

    public int getDiameter() {
        return DIAMETER;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getY() {
        return y;
    }

    public void move() {
        x += velocityX;
        y += velocityY;
    }

    public boolean checkBorderCollision() {
        return y <= 0 || y + DIAMETER >= Pong.HEIGHT;
    }

    public boolean checkPaddleCollision(Paddle paddle) {
        return x <= paddle.getX() + paddle.getWidth() &&
                x + DIAMETER >= paddle.getX() &&
                y <= paddle.getY() + paddle.getHeight() &&
                y + DIAMETER >= paddle.getY();
    }

    public void bounceBorder() {
        velocityY *= -1;
        y += velocityY;
    }

    /*
     * Determine bounce angle using trigonometry (https://gamedev.stackexchange.com/a/4255).
     */
    public void bouncePaddle(Paddle paddle) {
        double relativeY = (y + DIAMETER / 2) - (paddle.getY() + paddle.getHeight() / 2);
        double normalizedRelativeY = relativeY / (paddle.getHeight() / 2);
        double bounceAngle = normalizedRelativeY * (Math.PI / 4);
        velocityX = VELOCITY * Math.cos(bounceAngle) * (paddle.getX() == 8 ? 1 : -1); // Left or right paddle.
        velocityY = VELOCITY * Math.sin(bounceAngle);
        x += velocityX;
    }

    public boolean checkPaddle1Scored() {
        return x >= Pong.WIDTH;
    }

    public boolean checkPaddle2Scored() {
        return x + DIAMETER <= 0;
    }

    public void render(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillOval((int) x, (int) y, DIAMETER, DIAMETER);
    }

}
