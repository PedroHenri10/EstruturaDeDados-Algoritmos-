import java.util.Arrays;
import java.util.stream.Collectors;

class PigLatinTranslator {

    String translate(String phrase) {
        return Arrays.stream(phrase.split(" "))
                .map(this::translateWord)
                .collect(Collectors.joining(" "));
    }

    private String translateWord(String word) {

        if (startsWithVowel(word)
                || word.startsWith("xr")
                || word.startsWith("yt")) {
            return word + "ay";
        }

        int index = 0;

        while (index < word.length()) {

            if (index + 1 < word.length()
                    && word.charAt(index) == 'q'
                    && word.charAt(index + 1) == 'u') {
                index += 2;
                break;
            }

            if (index > 0 && word.charAt(index) == 'y') {
                break;
            }

            if (isVowel(word.charAt(index))) {
                break;
            }

            index++;
        }

        return word.substring(index)
                + word.substring(0, index)
                + "ay";
    }

    private boolean startsWithVowel(String word) {
        return isVowel(word.charAt(0));
    }

    private boolean isVowel(char character) {
        return "aeiou".indexOf(character) >= 0;
    }
}
