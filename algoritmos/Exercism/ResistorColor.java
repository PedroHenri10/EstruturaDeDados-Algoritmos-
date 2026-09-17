class ResistorColor {
    final String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

    int colorCode(String color) {
        for(int i = 0; i < colors.length; i++)
            if(color.equals(colors[i])) {
                return i;
            }
        return -1;
    }

    String[] colors() {

        return colors;
    }
}

/*
import java.util.Map;

class ResistorColor {

    private final Map<String, Integer> colorCodes = Map.of(
        "black", 0,
        "brown", 1,
        "red", 2,
        "orange", 3,
        "yellow", 4,
        "green", 5,
        "blue", 6,
        "violet", 7,
        "grey", 8,
        "white", 9
    );

    int colorCode(String color) {
        return colorCodes.get(color);
    }

    String[] colors() {
        return colorCodes.keySet().toArray(new String[0]);
    }
}

enum Color {

    BLACK("black", 0),
    BROWN("brown", 1),
    RED("red", 2),
    ORANGE("orange", 3),
    YELLOW("yellow", 4),
    GREEN("green", 5),
    BLUE("blue", 6),
    VIOLET("violet", 7),
    GREY("grey", 8),
    WHITE("white", 9);

    private final String name;
    private final int code;

    Color(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
*/
