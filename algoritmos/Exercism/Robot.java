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
/*
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Robot {
    private static final Set<String> USED_NAMES = new HashSet<>();
    private static final Random RANDOM = new Random();

    private String name;

    String getName() {
        if (name == null) {
            name = generateUniqueName();
        }

        return name;
    }

    private String generateUniqueName() {
        String candidate;

        do {
            candidate = generateRandomName();
        } while (USED_NAMES.contains(candidate));

        USED_NAMES.add(candidate);
        return candidate;
    }

    private String generateRandomName() {
        char first = (char) ('A' + RANDOM.nextInt(26));
        char second = (char) ('A' + RANDOM.nextInt(26));
        int number = RANDOM.nextInt(900) + 100;

        return String.format("%c%c%03d", first, second, number);
    }

    void reset() {
        USED_NAMES.remove(name);
        name = null;
    }
}*/
