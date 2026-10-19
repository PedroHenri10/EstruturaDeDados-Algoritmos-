
import java.util.Arrays;

class BirdWatcher {

    private int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay;
    }

    public static int[] getLastWeek() {
        return new int[] {0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        int ultimoIndice = birdsPerDay.length - 1;
        birdsPerDay[ultimoIndice] = birdsPerDay[ultimoIndice] + 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int i = 0; i < birdsPerDay.length; i++) {
            if (birdsPerDay[i] == 0) {
                return true;
            }
        }

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int total = 0;

        for (int i = 0; i < numberOfDays && i < birdsPerDay.length; i++) {
    total = total + birdsPerDay[i];
}

        return total;
    }

    public int getBusyDays() {
        int diasMovimentados = 0;

        for (int i = 0; i < birdsPerDay.length; i++) {
            if (birdsPerDay[i] >= 5) {
                diasMovimentados++;
            }
        }

        return diasMovimentados;
    }
}
