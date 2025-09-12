package com.puzzlehacker.problems;

/**
 * Problem - Representa un ejercicio matemático dentro del juego.
 * Contiene el enunciado, la respuesta correcta y una pista opcional.
 */
public class Problem {

    private final String statement;   // enunciado que se mostrará en el terminal
    private final String answer;      // respuesta esperada
    private final String hint;        // pista opcional
    private final ProblemType type;   // tipo de problema (sumatoria, logaritmo, etc.)

    public enum ProblemType {
        SUMMATION,
        LOGARITHM,
        SETS,
        INTEGRAL,
        OTHER
    }

    public Problem(String statement, String answer, String hint, ProblemType type) {
        this.statement = statement;
        this.answer = answer;
        this.hint = hint;
        this.type = type;
    }

    public String getStatement() {
        return statement;
    }

    public String getAnswer() {
        return answer;
    }

    public String getHint() {
        return hint;
    }

    public ProblemType getType() {
        return type;
    }

    /**
     * Verifica si la respuesta del jugador es correcta.
     * - Ignora espacios
     * - No distingue mayúsculas/minúsculas
     */
    public boolean checkAnswer(String userInput) {
        if (userInput == null) return false;
        return userInput.trim().equalsIgnoreCase(answer.trim());
    }

    @Override
    public String toString() {
        return "Problem{" +
                "statement='" + statement + '\'' +
                ", answer='" + answer + '\'' +
                ", type=" + type +
                '}';
    }
}
