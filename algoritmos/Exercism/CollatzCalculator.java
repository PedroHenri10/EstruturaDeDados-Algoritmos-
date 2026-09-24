class CollatzCalculator {

    int computeStepCount(int start) {

        if (start <= 0) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }

        int steps = 0;
        long number = start;

       while(number != 1){
           if(number % 2 == 0){
               number = number /2;
           }else {
               number = (number * 3) + 1;
           }
           steps++;
       }
       return steps;
    }

}
/*
class CollatzCalculator {

    private static final String INVALID_INPUT_MESSAGE =
            "Only positive integers are allowed";

    int computeStepCount(int start) {
        if (start <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        long number = start;
        int steps = 0;

        while (number != 1) {
            number = isEven(number)
                    ? number / 2
                    : number * 3 + 1;

            steps++;
        }

        return steps;
    }

    private boolean isEven(long number) {
        return number % 2 == 0;
    }
}class CollatzCalculator {

    private static final String INVALID_INPUT_MESSAGE =
            "Only positive integers are allowed";

    int computeStepCount(int start) {
        if (start <= 0) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        long number = start;
        int steps = 0;

        while (number != 1) {
            number = isEven(number)
                    ? number / 2
                    : number * 3 + 1;

            steps++;
        }

        return steps;
    }

    private boolean isEven(long number) {
        return number % 2 == 0;
    }
}
*/
