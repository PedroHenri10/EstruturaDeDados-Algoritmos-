class Acronym {
    private String phrase;

    Acronym(String phrase) {
        this.phrase = phrase;
    }

    String get() {
        StringBuilder sb = new StringBuilder();

        String[] palavras = phrase.trim().split("[\\s\\-_]+");

        for(String palavra: palavras){
            char letra = palavra.charAt(0);
            sb.append(letra);
        }

        return sb.toString().toUpperCase();
    }

}
