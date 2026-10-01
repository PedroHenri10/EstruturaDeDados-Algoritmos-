import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BookStore {

    private static final double PRICE = 8.0;

    private static final double[] DISCOUNTS = {
            0.0,
            0.0,
            0.05,
            0.10,
            0.20,
            0.25
    };

    double calculateBasketCost(List<Integer> books) {

        int[] counts = new int[5];

        for (int book : books) {
            counts[book - 1]++;
        }

        return minCost(counts, new HashMap<>());
    }

    private double minCost(int[] counts, Map<String, Double> memo) {

        if (allZero(counts)) {
            return 0.0;
        }

        String key = Arrays.toString(counts);

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        double min = Double.POSITIVE_INFINITY;

        for (int mask = 1; mask < (1 << 5); mask++) {

            int groupSize = Integer.bitCount(mask);

            boolean canForm = true;

            for (int i = 0; i < 5; i++) {

                if ((mask & (1 << i)) != 0 && counts[i] == 0) {
                    canForm = false;
                    break;
                }
            }

            if (!canForm) {
                continue;
            }

            for (int i = 0; i < 5; i++) {

                if ((mask & (1 << i)) != 0) {
                    counts[i]--;
                }
            }

            double groupCost = groupSize * PRICE * (1 - DISCOUNTS[groupSize]);

            double totalCost = groupCost + minCost(counts, memo);

            min = Math.min(min, totalCost);

            for (int i = 0; i < 5; i++) {

                if ((mask & (1 << i)) != 0) {
                    counts[i]++;
                }
            }
        }

        memo.put(key, min);

        return min;
    }

    private boolean allZero(int[] counts) {

        for (int count : counts) {
            if (count > 0) {
                return false;
            }
        }

        return true;
    }
}
