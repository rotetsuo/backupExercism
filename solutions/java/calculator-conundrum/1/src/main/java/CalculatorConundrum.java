class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) {
        int result;

        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }
        if (operation.isEmpty()) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }
        
        try {
            switch (operation) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    // A divisão que pode causar um erro fica dentro do try
                    result = operand1 / operand2;
                    break;
                default:
                    // --- Tarefa 2: Operação inválida ---
                    String errorMessage = String.format("Operation '%s' does not exist", operation);
                    throw new IllegalOperationException(errorMessage);
            }
        } catch (ArithmeticException e) {
            // Se uma ArithmeticException (como divisão por zero) ocorrer,
            // nós a capturamos e lançamos nossa própria exceção.
            throw new IllegalOperationException("Division by zero is not allowed", e);
        }
        return operand1 + " " + operation + " " + operand2 + " = " + result;
    }
}
