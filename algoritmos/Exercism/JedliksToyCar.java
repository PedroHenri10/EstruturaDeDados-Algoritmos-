
class JedliksToyCar {

    private int distanciaPercorrida = 0;
    private int bateria = 100;

    static JedliksToyCar buy() {
        return new JedliksToyCar();
    }

    String distanceDisplay() {
        return "Driven " + distanciaPercorrida + " meters";
    }

    String batteryDisplay() {
        if (bateria == 0) {
            return "Battery empty";
        }

        return "Battery at " + bateria + "%";
    }

    void drive() {
        if (bateria > 0) {
            distanciaPercorrida += 20;
            bateria--;
        }
    }
}
