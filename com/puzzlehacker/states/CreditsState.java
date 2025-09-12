// src/com/puzzlehacker/states/CreditsState.java
package com.puzzlehacker.states;

import com.puzzlehacker.core.GameState;
import com.puzzlehacker.core.StateManager;

import java.awt.event.KeyEvent;

public class CreditsState extends GameState {
    private int scrollOffset = 0;
    private final String[] creditLines = {
            "",
            "  ╔══════════════════════════════════════════════════════════╗",
            "  ║                       CRÉDITOS                          ║",
            "  ╚══════════════════════════════════════════════════════════╝",
            "",
            "  PUZZLEHACKER v1.0",
            "  Un proyecto educativo de programación y matemáticas",
            "",
            "  ════════════════════════════════════════════════════════════",
            "  DESARROLLADORES:",
            "  ════════════════════════════════════════════════════════════",
            "",
            "  Omar Alejandro Galvis Espitia",
            "",
            "  Julio César Ramírez Vega",
            "",
            "  Eli Santiago López Mahecha",
            "",
            "  Daphne Geysi Rivera Flores",
            "",
            "  ════════════════════════════════════════════════════════════",
            "  INSTITUCIÓN EDUCATIVA:",
            "  ════════════════════════════════════════════════════════════",
            "",
            "  JALA UNIVERSITY",
            "  Laboratorio 1 - Matematicas Discretas",
            "  Semestre: 2025-1 (0725)",
            "",
            "  ════════════════════════════════════════════════════════════",
            "  TECNOLOGÍAS UTILIZADAS:",
            "  ════════════════════════════════════════════════════════════",
            "",
            "  • Java SE 8+",
            "  • Swing / Java2D",
            "  • Arquitectura MVC",
            "  • Patrón State Machine",
            "",
            "  ════════════════════════════════════════════════════════════",
            "  AGRADECIMIENTOS ESPECIALES:",
            "  ════════════════════════════════════════════════════════════",
            "",
            "  A mis gatos",
            "  y chatgpt y a karen no.",
            "",
            "  ════════════════════════════════════════════════════════════",
            "  OBJETIVO EDUCATIVO:",
            "  ════════════════════════════════════════════════════════════",
            "",
            "  PuzzleHacker fue creado con fines puramente educativos",
            "  para demostrar conceptos de:",
            "",
            "  • Programación orientada a objetos",
            "  • Matemáticas discretas",
            "  • Lógica de programación",
            "  • Trabajo en equipo",
            "",
            "  Este juego no promueve actividades ilegales reales.",
            "  Es una simulación educativa para aprender programación",
            "  y matemáticas de manera divertida e interactiva.",
            "",
            "  ¡Gracias por jugar PuzzleHacker!",
            "",
            "  Esperamos que haya sido una experiencia educativa",
            "  divertida y que hayas aprendido algo nuevo sobre",
            "  programación y matemáticas.",
            "",
            "  Para más proyectos educativos como este,",
            "  visita: github.com/jala-university",
            "",
            "  ════════════════════════════════════════════════════════════",
            "",
            "  [ESC] Volver al menú principal",
            "  [↑↓] Desplazar",
            "",
            ""
    };

    public CreditsState(StateManager stateManager) {
        super(stateManager);
    }

    @Override
    public void enter() {
        scrollOffset = 0;
        showCredits();
    }

    private void showCredits() {
        stateManager.getTerminal().clearScreen();

        // Mostrar líneas visibles según el offset de scroll
        int visibleLines = 25; // Aproximadamente las líneas visibles en pantalla

        for (int i = 0; i < visibleLines && (scrollOffset + i) < creditLines.length; i++) {
            int lineIndex = scrollOffset + i;
            if (lineIndex >= 0 && lineIndex < creditLines.length) {
                stateManager.getTerminal().printLine(creditLines[lineIndex]);
            }
        }
    }

    @Override
    public void update() {
        // Los créditos pueden tener auto-scroll si se desea
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
                if (scrollOffset > 0) {
                    scrollOffset--;
                    showCredits();
                }
                break;

            case KeyEvent.VK_DOWN:
                if (scrollOffset < creditLines.length - 20) {
                    scrollOffset++;
                    showCredits();
                }
                break;

            case KeyEvent.VK_PAGE_UP:
                scrollOffset = Math.max(0, scrollOffset - 10);
                showCredits();
                break;

            case KeyEvent.VK_PAGE_DOWN:
                scrollOffset = Math.min(creditLines.length - 20, scrollOffset + 10);
                showCredits();
                break;

            case KeyEvent.VK_HOME:
                scrollOffset = 0;
                showCredits();
                break;

            case KeyEvent.VK_END:
                scrollOffset = Math.max(0, creditLines.length - 20);
                showCredits();
                break;

            case KeyEvent.VK_ESCAPE:
            case KeyEvent.VK_ENTER:
                stateManager.setState(new MenuState(stateManager));
                break;
        }
    }

}