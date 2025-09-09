// src/com/puzzlehacker/states/SplashState.java
package com.puzzlehacker.states;

import com.puzzlehacker.core.GameState;
import com.puzzlehacker.core.StateManager;
import com.puzzlehacker.ui.ProgressBarUI;

import java.awt.event.KeyEvent;

public class SplashState extends GameState {
    private ProgressBarUI progressBar;
    private boolean loadingComplete = false;
    private boolean keyPressed = false;
    private long startTime;

    public SplashState(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public void enter() {
        startTime = System.currentTimeMillis();
        progressBar = new ProgressBarUI();

        stateManager.getTerminal().clearScreen();
        showTitle();

        // Simular carga de archivos
        new Thread(() -> {
            try {
                String[] files = {
                        "kernel32.dll", "user32.dll", "ntdll.dll",
                        "advapi32.dll", "shell32.dll", "msvcrt.dll",
                        "crypto_engine.sys", "network_stack.dll",
                        "gui_framework.jar", "math_processor.bin",
                        "terminal_emulator.exe", "security_bypass.dll"
                };

                for (int i = 0; i < files.length; i++) {
                    Thread.sleep(200 + (int)(Math.random() * 300));
                    int progress = (i + 1) * 100 / files.length;
                    updateProgress(files[i], progress);
                }

                Thread.sleep(500);
                loadingComplete = true;
                showPressAnyKey();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void showTitle() {
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ██████╗ ██╗   ██╗███████╗███████╗██╗     ███████╗");
        stateManager.getTerminal().printLine("  ██╔══██╗██║   ██║╚══███╔╝╚══███╔╝██║     ██╔════╝");
        stateManager.getTerminal().printLine("  ██████╔╝██║   ██║  ███╔╝   ███╔╝ ██║     █████╗  ");
        stateManager.getTerminal().printLine("  ██╔═══╝ ██║   ██║ ███╔╝   ███╔╝  ██║     ██╔══╝  ");
        stateManager.getTerminal().printLine("  ██║     ╚██████╔╝███████╗███████╗███████╗███████╗");
        stateManager.getTerminal().printLine("  ╚═╝      ╚═════╝ ╚══════╝╚══════╝╚══════╝╚══════╝");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ██╗  ██╗ █████╗  ██████╗██╗  ██╗███████╗██████╗ ");
        stateManager.getTerminal().printLine("  ██║  ██║██╔══██╗██╔════╝██║ ██╔╝██╔════╝██╔══██╗");
        stateManager.getTerminal().printLine("  ███████║███████║██║     █████╔╝ █████╗  ██████╔╝");
        stateManager.getTerminal().printLine("  ██╔══██║██╔══██║██║     ██╔═██╗ ██╔══╝  ██╔══██╗");
        stateManager.getTerminal().printLine("  ██║  ██║██║  ██║╚██████╗██║  ██╗███████╗██║  ██║");
        stateManager.getTerminal().printLine("  ╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("                    Version 1.0");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Inicializando sistema de hackeo...");
        stateManager.getTerminal().printLine("");
    }

    private void updateProgress(String filename, int progress) {
        stateManager.getTerminal().printLine("  Cargando: " + filename + " [" + progress + "%]");
        stateManager.getTerminal().printLine(progressBar.getProgressBar(progress, 50));
    }

    private void showPressAnyKey() {
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Sistema cargado exitosamente.");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  [PRESIONE CUALQUIER TECLA PARA CONTINUAR]");
    }

    @Override
    public void update() {
        if (loadingComplete && keyPressed) {
            stateManager.setState(new MenuState(stateManager));
        }
    }

    @Override
    public void render() {
        // La renderización se maneja en TerminalUI
    }

    @Override
    public void exit() {
        // Limpiar recursos si es necesario
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (loadingComplete) {
            keyPressed = true;
        }
    }
}