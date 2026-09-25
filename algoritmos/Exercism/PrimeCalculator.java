class PrimeCalculator {

    int nth(int nth) {

        if (nth == 0) {
        throw new IllegalArgumentException();
    }
        int contador = 0;
        int primeQtd  = 0;
        int valuePrime = 0;
        
           for(int i = 1;i < 104744; i++){
               for(int j = 1 ; j<=i; j++){
                   if(i % j == 0) {
                       contador++;
                   }
               }
               if(contador == 2){
                   primeQtd ++;
               }
               if(primeQtd == nth){
                   valuePrime = i;
                   break;
               }
               contador =0;
           }
        return valuePrime;
    }

}
