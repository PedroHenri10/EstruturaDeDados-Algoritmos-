import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Anagram {
    private String word;
    List<String> candidates = new ArrayList<>();
    public Anagram(String word) {
       this.word = word;
    }

    public List<String> match(List<String> candidates) {
        List<String> anagrams = new ArrayList<>();
        for(String candidate : candidates){
            if(word.length() == candidate.length() && !word.equalsIgnoreCase(candidate)){
                char cw[] = word.toLowerCase().toCharArray();
                char cc[] = candidate.toLowerCase().toCharArray();
                Arrays.sort(cw);
                Arrays.sort(cc);
                String cwOrdenardo = new String(cw);
                String ccOrdernado = new String(cc);

                if(cwOrdenardo.equals(ccOrdernado)){
                    anagrams.add(candidate);
                }
            }
        }
        return anagrams;
    }

}
