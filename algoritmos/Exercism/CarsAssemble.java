public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double production = speed * 221;
        
        if (speed >= 5 && speed <= 8) {
            production *= 0.90;
        } else if (speed == 9) {
            production *= 0.80;
        } else if (speed == 10) {
            production *= 0.77;
        }
        
        return production;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
