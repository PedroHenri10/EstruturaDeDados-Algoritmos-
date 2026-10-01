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
