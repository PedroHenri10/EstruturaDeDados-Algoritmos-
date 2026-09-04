class ReverseString {

    String reverse(String inputString) {
        final StringBuilder reverseBuilder = new StringBuilder(inputString.length());

        for(int i = inputString.length() -1; i>=0; i--){
            char c = inputString.charAt(i);

            reverseBuilder.append(c);
        }

        return reverseBuilder.toString();
    }
  
}

/*
public class ReverseString {

    public String reverse(final String inputString) {
        if (inputString == null) {
            return ""; 
        }

        return new StringBuilder(inputString).reverse().toString();
    }
}

*/
