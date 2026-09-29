class RunLengthEncoding {

    public String encode(String input) {

    if (input.isEmpty()) {
        return "";
    }

    StringBuilder result = new StringBuilder();

    int count = 1;

    for (int i = 1; i < input.length(); i++) {

        if (input.charAt(i) == input.charAt(i - 1)) {

            count++;

        } else {

            if (count > 1) {
                result.append(count);
            }

            result.append(input.charAt(i - 1));

            count = 1;
        }
    }

    if (count > 1) {
        result.append(count);
    }

    result.append(input.charAt(input.length() - 1));

    return result.toString();
}

    public String decode(String input) {

    StringBuilder result = new StringBuilder();

    int count = 0;

    for (int i = 0; i < input.length(); i++) {

        char current = input.charAt(i);

        if (Character.isDigit(current)) {

            count = count * 10 + Character.getNumericValue(current);

        } else {

            if (count == 0) {
                count = 1;
            }

            for (int j = 0; j < count; j++) {
                result.append(current);
            }

            count = 0;
        }
    }

    return result.toString();
}

}
