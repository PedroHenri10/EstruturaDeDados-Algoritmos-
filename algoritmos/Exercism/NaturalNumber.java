

class NaturalNumber {
    private int number;

    NaturalNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    Classification getClassification() {
        if (number == 0) {
            return Classification.DEFICIENT;
        }

        int soma = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                soma += i;
            }
        }

        if (soma > number) {
            return Classification.ABUNDANT;
        } else if (soma == number) {
            return Classification.PERFECT;
        } else {
            return Classification.DEFICIENT;
        }
    }
}
