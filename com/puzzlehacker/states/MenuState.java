// src/com/puzzlehacker/states/MenuState.java
package com.puzzlehacker.states;

import com.puzzlehacker.core.GameState;
import com.puzzlehacker.core.StateManager;

import java.awt.event.KeyEvent;

public class MenuState extends GameState {
    private int selectedOption = 0;
    private String[] menuOptions;
    private boolean cursorBlink = true;
    private long lastBlinkTime = System.currentTimeMillis();

    public MenuState(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public void enter() {
        updateMenuOptions();
        showMenu();
    }

    private void updateMenuOptions() {
        if (stateManager.hasProgress()) {
            menuOptions = new String[]{
                    "CONTINUAR",
                    "NUEVA MISIÓN",
                    "AJUSTES",
                    "CRÉDITOS",
                    "SALIR"
            };
        } else {
            menuOptions = new String[]{
                    "NUEVA MISIÓN",
                    "AJUSTES",
                    "CRÉDITOS",
                    "SALIR"
            };
        }
    }

    private void showMenu() {
        stateManager.getTerminal().clearScreen();
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ╔══════════════════════════════════════════════════════════╗");
        stateManager.getTerminal().printLine("  ║                    MENÚ PRINCIPAL                        ║");
        stateManager.getTerminal().printLine("  ╚══════════════════════════════════════════════════════════╝");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Sistema operativo: HackerOS v2.1.337");
        stateManager.getTerminal().printLine("  Usuario: anonymous");
        stateManager.getTerminal().printLine("  Privilegios: root");
        stateManager.getTerminal().printLine("  Conexión: VPN activa [TOR/ENCRYPTED]");
        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  ┌────────────────────────────────────────────────────────┐");
        stateManager.getTerminal().printLine("  │ Seleccione una opción:                                 │");
        stateManager.getTerminal().printLine("  └────────────────────────────────────────────────────────┘");
        stateManager.getTerminal().printLine("");

        for (int i = 0; i < menuOptions.length; i++) {
            String prefix = (i == selectedOption) ? "  > " : "    ";
            stateManager.getTerminal().printLine(prefix + menuOptions[i]);
        }

        stateManager.getTerminal().printLine("");
        stateManager.getTerminal().printLine("  Use ↑↓ para navegar, ENTER para seleccionar");
    }

    @Override
    public void update() {
        // Cursor parpadeante
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastBlinkTime > 500) {
            cursorBlink = !cursorBlink;
            lastBlinkTime = currentTime;
            updateCursor();
        }
    }

    private void updateCursor() {
        // Actualizar solo la línea del cursor sin redibujar todo el menú
        stateManager.getTerminal().updateMenuCursor(selectedOption, menuOptions, cursorBlink);
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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                selectedOption = (selectedOption - 1 + menuOptions.length) % menuOptions.length;
                showMenu();
                break;

            case KeyEvent.VK_DOWN:
                selectedOption = (selectedOption + 1) % menuOptions.length;
                showMenu();
                break;

            case KeyEvent.VK_ENTER:
                handleSelection();
                break;

            case KeyEvent.VK_ESCAPE:
                stateManager.getGame().stop();
                break;
        }
    }

    private void handleSelection() {
        String selectedAction = menuOptions[selectedOption];

        switch (selectedAction) {
            case "CONTINUAR":
                // Ir al último nivel desbloqueado
                int lastLevel = 1;
                for (int i = 6; i >= 1; i--) {
                    if (stateManager.isLevelCompleted(i)) {
                        lastLevel = i + 1;
                        break;
                    }
                }
                if (lastLevel > 6) lastLevel = 6;
                stateManager.setCurrentLevel(lastLevel);
                stateManager.setState(new PlayState(stateManager));
                break;

            case "NUEVA MISIÓN":
                stateManager.setCurrentLevel(1);
                stateManager.setState(new PlayState(stateManager));
                break;

            case "AJUSTES":
                stateManager.setState(new SettingsState(stateManager));
                break;

            case "CRÉDITOS":
                stateManager.setState(new CreditsState(stateManager));
                break;

            case "SALIR":
                stateManager.getGame().stop();
                break;
        }
    }
}