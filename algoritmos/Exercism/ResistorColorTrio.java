import java.util.Map;

class ResistorColorTrio {
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
            "white", 9);

    String label(String[] colors) {
        int dezenas = colorCodes.get(colors[0]);
        int unidades = colorCodes.get(colors[1]);

        int label = (dezenas * 10) + unidades;
        int zeros = colorCodes.get(colors[2]);

        long valor = label;

        for (int i = 0; i < zeros; i++) {
            valor *= 10;
        }

        if (valor >= 1_000_000_000) {
            return (valor / 1_000_000_000) + " gigaohms";
        } else if (valor >= 1_000_000) {
            return (valor / 1_000_000) + " megaohms";
        } else if (valor >= 1_000) {
            return (valor / 1_000) + " kiloohms";
        } else {
            return valor + " ohms";
        }
    }
}
