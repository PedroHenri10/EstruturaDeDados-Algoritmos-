import java.util.ArrayList;
import java.util.List;

class Sieve {

    private final List<Integer> primes = new ArrayList<>();

    Sieve(int maxPrime) {

        boolean[] marked = new boolean[maxPrime + 1];

        for (int number = 2; number <= maxPrime; number++) {

            if (marked[number]) {
                continue;
            }

            primes.add(number);

            for (int multiple = number * 2;
                 multiple <= maxPrime;
                 multiple += number) {

                marked[multiple] = true;
            }
        }
    }

    List<Integer> getPrimes() {
        return primes;
    }
}
