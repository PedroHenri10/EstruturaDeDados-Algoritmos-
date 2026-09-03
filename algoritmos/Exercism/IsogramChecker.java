import java.util.Arrays;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        String limpa = phrase.toLowerCase().replace(" ", "").replace("-", "");
        
        char[] letras = limpa.toCharArray();

        Arrays.sort(letras);

        for (int i = 0; i < letras.length - 1; i++) {
            if (letras[i] == letras[i + 1]) {
                return false; 
            }
        }
        
        return true; 
    }
}
