import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Robot {
    private String name;
    private static final Set<String> USED_NAMES = new HashSet<>();

    String getName() {

        if (name != null) {
            return name;
        }

        do {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            char firstLetter = (char) ('a' + random.nextInt(26));
            char secondLetter = (char) ('a' + random.nextInt(26));
            int randomNumber = random.nextInt(900) + 100;

            name = sb.append(firstLetter)
                    .append(secondLetter)
                    .append(randomNumber)
                    .toString()
                    .toUpperCase();

        } while (USED_NAMES.contains(name));

        USED_NAMES.add(name);
        return name;

    }

    void reset() {
        USED_NAMES.remove(name);
        name = null;
    }

}
