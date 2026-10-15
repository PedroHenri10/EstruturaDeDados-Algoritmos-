
class WordProblemSolver {

    int solve(final String wordProblem) {
        if (wordProblem == null || !wordProblem.startsWith("What is ") || !wordProblem.endsWith("?")) {
            throw invalidQuestion();
        }

        String expression = wordProblem.substring(8, wordProblem.length() - 1).trim();

        if (expression.isEmpty()) {
            throw invalidQuestion();
        }

        String[] arrayString = expression.split("\\s+");

        int result;

        try {
            result = Integer.parseInt(arrayString[0]);
        } catch (NumberFormatException e) {
            throw invalidQuestion();
        }

        for (int i = 1; i < arrayString.length;) {
            String operacao = arrayString[i];
            int posicaoNumero = i + 1;

            if (operacao.equals("multiplied")
                    || operacao.equals("divided")) {

                if (i + 2 >= arrayString.length
                        || !arrayString[i + 1].equals("by")) {
                    throw invalidQuestion();
                }

                posicaoNumero = i + 2;
            }

            if (posicaoNumero >= arrayString.length) {
                throw invalidQuestion();
            }

            int numero;

            try {
                numero = Integer.parseInt(arrayString[posicaoNumero]);
            } catch (NumberFormatException e) {
                throw invalidQuestion();
            }

            switch (operacao) {
                case "plus":
                    result += numero;
                    break;

                case "minus":
                    result -= numero;
                    break;

                case "multiplied":
                    result *= numero;
                    break;

                case "divided":
                    result /= numero;
                    break;

                default:
                    throw invalidQuestion();
            }

            i = posicaoNumero + 1;
        }

        return result;
    }

    private IllegalArgumentException invalidQuestion() {
        return new IllegalArgumentException("I'm sorry, I don't understand the question!");
    }
}
