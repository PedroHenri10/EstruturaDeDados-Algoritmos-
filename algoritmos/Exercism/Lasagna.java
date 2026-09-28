public class Lasagna {
    public int expectedMinutesInOven(){
        return 40;
    }

    public int remainingMinutesInOven(int minutesPass){
        int expected = expectedMinutesInOven();
        return expected - minutesPass;
    }

    public int preparationTimeInMinutes(int layers){
        return layers * 2;
    }

    public int totalTimeInMinutes(int layers, int minutePass){
        return preparationTimeInMinutes(layers) + minutePass;
    }
}
