package com.puzzlehacker.states;

import com.puzzlehacker.core.StateManager;

import java.awt.*;

public class CreditsState extends GameState {

    private String[] credits = {
            "=== CREDITOS / CREDITS ===",
            "",
            "Omar Alejandro Galvis Espitia",
            "Julio Cesar Ramirez Vega",
            "Eli Santiago Lopez Mahecha",
            "Daphne Geysi Rivera Flores",
            "",
            "Un proyecto para Jala University",
            "",
            "Presione ENTER para volver al menu..."
    };

    public CreditsState(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public String getName() {
        return "Credits";
    }

    @Override
    public void update() {
        // Nada que actualizar
    }

    @Override
    public void render(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 700, 500);

        g2d.setFont(new Font("Monospaced", Font.PLAIN, 18));
        g2d.setColor(new Color(0, 255, 70)); // verde hacker

        int y = 80;
        for (String line : credits) {
            g2d.drawString(line, 120, y);
            y += 35;
        }
    }

    @Override
    public void handleCommand(String command) {
        if ("ENTER".equals(command)) {
            stateManager.setState("Menu");
        }
    }
}
