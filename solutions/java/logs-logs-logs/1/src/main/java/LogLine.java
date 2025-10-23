public class LogLine {
    private final String logLine;
    private final LogLevel logLevel;
    private final String message;

    /**
     * Construtor que processa a linha de log para extrair o nível e a mensagem.
     * @param logLine A linha de log completa, ex: "[INF]: Mensagem"
     */
    public LogLine(String logLine) {
        this.logLine = logLine;
        // Extrai o código do log de dentro dos colchetes, ex: "INF"
        String levelStr = logLine.substring(1, 4);
        // Extrai a mensagem após os ": "
        this.message = logLine.substring(7);
        // Converte a string do nível para o enum correspondente
        this.logLevel = parseLogLevel(levelStr);
    }

    /**
     * Retorna o LogLevel correspondente à linha de log.
     * @return O enum LogLevel.
     */
    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    /**
     * Converte a string do nível (ex: "INF") para o enum LogLevel.
     * @param levelStr A string de 3 letras do nível.
     * @return O enum LogLevel correspondente, ou UNKNOWN se não for encontrado.
     */
    private LogLevel parseLogLevel(String levelStr) {
        switch (levelStr) {
            case "TRC":
                return LogLevel.TRACE;
            case "DBG":
                return LogLevel.DEBUG;
            case "INF":
                return LogLevel.INFO;
            case "WRN":
                return LogLevel.WARNING;
            case "ERR":
                return LogLevel.ERROR;
            case "FTL":
                return LogLevel.FATAL;
            default:
                return LogLevel.UNKNOWN;
        }
    }

    /**
     * Retorna a linha de log no formato curto.
     * Ex: "6:Stack Overflow"
     * @return A string do log formatada.
     */
    public String getOutputForShortLog() {
        // Pega o código numérico do enum e concatena com a mensagem.
        return this.logLevel.getEncodedLevel() + ":" + this.message;
    }

}
