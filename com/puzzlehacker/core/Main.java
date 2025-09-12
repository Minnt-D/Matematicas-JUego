package com.puzzlehacker.core;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Ajustamos look & feel oscuro estilo hacker
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("No se pudo aplicar el look and feel.");
        }

        SwingUtilities.invokeLater(() -> {
            JFrame window = new JFrame("PuzzleHacker");
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);

            // Inicializamos el motor del juego
            Game game = new Game();
            window.add(game);

            window.pack();
            window.setLocationRelativeTo(null);
            window.setVisible(true);

            // Arrancamos el loop principal
            game.start();
        });
    }
}
