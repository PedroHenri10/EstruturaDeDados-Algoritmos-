class LuhnValidator {

    boolean isValid(String input) {

        input = input.replace(" ", "");

        if (input.length() <= 1) {
            return false;
        }

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }

        int sum = 0;
        boolean shouldDouble = false;

        for (int i = input.length() - 1; i >= 0; i--) {

            int digit = Character.getNumericValue(input.charAt(i));

            if (shouldDouble) {
                digit *= 2;

                if (digit > 9) {
                    digit -= 9;
                }
            }

            sum += digit;
            shouldDouble = !shouldDouble;
        }

        return sum % 10 == 0;
    }
}
