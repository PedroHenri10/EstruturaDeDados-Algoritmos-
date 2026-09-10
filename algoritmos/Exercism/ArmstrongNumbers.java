class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        String texto =  String.valueOf(numberToCheck);
        int soma = 0;
        int numeroArmstrong = 0;

        for(int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            String caracterString = String.valueOf(c);
            numeroArmstrong = Integer.parseInt(caracterString);
            soma += Math.pow(numeroArmstrong, texto.length());
        }

        if(soma == numberToCheck){
            return true;
        }else {
            return false;
        }

    }

}
/*
public class ArmstrongNumbers {

    public boolean isArmstrongNumber(int numberToCheck) {
        String digits = String.valueOf(numberToCheck);
        int power = digits.length();
        int sum = 0;

        for (int i = 0; i < power; i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            sum += (int) Math.getExponent(digit); 
        }

        return sum == numberToCheck;
    }
}

*/
