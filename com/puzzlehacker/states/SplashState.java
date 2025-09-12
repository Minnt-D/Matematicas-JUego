package com.puzzlehacker.states;

import com.puzzlehacker.core.StateManager;
import com.puzzlehacker.ui.ProgressBarUI;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class SplashState extends GameState {

    private boolean loadingComplete;
    private int progress;
    private ProgressBarUI progressBar;

    private Timer loadingTimer;

    public SplashState(StateManager stateManager) {
        super(stateManager);
        this.progress = 0;
        this.loadingComplete = false;
        this.progressBar = new ProgressBarUI(500, 20); // ancho y alto de la barra
    }

    @Override
    public String getName() {
        return "Splash";
    }

    @Override
    public void enter() {
        progress = 0;
        loadingComplete = false;

        // Timer para simular carga animada
        loadingTimer = new Timer(50, e -> {
            progress += 2;
            if (progress >= 100) {
                progress = 100;
                loadingComplete = true;
                loadingTimer.stop();
            }
        });
        loadingTimer.start();

        // Escucha de teclas para pasar al menú cuando se complete la carga
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(event -> {
            if (loadingComplete && event.getID() == KeyEvent.KEY_PRESSED) {
                stateManager.setState("Menu");
                return true;
            }
            return false;
        });
    }

    @Override
    public void update() {
        // Nada especial, solo dejamos que el Timer controle el progreso
    }

    @Override
    public void render(Graphics2D g2d) {
        // Fondo negro estilo hacker
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 700, 500);

        // Título del juego
        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Monospaced", Font.BOLD, 36));
        g2d.drawString("PuzzleHacker", 200, 200);

        // Barra de progreso animada
        progressBar.render(g2d, 100, 250, progress);

        // Texto de indicación
        if (loadingComplete) {
            g2d.setFont(new Font("Monospaced", Font.PLAIN, 18));
            g2d.setColor(Color.WHITE);
            g2d.drawString("Presione cualquier tecla para comenzar", 150, 320);
        }
    }

    @Override
    public void handleInput(String input) {
        // No se maneja input de texto en Splash
    }
}
