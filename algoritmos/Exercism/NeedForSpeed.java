class NeedForSpeed {
    private int speed;
    private int batteryDrain;
    private int distance = 0;
    private int battery = 100;

    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public int getSpeed() { return this.speed; }
    public int getBatteryDrain() { return this.batteryDrain; }

    void drive() {
        if (!batteryDrained()) {
            distance += speed;
            battery -= batteryDrain;
        }
    }

    int distanceDriven() {
        return distance;
    }

    boolean batteryDrained() {
        return battery < batteryDrain;
    }

    static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private int distance;

    RaceTrack(int distance) {
        this.distance = distance;
    }

    boolean canFinishRace(NeedForSpeed car) {
        int maxMovimentos = 100 / car.getBatteryDrain();
        int distanciaMaxima = maxMovimentos * car.getSpeed();
        return distanciaMaxima >= this.distance;
    }
}
