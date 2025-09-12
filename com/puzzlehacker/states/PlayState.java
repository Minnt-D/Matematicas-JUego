package com.puzzlehacker.states;

import com.puzzlehacker.core.StateManager;
import com.puzzlehacker.math.MathProblemGenerator;
import com.puzzlehacker.math.Problem;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class PlayState extends GameState {

    private int level;
    private int currentProblemIndex;
    private List<Problem> problems;
    private String userInput;
    private boolean showFeedback;
    private String feedbackMessage;

    private MathProblemGenerator generator;

    public PlayState(StateManager stateManager) {
        super(stateManager);
        this.level = 1; // empieza en nivel 1
        this.currentProblemIndex = 0;
        this.userInput = "";
        this.showFeedback = false;
        this.feedbackMessage = "";

        this.generator = new MathProblemGenerator();
        this.problems = new ArrayList<>();
    }

    @Override
    public String getName() {
        return "Play";
    }

    @Override
    public void enter() {
        // Generamos 10 problemas para el nivel actual
        problems = generator.generateProblemsForLevel(level, 10);
        currentProblemIndex = 0;
        userInput = "";
        showFeedback = false;
    }

    @Override
    public void update() {
        // Aquí podríamos añadir animaciones en el futuro
    }

    @Override
    public void render(Graphics2D g2d) {
        // Fondo oscuro estilo terminal
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 700, 500);

        g2d.setFont(new Font("Monospaced", Font.PLAIN, 16));

        // Header
        g2d.setColor(Color.GREEN);
        g2d.drawString("Nivel " + level + " - Ejercicio " + (currentProblemIndex + 1) + "/10", 20, 40);

        // Problema actual
        g2d.setColor(Color.WHITE);
        if (currentProblemIndex < problems.size()) {
            Problem p = problems.get(currentProblemIndex);
            g2d.drawString("Problema: " + p.getQuestion(), 20, 80);
        }

        // Entrada del usuario (simulación de terminal)
        g2d.setColor(Color.CYAN);
        g2d.drawString("> " + userInput + "_", 20, 120);

        // Feedback
        if (showFeedback) {
            g2d.setColor(Color.YELLOW);
            g2d.drawString(feedbackMessage, 20, 160);
        }
    }

    @Override
    public void handleInput(String input) {
        if (currentProblemIndex >= problems.size()) {
            return;
        }

        Problem p = problems.get(currentProblemIndex);

        if (input.equalsIgnoreCase(p.getAnswer())) {
            feedbackMessage = "✔ Correcto! Avanzando...";
            showFeedback = true;
            currentProblemIndex++;
            userInput = "";

            // Si completó todos los problemas, sube de nivel
            if (currentProblemIndex >= problems.size()) {
                level++;
                feedbackMessage = "✔ Nivel completado. Avanzando al nivel " + level;
                problems = generator.generateProblemsForLevel(level, 10);
                currentProblemIndex = 0;
            }
        } else {
            feedbackMessage = "✘ Incorrecto. Intenta de nuevo.";
            showFeedback = true;
            userInput = "";
        }
    }

    // Simulación de tipeo estilo terminal
    public void handleCommand(String command) {
        if (command.equalsIgnoreCase("ENTER")) {
            handleInput(userInput.trim());
        } else if (command.equalsIgnoreCase("BACKSPACE")) {
            if (!userInput.isEmpty()) {
                userInput = userInput.substring(0, userInput.length() - 1);
            }
        } else {
            userInput += command;
        }
    }
}
