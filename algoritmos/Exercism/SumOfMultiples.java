import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class SumOfMultiples {
    private int number;
    private int[] set;

    SumOfMultiples(int number, int[] set) {
        this.number = number;
        this.set = set;
    }

    int getSum() {
        Set<Integer> sumOfMultiples = new HashSet<>();

        for (int numberWithinTheSet : set) {
            if (numberWithinTheSet == 0) {
                sumOfMultiples.add(0);
                continue;
            }

            int i = 1; 
            while (numberWithinTheSet * i < number) {
                sumOfMultiples.add(numberWithinTheSet * i);
                i++; 
            }
        }

        return sumOfMultiples.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
