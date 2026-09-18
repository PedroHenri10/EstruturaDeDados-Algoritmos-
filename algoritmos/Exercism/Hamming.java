public class Hamming {
    private String leftStrand;
    private String rigthStrand;

    public Hamming(String leftStrand, String rightStrand) {
        this.leftStrand = leftStrand.toUpperCase();
        this.rigthStrand = rightStrand.toUpperCase();
         if(leftStrand.length() != rigthStrand.length()){
            throw new IllegalArgumentException("strands must be of equal length");
        }
    }

    public int getHammingDistance() {

        int contador = 0;
        for(int i = 0; i<leftStrand.length(); i++){
            if(leftStrand.charAt(i) != rigthStrand.charAt(i)){
                contador++;
            }
        }
        return contador;
    }
}
