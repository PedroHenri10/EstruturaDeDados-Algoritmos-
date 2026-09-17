import java.util.Map;

class ResistorColorDuo {
    int value(String[] colors) {
         final Map<String, Integer> colorCodes = Map.of(
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
         
        int dezenas = colorCodes.get(colors[0]);
        int unidades = colorCodes.get(colors[1]);

        return (dezenas * 10) + unidades;
    }
}
