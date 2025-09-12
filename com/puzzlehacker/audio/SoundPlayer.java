package com.puzzlehacker.audio;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * SoundPlayer - Maneja la reproducción de efectos de sonido y música.
 * Compatible con archivos WAV. Ideal para sonidos de teclado, alertas o música de fondo.
 */
public class SoundPlayer {

    private Clip clip;

    /**
     * Carga un archivo de sonido desde la ruta indicada.
     * @param filePath ruta del archivo .wav
     */
    public void loadSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            if (!soundFile.exists()) {
                System.err.println("No se encontró el archivo de sonido: " + filePath);
                return;
            }

            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reproduce el sonido cargado.
     */
    public void play() {
        if (clip != null) {
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.setFramePosition(0); // Reinicia desde el inicio
            clip.start();
        }
    }

    /**
     * Reproduce el sonido en loop infinito (ideal para música de fondo).
     */
    public void loop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    /**
     * Detiene la reproducción del sonido.
     */
    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    /**
     * Libera los recursos del sonido.
     */
    public void close() {
        if (clip != null) {
            clip.close();
        }
    }
}
