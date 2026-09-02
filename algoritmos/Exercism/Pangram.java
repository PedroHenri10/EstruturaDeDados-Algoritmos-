import java.util.HashSet;

import java.util.Set;
 
public class Pangram {

    public boolean isPangram(String sentence) {

        Set<Character> letrasUnicas = new HashSet<>();

        for (char c : sentence.toLowerCase().toCharArray()) {

            if (Character.isLetter(c)) {

                letrasUnicas.add(c);

            }

        }

        return letrasUnicas.size() == 26;

    }

}

 
