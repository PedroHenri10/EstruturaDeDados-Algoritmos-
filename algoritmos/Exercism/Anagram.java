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
/*
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class Anagram {

    private final String word;
    private final String normalizedWord;
    private final String sortedWord;

    public Anagram(String word) {
        this.word = word;
        this.normalizedWord = word.toLowerCase(Locale.ROOT);
        this.sortedWord = sortCharacters(normalizedWord);
    }

    public List<String> match(List<String> candidates) {

        List<String> anagrams = new ArrayList<>();

        for (String candidate : candidates) {

            if (word.equalsIgnoreCase(candidate)) {
                continue;
            }

            if (normalizedWord.length() != candidate.length()) {
                continue;
            }

            String sortedCandidate =
                    sortCharacters(candidate.toLowerCase(Locale.ROOT));

            if (sortedWord.equals(sortedCandidate)) {
                anagrams.add(candidate);
            }
        }

        return anagrams;
    }

    private String sortCharacters(String value) {
        char[] characters = value.toCharArray();
        Arrays.sort(characters);
        return new String(characters);
    }
}
*/
