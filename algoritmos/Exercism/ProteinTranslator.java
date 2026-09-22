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
