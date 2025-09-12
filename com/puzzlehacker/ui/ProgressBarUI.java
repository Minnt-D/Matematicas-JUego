package com.puzzlehacker.ui;

import javax.swing.*;
import java.awt.*;

/**
 * ProgressBarUI - Barra de progreso estilo hacker para SplashState
 * - Fondo oscuro
 * - Texto monoespaciado
 * - Animación con Timer
 */
public class ProgressBarUI extends JPanel {

    private int progress = 0; // valor actual 0-100
    private String message = "Cargando archivos del sistema...";
    private Timer timer;

    public ProgressBarUI() {
        setPreferredSize(new Dimension(700, 80));
        setBackground(Color.BLACK);

        // Timer que incrementa automáticamente la barra
        timer = new Timer(40, e -> {
            if (progress < 100) {
                progress++;
                repaint();
            } else {
                timer.stop();
            }
        });
    }

    /**
     * Inicia la animación de la barra.
     */
    public void start() {
        progress = 0;
        timer.start();
    }

    /**
     * Cambia el mensaje mostrado arriba de la barra.
     */
    public void setMessage(String msg) {
        this.message = msg;
        repaint();
    }

    /**
     * Devuelve true si la barra llegó al 100%.
     */
    public boolean isComplete() {
        return progress >= 100;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Texto
        g2d.setColor(new Color(0, 255, 70)); // verde hacker
        g2d.setFont(new Font("Monospaced", Font.BOLD, 16));
        g2d.drawString(message, 20, 25);

        // Barra de fondo
        g2d.setColor(new Color(50, 50, 50));
        g2d.fillRect(20, 40, getWidth() - 40, 20);

        // Barra de progreso
        g2d.setColor(new Color(0, 255, 70));
        int barWidth = (int) ((getWidth() - 40) * (progress / 100.0));
        g2d.fillRect(20, 40, barWidth, 20);

        // Texto de porcentaje
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Monospaced", Font.PLAIN, 14));
        String percent = progress + "%";
        int strWidth = g2d.getFontMetrics().stringWidth(percent);
        g2d.drawString(percent, getWidth() - strWidth - 20, 75);
    }
}
