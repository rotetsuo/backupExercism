import java.util.Random;

class CaptainsLog {

    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    private Random random;

    CaptainsLog(Random random) {
        this.random = random;
    }

    /**
     * Retorna uma classe de planeta aleatória do array PLANET_CLASSES.
     */
    char randomPlanetClass() {
        int randomIndex = this.random.nextInt(PLANET_CLASSES.length);
        return PLANET_CLASSES[randomIndex];
    }

    /**
     * Retorna um número de registro de nave aleatório no formato "NCC-XXXX".
     */
    String randomShipRegistryNumber() {
        // Gera um número de 0 a 8999 e depois soma 1000 para ficar no intervalo de 1000 a 9999.
        int number = 1000 + this.random.nextInt(9000);
        return "NCC-" + number;
    }

    /**
     * Retorna uma data estelar aleatória entre 41000.0 (inclusivo) e 42000.0 (exclusivo).
     */
    double randomStardate() {
        // random.nextDouble() gera um valor entre 0.0 e 1.0.
        // Multiplicamos pelo tamanho do intervalo (1000) e somamos o valor inicial (41000).
        return 41000.0 + this.random.nextDouble() * 1000.0;
    }
}