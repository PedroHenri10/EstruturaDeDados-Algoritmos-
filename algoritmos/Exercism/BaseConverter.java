import java.util.ArrayList;
import java.util.List;

class BaseConverter {
    private int originalBase;
    private int[] originalDigits;

    BaseConverter(int originalBase, int[] originalDigits) {
        if (originalBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        for (int digit : originalDigits) {
            if (digit < 0) {
                throw new IllegalArgumentException("Digits may not be negative.");
            }

            if (digit >= originalBase) {
                throw new IllegalArgumentException("All digits must be strictly less than the base.");
            }
        }
        
        this.originalBase = originalBase;
        this.originalDigits = originalDigits;
    }

    int[] convertToBase(int newBase) {
        if (newBase < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }

        int value = 0;
        for (int i = 0; i < originalDigits.length; i++) {
            value = (value * originalBase) + originalDigits[i];
        }

        if (value == 0) {
            return new int[]{0};
        }

        List<Integer> listaDinamica = new ArrayList<>();

        calculateNewBase(value, newBase, listaDinamica);

        return listaDinamica.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void calculateNewBase(int value, int newBase, List<Integer> lista) {
        if (value == 0) {
            return;
        }

        int rest = value % newBase;
        int quotient = value / newBase;

        calculateNewBase(quotient, newBase, lista);

        lista.add(rest);
    }
}

/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class BaseConverter {

    private final int originalBase;
    private final int[] originalDigits;

    BaseConverter(int originalBase, int[] originalDigits) {
        validateBase(originalBase);
        validateDigits(originalBase, originalDigits);

        this.originalBase = originalBase;
        this.originalDigits = originalDigits.clone();
    }

    int[] convertToBase(int newBase) {
        validateBase(newBase);

        int value = toDecimal();

        if (value == 0) {
            return new int[]{0};
        }

        List<Integer> digits = new ArrayList<>();

        while (value > 0) {
            digits.add(value % newBase);
            value /= newBase;
        }

        Collections.reverse(digits);

        return digits.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private int toDecimal() {
        int value = 0;

        for (int digit : originalDigits) {
            value = value * originalBase + digit;
        }

        return value;
    }

    private static void validateBase(int base) {
        if (base < 2) {
            throw new IllegalArgumentException("Bases must be at least 2.");
        }
    }

    private static void validateDigits(int base, int[] digits) {

        for (int digit : digits) {
            if (digit < 0) {
                throw new IllegalArgumentException(
                        "Digits may not be negative."
                );
            }

            if (digit >= base) {
                throw new IllegalArgumentException(
                        "All digits must be strictly less than the base."
                );
            }
        }
    }
}*/
