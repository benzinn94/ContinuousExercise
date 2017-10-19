package is.ru.hugb.calc;

import java.util.stream.Stream;

public class StringCalculator {
    public int add(String input) {
        int sum = 0;
        if (input.equals("")) {
            return 0;
        }
        else if (input.contains(",")) {
            Integer[] numbers = Stream.of(input.split(",|\\n"))
                .map(Integer::valueOf).toArray(Integer[]::new);
            for (int number : numbers) {
                sum += number;
            }
            return sum;
        }
        return Integer.parseInt(input);
    }
}
