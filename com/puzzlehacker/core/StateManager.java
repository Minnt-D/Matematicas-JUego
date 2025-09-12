package com.puzzlehacker.core;

import com.puzzlehacker.states.GameState;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class StateManager {

    private final Map<String, GameState> states;
    private GameState currentState;

    public StateManager() {
        states = new HashMap<>();
    }

    // Añadir un nuevo estado al gestor
    public void addState(GameState state) {
        states.put(state.getName(), state);
    }

    // Cambiar entre estados
    public void setState(String name) {
        GameState newState = states.get(name);
        if (newState != null) {
            currentState = newState;
            currentState.enter(); // Acción al entrar al estado
        } else {
            System.err.println("⚠️ Estado no encontrado: " + name);
        }
    }

    // Obtener el estado actual
    public GameState getCurrentState() {
        return currentState;
    }

    // Actualizar estado actual
    public void update() {
        if (currentState != null) {
            currentState.update();
        }
    }

    // Renderizar estado actual
    public void render(Graphics2D g2d) {
        if (currentState != null) {
            currentState.render(g2d);
        }
    }
}
