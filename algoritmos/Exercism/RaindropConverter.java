class RaindropConverter {

    String convert(int number) {
        StringBuffer sb = new StringBuffer();
        
        if(number % 3 == 0)
        {
            sb.append("Pling");
        }
        
        if(number % 5 == 0)
        {
            sb.append("Plang");
        }
        
        if(number % 7 == 0)
        {
            sb.append("Plong");
        }
        
        if (sb.length() == 0) {
            return Integer.toString(number);
        }
        
        return sb.toString();
    }

}

/*
import java.util.List;
import java.util.function.IntPredicate;

class RaindropConverter {

    private record Rule(IntPredicate condition, String result) {}

    private static final List<Rule> RULES = List.of(
        new Rule(n -> n % 3 == 0, "Pling"),
        new Rule(n -> n % 5 == 0, "Plang"),
        new Rule(n -> n % 7 == 0, "Plong")
    );

    String convert(int number) {
        StringBuilder result = new StringBuilder();

        for (Rule rule : RULES) {
            if (rule.condition().test(number)) {
                result.append(rule.result());
            }
        }

        return result.length() > 0
            ? result.toString()
            : Integer.toString(number);
    }
}
*/
