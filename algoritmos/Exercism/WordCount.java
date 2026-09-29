

import java.util.HashMap;
import java.util.Map;

class WordCount {
    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> countWords = new HashMap<>();

        String[] words = input.toLowerCase().split("([^a-zA-Z0-9']|(?<![a-zA-Z])'|'(?![a-zA-Z]))+");

        for(String word: words){
            if(word != null && !word.trim().isEmpty()) {
                countWords.merge(word, 1, Integer::sum);
            }
        }
        return countWords;
    }
}

/*
import java.util.HashMap;
import java.util.Map;

class WordCount {

    public Map<String, Integer> phrase(String input) {
        Map<String, Integer> wordCounts = new HashMap<>();

        String normalizedInput = input.toLowerCase();
        String[] words = normalizedInput.split(
                "([^a-zA-Z0-9']|(?<![a-zA-Z])'|'(?![a-zA-Z]))+"
        );

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.merge(word, 1, Integer::sum);
            }
        }

        return wordCounts;
    }
}
*/
