class IsbnVerifier {

    boolean isValid(String isbn) {
        String normalizedIsbn = isbn.replace("-", "");

        if (!hasValidFormat(normalizedIsbn)) {
            return false;
        }

        return calculateChecksum(normalizedIsbn) % 11 == 0;
    }

    private boolean hasValidFormat(String isbn) {
        if (isbn.length() != 10) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            if (!Character.isDigit(isbn.charAt(i))) {
                return false;
            }
        }

        char last = isbn.charAt(9);

        return Character.isDigit(last) || last == 'X';
    }

    private int calculateChecksum(String isbn) {
        int sum = 0;

        for (int i = 0; i < isbn.length(); i++) {
            int value = getValue(isbn.charAt(i));
            int weight = 10 - i;

            sum += value * weight;
        }

        return sum;
    }

    private int getValue(char character) {
        if (character == 'X') {
            return 10;
        }

        return Character.getNumericValue(character);
    }
}
