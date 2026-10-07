class RomanNumerals {

    private int number;

    RomanNumerals(int number) {
        this.number = number;
    }

    String getRomanNumeral() {

        StringBuilder resultado = new StringBuilder();

        while (number >= 1000) {
            resultado.append("M");
            number -= 1000;
        }

        while (number >= 900) {
            resultado.append("CM");
            number -= 900;
        }

        while (number >= 500) {
            resultado.append("D");
            number -= 500;
        }

        while (number >= 400) {
            resultado.append("CD");
            number -= 400;
        }

        while (number >= 100) {
            resultado.append("C");
            number -= 100;
        }

        while (number >= 90) {
            resultado.append("XC");
            number -= 90;
        }

        while (number >= 50) {
            resultado.append("L");
            number -= 50;
        }

        while (number >= 40) {
            resultado.append("XL");
            number -= 40;
        }

        while (number >= 10) {
            resultado.append("X");
            number -= 10;
        }

        while (number >= 9) {
            resultado.append("IX");
            number -= 9;
        }

        while (number >= 5) {
            resultado.append("V");
            number -= 5;
        }

        while (number >= 4) {
            resultado.append("IV");
            number -= 4;
        }

        while (number >= 1) {
            resultado.append("I");
            number -= 1;
        }

        return resultado.toString();
    }
}
/*
class RomanNumerals {

    private static final int[] VALUES = {
        1000, 900, 500, 400,
        100, 90, 50, 40,
        10, 9, 5, 4, 1
    };

    private static final String[] SYMBOLS = {
        "M", "CM", "D", "CD",
        "C", "XC", "L", "XL",
        "X", "IX", "V", "IV", "I"
    };

    private final int number;

    RomanNumerals(int number) {
        this.number = number;
    }

    String getRomanNumeral() {
        StringBuilder result = new StringBuilder();
        int remaining = number;

        for (int i = 0; i < VALUES.length; i++) {
            while (remaining >= VALUES[i]) {
                result.append(SYMBOLS[i]);
                remaining -= VALUES[i];
            }
        }

        return result.toString();
    }
}
*/
