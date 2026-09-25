import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KillerSudokuHelper {

    List<List<Integer>> combinationsInCage(
            Integer cageSum,
            Integer cageSize,
            List<Integer> exclude) {

        List<List<Integer>> combinations = new ArrayList<>();

        generateCombinations(
                cageSum,
                cageSize,
                exclude,
                1,
                new ArrayList<>(),
                combinations
        );

        Collections.sort(combinations, (a, b) -> {
            for (int i = 0; i < a.size(); i++) {
                if (!a.get(i).equals(b.get(i))) {
                    return a.get(i) - b.get(i);
                }
            }
            return 0;
        });

        return combinations;
    }

    List<List<Integer>> combinationsInCage(
            Integer cageSum,
            Integer cageSize) {

        return combinationsInCage(
                cageSum,
                cageSize,
                new ArrayList<>()
        );
    }

    private void generateCombinations(
            int cageSum,
            int cageSize,
            List<Integer> exclude,
            int start,
            List<Integer> current,
            List<List<Integer>> combinations) {

        if (current.size() == cageSize) {

            int sum = 0;

            for (Integer number : current) {
                sum += number;
            }

            if (sum == cageSum) {
                combinations.add(new ArrayList<>(current));
            }

            return;
        }

        for (int number = start; number <= 9; number++) {

            if (exclude.contains(number)) {
                continue;
            }

            if (current.contains(number)) {
                continue;
            }

            current.add(number);

            generateCombinations(
                    cageSum,
                    cageSize,
                    exclude,
                    number + 1,
                    current,
                    combinations
            );

            current.remove(current.size() - 1);
        }
    }
}
