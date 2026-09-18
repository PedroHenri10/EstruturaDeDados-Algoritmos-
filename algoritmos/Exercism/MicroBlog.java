class MicroBlog {
    public String truncate(String input) {
        int quantidade = input.codePointCount(0, input.length());

        if (quantidade <= 5) {
            return input;
        }

        int fim = input.offsetByCodePoints(0, 5);

        return input.substring(0, fim);
    }
}
