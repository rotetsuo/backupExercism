class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder resultado = new StringBuilder();
        boolean proximoCaractereMaiusculo = false;

        for (char caractere : identifier.toCharArray()) {

            if (caractere == ' ') {
                resultado.append('_');
            
            } else if (caractere == '-') {
                proximoCaractereMaiusculo = true;
            
            // Tratando o leetspeak como caracteres especiais
            } else if (caractere == '4') {
                resultado.append('a');
            } else if (caractere == '3') {
                resultado.append('e');
            } else if (caractere == '0') {
                resultado.append('o');
            } else if (caractere == '1') {
                resultado.append('l');
            } else if (caractere == '7') {
                resultado.append('t');

            // Agora, só processe se for uma letra
            } else if (Character.isLetter(caractere)) {
                if (proximoCaractereMaiusculo) {
                    resultado.append(Character.toUpperCase(caractere));
                    proximoCaractereMaiusculo = false;
                } else {
                    resultado.append(caractere);
                }
            }
            // Qualquer outro caractere (como '$', '#', '%') é simplesmente ignorado
            // pois não entra em nenhuma das condições.
        }

        return resultado.toString();
    }
}