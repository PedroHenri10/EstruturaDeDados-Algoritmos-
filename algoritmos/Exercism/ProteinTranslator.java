import java.util.ArrayList;
import java.util.List;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> aminoAcids = new ArrayList<>();

        int inicio = 0;
        int fim = 3;

        while (inicio < rnaSequence.length()) {

            if (fim > rnaSequence.length()) {
                throw new IllegalArgumentException("Invalid codon");
            }

            String rna = rnaSequence.substring(inicio, fim);

            if (rna.equals("UAA") || rna.equals("UGA") || rna.equals("UAG")) {
                break;
            }

            if (rna.equals("AUG")) {
                aminoAcids.add("Methionine");
            } else if (rna.equals("UUU") || rna.equals("UUC")) {
                aminoAcids.add("Phenylalanine");
            } else if (rna.equals("UUA") || rna.equals("UUG")) {
                aminoAcids.add("Leucine");
            } else if (rna.equals("UCU") || rna.equals("UCC") ||
                       rna.equals("UCA") || rna.equals("UCG")) {
                aminoAcids.add("Serine");
            } else if (rna.equals("UAU") || rna.equals("UAC")) {
                aminoAcids.add("Tyrosine");
            } else if (rna.equals("UGU") || rna.equals("UGC")) {
                aminoAcids.add("Cysteine");
            } else if (rna.equals("UGG")) {
                aminoAcids.add("Tryptophan");
            } else {
                throw new IllegalArgumentException("Invalid codon");
            }

            inicio += 3;
            fim += 3;
        }

        return aminoAcids;
    }
}

/*
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ProteinTranslator {

    private static final Map<String, String> CODON_TO_PROTEIN = Map.ofEntries(
        Map.entry("AUG", "Methionine"),
        Map.entry("UUU", "Phenylalanine"),
        Map.entry("UUC", "Phenylalanine"),
        Map.entry("UUA", "Leucine"),
        Map.entry("UUG", "Leucine"),
        Map.entry("UCU", "Serine"),
        Map.entry("UCC", "Serine"),
        Map.entry("UCA", "Serine"),
        Map.entry("UCG", "Serine"),
        Map.entry("UAU", "Tyrosine"),
        Map.entry("UAC", "Tyrosine"),
        Map.entry("UGU", "Cysteine"),
        Map.entry("UGC", "Cysteine"),
        Map.entry("UGG", "Tryptophan")
    );

    private static final List<String> STOP_CODONS = List.of(
        "UAA", "UAG", "UGA"
    );

    List<String> translate(String rnaSequence) {
        List<String> aminoAcids = new ArrayList<>();

        for (int inicio = 0; inicio < rnaSequence.length(); inicio += 3) {

            if (inicio + 3 > rnaSequence.length()) {
                throw new IllegalArgumentException("Invalid codon");
            }

            String codon = rnaSequence.substring(inicio, inicio + 3);

            if (STOP_CODONS.contains(codon)) {
                break;
            }

            String protein = CODON_TO_PROTEIN.get(codon);

            if (protein == null) {
                throw new IllegalArgumentException("Invalid codon");
            }

            aminoAcids.add(protein);
        }

        return aminoAcids;
    }
}
*/
