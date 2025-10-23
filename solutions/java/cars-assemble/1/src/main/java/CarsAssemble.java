public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double trueProduction = speed * 221;
        double taxaDeSucesso;

        // Determina a taxa de sucesso com base na velocidade
        if (speed >= 1 && speed <= 4) {
            taxaDeSucesso = 1.0; // 100%
        } else if (speed >= 5 && speed <= 8) {
            taxaDeSucesso = 0.9; // 90%
        } else if (speed == 9) {
            taxaDeSucesso = 0.8; // 80%
        } else if (speed == 10) {
            taxaDeSucesso = 0.77; // 77%
        } else {
            // Para velocidade 0 ou qualquer outro valor inesperado, a taxa é 0.
            taxaDeSucesso = 0.0;
        }

        // Retorna a produção real (produção teórica * taxa de sucesso)
        return trueProduction * taxaDeSucesso;
    }

    public int workingItemsPerMinute(int speed) {
        double producaoPorHora = productionRatePerHour(speed);

        // Converte a produção por hora para produção por minuto
        double producaoPorMinuto = producaoPorHora / 60.0;

        // Converte (faz o "cast") do resultado para int, descartando as casas decimais
        return (int) producaoPorMinuto;
    }
}
