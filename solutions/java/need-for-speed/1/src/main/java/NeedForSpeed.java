class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distanceDriven;
    private int battery;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
        this.distanceDriven = 0;
        this.battery = 100;
    }

    // Este método verifica se a bateria está completamente vazia.
    // A verificação this.battery < this.batteryDrain é usada para ver se o carro PODE andar.
    public boolean batteryDrained() {
        return this.battery < this.batteryDrain;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    // O método drive só deve funcionar se houver bateria suficiente.
    public void drive() {
        if (!batteryDrained()) {
            this.distanceDriven += this.speed;
            this.battery -= this.batteryDrain;
        }
    }

    // Um método estático não pode usar 'this'. Ele deve criar e retornar um novo objeto.
    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    // A lógica foi refeita para simular a corrida corretamente.
    public boolean canFinishRace(NeedForSpeed car) {
        // Simula a corrida passo a passo
        while (!car.batteryDrained() && car.distanceDriven() < this.distance) {
            car.drive();
        }

        // Retorna true se a distância percorrida for maior ou igual à da pista
        return car.distanceDriven() >= this.distance;
    }
}