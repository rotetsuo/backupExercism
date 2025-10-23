public enum LogLevel {
     UNKNOWN(0),
    // Tarefa 1: Define os membros para cada nível de log
    // Tarefa 3: Associa cada nível a um código numérico
    TRACE(1),
    DEBUG(2),
    INFO(4),
    WARNING(5),
    ERROR(6),
    FATAL(42);

    private final int encodedLevel;

    /**
     * Construtor para associar um código numérico a cada nível de log.
     * @param encodedLevel O código numérico do nível.
     */
    LogLevel(int encodedLevel) {
        this.encodedLevel = encodedLevel;
    }

    /**
     * Retorna o código numérico associado ao nível de log.
     * @return O código numérico.
     */
    public int getEncodedLevel() {
        return this.encodedLevel;
    }
}
