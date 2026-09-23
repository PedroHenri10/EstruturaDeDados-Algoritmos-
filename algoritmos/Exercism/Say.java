class Say {

    private static final String[] ONES = {
        "",
        "one",
        "two",
        "three",
        "four",
        "five",
        "six",
        "seven",
        "eight",
        "nine"
    };

    private static final String[] TEENS = {
        "ten",
        "eleven",
        "twelve",
        "thirteen",
        "fourteen",
        "fifteen",
        "sixteen",
        "seventeen",
        "eighteen",
        "nineteen"
    };

    private static final String[] TENS = {
        "",
        "",
        "twenty",
        "thirty",
        "forty",
        "fifty",
        "sixty",
        "seventy",
        "eighty",
        "ninety"
    };

    String say(long number) {

        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException();
        }

        if (number == 0) {
            return "zero";
        }

        StringBuilder result = new StringBuilder();

        long billions = number / 1_000_000_000;
        number %= 1_000_000_000;

        long millions = number / 1_000_000;
        number %= 1_000_000;

        long thousands = number / 1_000;
        number %= 1_000;

        long hundreds = number;

        if (billions > 0) {
            result.append(sayGroup((int) billions))
                  .append(" billion");
        }

        if (millions > 0) {
            appendSpace(result);
            result.append(sayGroup((int) millions))
                  .append(" million");
        }

        if (thousands > 0) {
            appendSpace(result);
            result.append(sayGroup((int) thousands))
                  .append(" thousand");
        }

        if (hundreds > 0) {
            appendSpace(result);
            result.append(sayGroup((int) hundreds));
        }

        return result.toString();
    }

    private String sayGroup(int number) {

        StringBuilder result = new StringBuilder();

        if (number >= 100) {
            result.append(ONES[number / 100])
                  .append(" hundred");

            number %= 100;

            if (number > 0) {
                result.append(" ");
            }
        }

        if (number >= 20) {
            result.append(TENS[number / 10]);

            number %= 10;

            if (number > 0) {
                result.append("-")
                      .append(ONES[number]);
            }

        } else if (number >= 10) {
            result.append(TEENS[number - 10]);

        } else if (number > 0) {
            result.append(ONES[number]);
        }

        return result.toString();
    }

    private void appendSpace(StringBuilder result) {
        if (result.length() > 0) {
            result.append(" ");
        }
    }
}
