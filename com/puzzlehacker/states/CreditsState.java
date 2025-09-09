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
            "  • Arquitectura del juego y sistema de estados",
            "  • Interfaz de terminal y animaciones",
            "  • Generador de problemas matemáticos",
            "",
            "  Julio César Ramírez Vega",
            "  • Sistema de niveles y progresión",
            "  • Lógica de hackeo y narrativa",
            "  • Optimización y rendimiento",
            "",
            "  Eli Santiago López Mahecha",
            "  • Diseño de interfaz de usuario",
            "  • Sistema de configuración",
            "  • Testing y debugging",
            "",
            "  Daphne Geysi Rivera Flores",
            "  • Contenido matemático y educativo",
            "  • Balanceo de dificultad",
            "  • Documentación del proyecto",
            "",
            "  ════════════════════════════════════════════════════════════",
            "  INSTITUCIÓN EDUCATIVA:",
            "  ════════════════════════════════════════════════════════════",
            "",
            "  JALA UNIVERSITY",
            "  Programa de Ingeniería de Software",
            "",
            "  Proyecto Final - Curso de Programación Java",
            "  Semestre: 2025-1",
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
            "  A nuestros profesores y mentores de Jala University",
            "  por guiarnos en este apasionante mundo de la programación.",
            "",
            "  A la comunidad open source y a todos los desarrolladores",
            "  que comparten su conocimiento para que otros puedan aprender.",
            "",
            "  ════════════════════════════════════════════════════════════",
            "  OBJETIVO EDUCATIVO:",
            "  ════════════════════════════════════════════════════════════",
            "",
            "  PuzzleHacker fue creado con fines puramente educativos",
            "  para demostrar conceptos de:",
            "",
            "  • Programación orientada a objetos",
            "  • Diseño de interfaces gráficas",
            "  • Matemáticas aplicadas",
            "  • Lógica de programación",
            "  • Trabajo en equipo",
            "",
            "  Este juego no promueve actividades ilegales reales.",
            "  Es una simulación educativa para aprender programación",
            "  y matemáticas de manera divertida e interactiva.",
            "",
            "  ════════════════════════════════════════════════════════════",
            "  LICENCIA:",
            "  ════════════════════════════════════════════════════════════",
            "",
            "  MIT License - Uso educativo libre",
            "  Copyright (c) 2025 Equipo PuzzleHacker",
            "",
            "  ════════════════════════════════════════════════════════════",
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