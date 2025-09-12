package com.puzzlehacker.states;

import com.puzzlehacker.core.StateManager;
import java.awt.Graphics2D;

public abstract class GameState {

    protected StateManager stateManager;

    public GameState(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    /**
     * Nombre del estado, usado en StateManager
     */
    public abstract String getName();

    /**
     * Se ejecuta al entrar al estado (inicialización, reset de variables, etc.)
     */
    public abstract void enter();

    /**
     * Actualiza la lógica del estado (animaciones, timers, etc.)
     */
    public abstract void update();

    /**
     * Renderiza la interfaz del estado
     */
    public abstract void render(Graphics2D g2d);

    /**
     * Manejo de entrada de texto o comandos desde TerminalUI
     */
    public abstract void handleInput(String input);
}
