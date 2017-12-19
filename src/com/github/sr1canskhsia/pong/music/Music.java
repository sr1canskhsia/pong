package com.github.sr1canskhsia.pong.music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Music {

    private Clip clip;
    private boolean playing;

    public Music() {
        try {
            clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(this.getClass().getResource("BGM.wav"));
            clip.open(ais);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            playing = true;
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        clip.stop();
        playing = false;
    }

    public void resume() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        playing = true;
    }

    public boolean isPlaying() {
        return playing;
    }

}