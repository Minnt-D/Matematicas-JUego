package com.puzzlehacker.core;

import com.puzzlehacker.states.*;
import javax.swing.*;
import java.awt.*;

public class Game extends JPanel implements Runnable {

    // Dimensiones de la ventana estilo terminal
    public static final int WIDTH = 700;
    public static final int HEIGHT = 500;

    private Thread thread;
    private boolean running;

    private StateManager stateManager;

    public Game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        requestFocus();

        // Fondo oscuro estilo hacker
        setBackground(Color.BLACK);

        // Inicializamos gestor de estados
        stateManager = new StateManager();

        // Estados del juego
        stateManager.addState(new SplashState(stateManager));
        stateManager.addState(new MenuState(stateManager));
        stateManager.addState(new PlayState(stateManager));
        stateManager.addState(new SettingsState(stateManager));
        stateManager.addState(new CreditsState(stateManager));

        // Estado inicial
        stateManager.setState("Splash");
    }

    public void start() {
        if (thread == null || !running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        // Loop a 60 FPS
        final double FPS = 60.0;
        final double nsPerFrame = 1_000_000_000.0 / FPS;

        long lastTime = System.nanoTime();
        double delta = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsPerFrame;
            lastTime = now;

            while (delta >= 1) {
                update();
                repaint();
                delta--;
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        stateManager.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Render con Graphics2D (mejor calidad y tipografía clara)
        Graphics2D g2d = (Graphics2D) g;
        stateManager.render(g2d);
    }

    // Manejo de entrada desde TerminalUI
    public void handleInput(String input) {
        if (stateManager.getCurrentState() instanceof PlayState playState) {
            playState.handleCommand(input);
        }
    }
}
