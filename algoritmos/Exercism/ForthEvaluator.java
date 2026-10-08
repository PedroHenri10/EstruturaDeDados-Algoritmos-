import java.util.*;

class ForthEvaluator {

    private final Map<String, List<String>> words = new HashMap<>();
    private final Stack<Integer> stack = new Stack<>();

    List<Integer> evaluateProgram(List<String> input) {

        for (String line : input) {

            String[] instructions = line.split(" ");

            for (int i = 0; i < instructions.length; i++) {

                String originalInstruction = instructions[i];
                String instruction = originalInstruction.toUpperCase();

                if (instruction.equals(":")) {

                    String name = instructions[++i].toUpperCase();

                    if (isNumber(name)) {
                        throw new IllegalArgumentException("Cannot redefine numbers");
                    }

                    List<String> definition = new ArrayList<>();

                    i++;

                    while (!instructions[i].equals(";")) {
                        definition.add(instructions[i].toUpperCase());
                        i++;
                    }

                    List<String> resolvedDefinition = new ArrayList<>();

                    for (String word : definition) {
                        if (words.containsKey(word)) {
                            resolvedDefinition.addAll(words.get(word));
                        } else {
                            resolvedDefinition.add(word);
                        }
                    }

                    words.put(name, resolvedDefinition);
                    continue;
                }

                execute(instruction, originalInstruction);
            }
        }

        return new ArrayList<>(stack);
    }

    private void execute(String instruction, String originalInstruction) {

        if (isNumber(instruction)) {
            stack.push(Integer.parseInt(instruction));
            return;
        }

        if (words.containsKey(instruction)) {
            for (String word : words.get(instruction)) {
                execute(word, word);
            }
            return;
        }

        switch (instruction) {
            case "+":
                requireTwoValues(
                    "Addition requires that the stack contain at least 2 values"
                );

                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
                break;

            case "-":
                requireTwoValues(
                    "Subtraction requires that the stack contain at least 2 values"
                );

                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
                break;

            case "*":
                requireTwoValues(
                    "Multiplication requires that the stack contain at least 2 values"
                );

                b = stack.pop();
                a = stack.pop();
                stack.push(a * b);
                break;

            case "/":
                requireTwoValues(
                    "Division requires that the stack contain at least 2 values"
                );

                b = stack.pop();
                a = stack.pop();

                if (b == 0) {
                    throw new IllegalArgumentException("Division by 0 is not allowed");
                }

                stack.push(a / b);
                break;

            case "DUP":
                requireOneValue(
                    "Duplicating requires that the stack contain at least 1 value"
                );

                stack.push(stack.peek());
                break;

            case "DROP":
                requireOneValue(
                    "Dropping requires that the stack contain at least 1 value"
                );

                stack.pop();
                break;

            case "SWAP":
                requireTwoValues(
                    "Swapping requires that the stack contain at least 2 values"
                );

                b = stack.pop();
                a = stack.pop();

                stack.push(b);
                stack.push(a);
                break;

            case "OVER":
                requireTwoValues(
                    "Overing requires that the stack contain at least 2 values"
                );

                b = stack.pop();
                a = stack.peek();

                stack.push(b);
                stack.push(a);
                break;

            default:
                throw new IllegalArgumentException(
                    "No definition available for operator \"" + originalInstruction + "\""
                );
        }
    }

    private boolean isNumber(String value) {
        return value.matches("-?\\d+");
    }

    private void requireOneValue(String message) {
        if (stack.size() < 1) {
            throw new IllegalArgumentException(message);
        }
    }

    private void requireTwoValues(String message) {
        if (stack.size() < 2) {
            throw new IllegalArgumentException(message);
        }
    }
}
/*
import java.util.*;

class ForthEvaluator {

    private final Map<String, List<String>> words = new HashMap<>();
    private final Deque<Integer> stack = new ArrayDeque<>();

    List<Integer> evaluateProgram(List<String> input) {
        for (String line : input) {
            String[] tokens = line.trim().split("\\s+");
            executeTokens(tokens);
        }

        return new ArrayList<>(stack);
    }

    private void executeTokens(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            String instruction = token.toUpperCase();

            if (instruction.equals(":")) {
                i = defineWord(tokens, i);
                continue;
            }

            execute(instruction, token);
        }
    }

    private int defineWord(String[] tokens, int index) {
        String name = tokens[++index].toUpperCase();

        if (isNumber(name)) {
            throw new IllegalArgumentException("Cannot redefine numbers");
        }

        List<String> definition = new ArrayList<>();
        index++;

        while (!tokens[index].equals(";")) {
            definition.add(tokens[index].toUpperCase());
            index++;
        }

        words.put(name, resolve(definition));

        return index;
    }

    private List<String> resolve(List<String> definition) {
        List<String> resolved = new ArrayList<>();

        for (String word : definition) {
            if (words.containsKey(word)) {
                resolved.addAll(words.get(word));
            } else {
                resolved.add(word);
            }
        }

        return resolved;
    }

    private void execute(String instruction, String original) {
        if (isNumber(instruction)) {
            stack.push(Integer.parseInt(instruction));
            return;
        }

        if (words.containsKey(instruction)) {
            for (String word : words.get(instruction)) {
                execute(word, word);
            }
            return;
        }

        executeBuiltIn(instruction, original);
    }

    private void executeBuiltIn(String instruction, String original) {
        switch (instruction) {
            case "+" -> binaryOperation(
                Integer::sum,
                "Addition requires that the stack contain at least 2 values"
            );

            case "-" -> binaryOperation(
                (a, b) -> a - b,
                "Subtraction requires that the stack contain at least 2 values"
            );

            case "*" -> binaryOperation(
                (a, b) -> a * b,
                "Multiplication requires that the stack contain at least 2 values"
            );

            case "/" -> divide();

            case "DUP" -> duplicate();

            case "DROP" -> drop();

            case "SWAP" -> swap();

            case "OVER" -> over();

            default -> throw new IllegalArgumentException(
                "No definition available for operator \"" + original + "\""
            );
        }
    }

    private void binaryOperation(
        BinaryOperator operation,
        String message
    ) {
        require(2, message);

        int b = stack.pop();
        int a = stack.pop();

        stack.push(operation.apply(a, b));
    }

    private void divide() {
        require(
            2,
            "Division requires that the stack contain at least 2 values"
        );

        int b = stack.pop();
        int a = stack.pop();

        if (b == 0) {
            throw new IllegalArgumentException("Division by 0 is not allowed");
        }

        stack.push(a / b);
    }

    private void duplicate() {
        require(
            1,
            "Duplicating requires that the stack contain at least 1 value"
        );

        stack.push(stack.peek());
    }

    private void drop() {
        require(
            1,
            "Dropping requires that the stack contain at least 1 value"
        );

        stack.pop();
    }

    private void swap() {
        require(
            2,
            "Swapping requires that the stack contain at least 2 values"
        );

        int b = stack.pop();
        int a = stack.pop();

        stack.push(b);
        stack.push(a);
    }

    private void over() {
        require(
            2,
            "Overing requires that the stack contain at least 2 values"
        );

        int top = stack.pop();
        int second = stack.peek();

        stack.push(top);
        stack.push(second);
    }

    private void require(int amount, String message) {
        if (stack.size() < amount) {
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isNumber(String value) {
        return value.matches("-?\\d+");
    }

    @FunctionalInterface
    private interface BinaryOperator {
        int apply(int a, int b);
    }
}
*/
