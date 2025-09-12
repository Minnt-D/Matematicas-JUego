package com.puzzlehacker.ui;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * TerminalUI - una terminal estilo Kali/Linux basada en Swing.
 * - Fondo oscuro
 * - Texto monoespaciado
 * - Scroll con JScrollPane
 * - Efecto typewriter opcional
 *
 * Uso:
 * TerminalUI t = new TerminalUI(700, 500, input -> state.handleInput(input));
 * t.println("Bienvenido", false);
 * t.println("Cargando...", true); // con efecto typewriter
 */
public class TerminalUI extends JPanel {

    public interface TerminalInputListener {
        void onInput(String input);
    }

    private final JTextPane textPane;
    private final JTextField inputField;
    private final JScrollPane scrollPane;

    private Color textColor = new Color(0x00FF66); // verde hacker por defecto
    private SimpleAttributeSet textAttr;

    // Typewriter
    private final Queue<String> printQueue = new LinkedList<>();
    private Timer typewriterTimer;
    private int typewriterIndex;     // índice dentro de la cadena actual
    private String currentTyping;    // cadena en curso
    private boolean typewriterEnabled = true;
    private int typewriterDelay = 8; // ms por carácter (ajustable)

    private TerminalInputListener listener;

    public TerminalUI(int width, int height, TerminalInputListener listener) {
        this.listener = listener;
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);

        // TextPane (salida)
        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setBackground(Color.BLACK);
        textPane.setFont(new Font("Monospaced", Font.PLAIN, 13));
        textPane.setForeground(textColor);

        // Atributos para texto coloreado
        textAttr = new SimpleAttributeSet();
        StyleConstants.setForeground(textAttr, textColor);
        StyleConstants.setFontFamily(textAttr, "Monospaced");
        StyleConstants.setFontSize(textAttr, 13);

        // ScrollPane
        scrollPane = new JScrollPane(textPane);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // scroll más suave
        add(scrollPane, BorderLayout.CENTER);

        // Input field (entrada)
        inputField = new JTextField();
        inputField.setBackground(Color.BLACK);
        inputField.setForeground(textColor);
        inputField.setCaretColor(textColor);
        inputField.setFont(new Font("Monospaced", Font.PLAIN, 13));
        inputField.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(0x202020)));
        inputField.addActionListener(e -> {
            String text = inputField.getText();
            if (text == null) text = "";
            // Imprime en la terminal la línea de entrada (estética)
            println("> " + text, false);
            inputField.setText("");
            if (listener != null) listener.onInput(text);
        });

        // KeyListener opcional para detectar teclas especiales (p. ej. para sonidos)
        inputField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // ejemplo: si quisieras mapear ESC para volver:
                // if (e.getKeyCode() == KeyEvent.VK_ESCAPE) ...
            }
        });

        add(inputField, BorderLayout.SOUTH);

        // Inicializar timer del typewriter (no arrancar aún)
        initTypewriterTimer();
    }

    private void initTypewriterTimer() {
        typewriterTimer = new Timer(typewriterDelay, e -> {
            if (currentTyping == null) {
                // no hay texto en curso: tomar siguiente de la cola
                currentTyping = printQueue.poll();
                typewriterIndex = 0;
                if (currentTyping == null) {
                    typewriterTimer.stop();
                    return;
                }
            }
            // insertar un carácter más
            char c = currentTyping.charAt(typewriterIndex);
            appendToPane(String.valueOf(c), textAttr);
            typewriterIndex++;
            if (typewriterIndex >= currentTyping.length()) {
                // terminar la línea, añadir salto de línea
                appendToPane("\n", textAttr);
                currentTyping = null;
            }
        });
        typewriterTimer.setRepeats(true);
    }

    /**
     * Imprime una línea en la terminal.
     *
     * @param text       Texto a imprimir (no añade '\n' si typewriter activo, lo maneja internamente).
     * @param typewriter Si true, usa efecto typewriter (animado). Si false, imprime directamente.
     */
    public synchronized void println(String text, boolean typewriter) {
        if (text == null) text = "null";
        if (typewriter && typewriterEnabled) {
            // Encolar para animación
            printQueue.add(text);
            if (!typewriterTimer.isRunning()) {
                typewriterTimer.start();
            }
        } else {
            appendToPane(text + "\n", textAttr);
        }
        // Asegurar scroll abajo
        SwingUtilities.invokeLater(() -> textPane.setCaretPosition(textPane.getDocument().getLength()));
    }

    /**
     * Imprime sin salto de línea (útil para prompts).
     */
    public synchronized void print(String text) {
        if (text == null) text = "null";
        appendToPane(text, textAttr);
        SwingUtilities.invokeLater(() -> textPane.setCaretPosition(textPane.getDocument().getLength()));
    }

    /**
     * Limpia la terminal.
     */
    public void clear() {
        SwingUtilities.invokeLater(() -> {
            textPane.setText("");
        });
    }

    /**
     * Pone foco en la entrada de texto.
     */
    public void focusInput() {
        SwingUtilities.invokeLater(() -> inputField.requestFocusInWindow());
    }

    /**
     * Cambia el color del texto en caliente.
     */
    public void setTextColor(Color c) {
        if (c == null) return;
        this.textColor = c;
        SwingUtilities.invokeLater(() -> {
            textPane.setForeground(c);
            inputField.setForeground(c);
            inputField.setCaretColor(c);
            StyleConstants.setForeground(textAttr, c);
        });
    }

    /**
     * Habilita o deshabilita el efecto typewriter.
     */
    public void setTypewriterEnabled(boolean enabled) {
        this.typewriterEnabled = enabled;
        if (!enabled) {
            // vaciar cola y detener timer, imprimir todo inmediatamente
            if (typewriterTimer.isRunning()) typewriterTimer.stop();
            while (!printQueue.isEmpty()) {
                appendToPane(printQueue.poll() + "\n", textAttr);
            }
            currentTyping = null;
        }
    }

    /**
     * Ajusta el delay (ms) entre caracteres del typewriter.
     */
    public void setTypewriterDelay(int ms) {
        if (ms < 1) ms = 1;
        typewriterDelay = ms;
        typewriterTimer.setDelay(typewriterDelay);
    }

    /**
     * Asigna un listener para recibir los inputs del usuario.
     */
    public void setOnInput(TerminalInputListener listener) {
        this.listener = listener;
    }

    /**
     * Inserta texto en el JTextPane con formato (seguro en EDT).
     */
    private void appendToPane(String msg, AttributeSet attr) {
        SwingUtilities.invokeLater(() -> {
            Document doc = textPane.getDocument();
            try {
                doc.insertString(doc.getLength(), msg, attr);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
            textPane.setCaretPosition(doc.getLength());
        });
    }

    /**
     * Devuelve el contenido de la terminal (útil para guardar logs o easter eggs).
     */
    public String getContent() {
        try {
            return textPane.getDocument().getText(0, textPane.getDocument().getLength());
        } catch (BadLocationException e) {
            return "";
        }
    }

    /**
     * Cambia la fuente monoespaciada (opcional).
     */
    public void setTerminalFont(Font font) {
        if (font == null) return;
        SwingUtilities.invokeLater(() -> {
            textPane.setFont(font);
            inputField.setFont(font);
            StyleConstants.setFontFamily(textAttr, font.getFamily());
            StyleConstants.setFontSize(textAttr, font.getSize());
        });
    }
}
