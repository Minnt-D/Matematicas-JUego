// src/com/puzzlehacker/core/Game.java
package com.puzzlehacker.core;

import com.puzzlehacker.states.*;
import com.puzzlehacker.ui.TerminalUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener {
    public static final int WINDOW_WIDTH = 900;
    public static final int WINDOW_HEIGHT = 500;

    private StateManager stateManager;
    private TerminalUI terminal;
    private boolean running;
    private String currentLanguage = "es";
    private String currentTextColor = "GREEN";

    public Game() {
        setupWindow();
        setupTerminal();
        setupStateManager();
    }

    private void setupWindow() {
        setTitle("PuzzleHacker v1.0");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);
        setFocusable(true);

        // Fondo negro estilo terminal
        getContentPane().setBackground(Color.BLACK);
    }

    private void setupTerminal() {
        terminal = new TerminalUI();
        add(terminal);
    }

    private void setupStateManager() {
        stateManager = new StateManager(this, terminal);
        stateManager.setState(new SplashState(stateManager));
    }

    public void start() {
        running = true;
        setVisible(true);
        gameLoop();
    }

    private void gameLoop() {
        while (running) {
            update();
            render();
            try {
                Thread.sleep(16); // ~60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {
        if (stateManager.getCurrentState() != null) {
            stateManager.getCurrentState().update();
        }
    }

    private void render() {
        repaint();
    }

    public void stop() {
        running = false;
        dispose();
        System.exit(0);
    }

    // Getters y Setters
    public String getCurrentLanguage() {
        return currentLanguage;
    }

    public void setCurrentLanguage(String language) {
        this.currentLanguage = language;
    }

    public String getCurrentTextColor() {
        return currentTextColor;
    }

    public void setCurrentTextColor(String color) {
        this.currentTextColor = color;
        terminal.setTextColor(color);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (stateManager.getCurrentState() != null) {
            stateManager.getCurrentState().keyTyped(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (stateManager.getCurrentState() != null) {
            stateManager.getCurrentState().keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (stateManager.getCurrentState() != null) {
            stateManager.getCurrentState().keyReleased(e);
        }
    }
}