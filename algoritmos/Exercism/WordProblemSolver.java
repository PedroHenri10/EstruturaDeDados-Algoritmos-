
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
/*

class WordProblemSolver {

    int solve(String question) {
        if (question == null || !question.startsWith("What is ") || !question.endsWith("?")) {
            throw invalidQuestion();
        }

        String expression = question
                .substring(8, question.length() - 1)
                .trim();

        String[] tokens = expression.split("\\s+");

        if (expression.isEmpty()) {
            throw invalidQuestion();
        }

        int result = parseNumber(tokens[0]);

        for (int i = 1; i < tokens.length;) {
            String operator = tokens[i];
            int numberIndex = i + 1;

            if (operator.equals("multiplied")
                    || operator.equals("divided")) {
                if (numberIndex >= tokens.length
                        || !tokens[numberIndex].equals("by")) {
                    throw invalidQuestion();
                }

                numberIndex++;
            }

            if (numberIndex >= tokens.length) {
                throw invalidQuestion();
            }

            int number = parseNumber(tokens[numberIndex]);

            result = calculate(result, operator, number);

            i = numberIndex + 1;
        }

        return result;
    }

    private int parseNumber(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw invalidQuestion();
        }
    }

    private int calculate(int left, String operator, int right) {
        switch (operator) {
            case "plus":
                return left + right;
            case "minus":
                return left - right;
            case "multiplied":
                return left * right;
            case "divided":
                if (right == 0) {
                    throw invalidQuestion();
                }
                return left / right;
            default:
                throw invalidQuestion();
        }
    }

    private IllegalArgumentException invalidQuestion() {
        return new IllegalArgumentException("I'm sorry, I don't understand the question!");
    }
}

*/
