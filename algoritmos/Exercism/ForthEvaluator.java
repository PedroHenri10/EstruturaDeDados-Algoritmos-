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
