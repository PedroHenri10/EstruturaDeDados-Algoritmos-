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
