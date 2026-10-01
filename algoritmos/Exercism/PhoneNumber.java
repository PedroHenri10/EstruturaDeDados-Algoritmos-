class PhoneNumber {
    private String numberString;

    PhoneNumber(String numberString) {
        numberString = normalizedNumber(numberString);
        this.numberString = numberString;
    }

    String getNumber() {
        return numberString;
    }

    public static String normalizedNumber(String numberString){
        if(numberString.matches(".*[a-zA-Z].*")){
            throw new IllegalArgumentException("letters not permitted");
        }

        if (numberString.matches(".*[^0-9\\s().+-].*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }

        String justNumbers = numberString.replaceAll("\\D", "");

        if(justNumbers.length() < 10){
            throw new IllegalArgumentException("must not be fewer than 10 digits");
        }

        if(justNumbers.length() > 11){
            throw new IllegalArgumentException("must not be greater than 11 digits");
        }

        if(justNumbers.length() == 11 && justNumbers.charAt(0) != '1'){
            throw new IllegalArgumentException("11 digits must start with 1");
        }else if (justNumbers.length() == 11) {
            justNumbers = justNumbers.substring(1);
        }

        if(justNumbers.charAt(0) == '0'){
            throw new IllegalArgumentException("area code cannot start with zero");
        }

        if(justNumbers.charAt(0) == '1'){
            throw new IllegalArgumentException("area code cannot start with one");
        }

        if(justNumbers.charAt(3) == '0'){
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }

        if(justNumbers.charAt(3) == '1'){
            throw new IllegalArgumentException("exchange code cannot start with one");
        }

        return justNumbers;
    }

}

/*
class PhoneNumber {

    private final String number;

    PhoneNumber(String numberString) {
        this.number = normalize(numberString);
    }

    String getNumber() {
        return number;
    }

    private String normalize(String input) {
        validateCharacters(input);

        String digits = removeFormatting(input);

        validateLength(digits);
        digits = removeCountryCode(digits);
        validateAreaCode(digits);
        validateExchangeCode(digits);

        return digits;
    }

    private void validateCharacters(String input) {

        if (input.matches(".*[a-zA-Z].*")) {
            throw new IllegalArgumentException("letters not permitted");
        }

        if (input.matches(".*[^0-9\\s().+-].*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }
    }

    private String removeFormatting(String input) {
        return input.replaceAll("\\D", "");
    }

    private void validateLength(String number) {

        if (number.length() < 10) {
            throw new IllegalArgumentException("must not be fewer than 10 digits");
        }

        if (number.length() > 11) {
            throw new IllegalArgumentException("must not be greater than 11 digits");
        }
    }

    private String removeCountryCode(String number) {

        if (number.length() == 11 && number.charAt(0) != '1') {
            throw new IllegalArgumentException("11 digits must start with 1");
        }

        if (number.length() == 11) {
            return number.substring(1);
        }

        return number;
    }

    private void validateAreaCode(String number) {

        if (number.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }

        if (number.charAt(0) == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
        }
    }

    private void validateExchangeCode(String number) {

        if (number.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }

        if (number.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }
    }
}
*/
