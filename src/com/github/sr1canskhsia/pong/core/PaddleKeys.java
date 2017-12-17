package com.github.sr1canskhsia.pong.core;

import java.awt.event.KeyEvent;

public class PaddleKeys {

    private boolean w = false;
    private boolean s = false;
    private boolean up = false;
    private boolean down = false;

    public boolean pressedW() {
        return w;
    }

    public boolean pressedS() {
        return s;
    }

    public boolean pressedUp() {
        return up;
    }

    public boolean pressedDown() {
        return down;
    }

    public void pressKey(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                w = true;
                break;
            case KeyEvent.VK_S:
                s = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
        }
    }

    public void releaseKey(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                w = false;
                break;
            case KeyEvent.VK_S:
                s = false;
                break;
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
        }
    }

}
