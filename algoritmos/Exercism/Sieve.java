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
/*
    import java.util.ArrayList;
import java.util.List;

class Sieve {

    private final List<Integer> primes = new ArrayList<>();

    Sieve(int maxPrime) {
        if (maxPrime < 2) {
            return;
        }

        boolean[] composite = new boolean[maxPrime + 1];

        for (int number = 2; number <= maxPrime / number; number++) {
            if (composite[number]) {
                continue;
            }

            for (int multiple = number * number;
                 multiple <= maxPrime;
                 multiple += number) {
                composite[multiple] = true;
            }
        }

        for (int number = 2; number <= maxPrime; number++) {
            if (!composite[number]) {
                primes.add(number);
            }
        }
    }

    List<Integer> getPrimes() {
        return new ArrayList<>(primes);
    }
}
*/
    List<Integer> getPrimes() {
        return primes;
    }
}
