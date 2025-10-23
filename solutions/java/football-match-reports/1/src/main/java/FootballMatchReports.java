public class FootballMatchReports {
    /**
     * Retorna a descrição da posição de um jogador com base no número da camisa.
     * @param shirtNum O número da camisa do jogador (deve ser de 1 a 11).
     * @return A descrição da posição em texto.
     * @throws IllegalArgumentException se o número da camisa estiver fora do intervalo de 1 a 11.
     */
    public static String onField(int shirtNum) {
        // Tarefa 2: Lança uma exceção para números de camisa inválidos
        if (shirtNum < 1 || shirtNum > 11) {
            throw new IllegalArgumentException("O número da camisa deve estar entre 1 e 11.");
        }

        // Tarefa 1: Retorna a posição para números de camisa válidos
        switch (shirtNum) {
            case 1:
                return "goalie";
            case 2:
                return "left back";
            case 3:
            case 4:
                return "center back";
            case 5:
                return "right back";
            case 6:
            case 7:
            case 8:
                return "midfielder";
            case 9:
                return "left wing";
            case 10:
                return "striker";
            case 11:
                return "right wing";
        }
        
        // Este ponto é inalcançável, pois a verificação inicial e o switch cobrem todos os casos.
        return "";
    }
}