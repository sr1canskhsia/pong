package com.github.sr1canskhsia.pong.core;

public class AI {

    private Paddle paddle;
    private Ball ball;

    public AI(Paddle paddle, Ball ball) {
        this.paddle = paddle;
        this.ball = ball;
    }

    public void movePaddle() {
        if (ball.getVelocityX() < 0) {
            if (ball.getY() < paddle.getY() - 15) {
                paddle.moveUp();
            } else if (ball.getY() + ball.getDiameter() > paddle.getY() + paddle.getHeight() + 15) {
                paddle.moveDown();
            }
        }
    }
}
