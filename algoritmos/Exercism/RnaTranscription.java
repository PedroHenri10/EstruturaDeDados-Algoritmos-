class RnaTranscription {

    String transcribe(String dnaStrand) {

        StringBuilder dnaBuilder= new StringBuilder();
            
        for(char c: dnaStrand.toUpperCase().toCharArray()){
            switch(c){
                case 'G':
                    dnaBuilder.append('C');
                    break;
                case 'C':
                    dnaBuilder.append('G');
                    break;
                case 'T':
                    dnaBuilder.append('A');
                    break;
                case 'A':
                    dnaBuilder.append('U');
                    break;
                default:
                    break;
            }
        }

        dnaStrand = dnaBuilder.toString();

        return dnaStrand;
    }

}

/*
public class RnaTranscription {
    private static final String VALID_DNA_BASES = "GCTA";

    public String transcribe(final String dnaStrand) {
        if (dnaStrand == null) {
            throw new IllegalArgumentException("A fita de DNA não pode ser nula.");
        }

        final StringBuilder rnaBuilder = new StringBuilder(dnaStrand.length());
            
        for (int i = 0; i < dnaStrand.length(); i++) {
            char currentBase = Character.toUpperCase(dnaStrand.charAt(i));
            
            switch (currentBase) {
                case 'G' -> rnaBuilder.append('C');
                case 'C' -> rnaBuilder.append('G');
                case 'T' -> rnaBuilder.append('A');
                case 'A' -> rnaBuilder.append('U');
                default  -> throw new IllegalArgumentException("Base de DNA inválida encontrada: " + currentBase);
            }
        }

        return rnaBuilder.toString();
    }
}

*/
