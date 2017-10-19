package is.ru.hugb.calc;

import static spark.Spark.*;

public class CalcWeb {
    public static void main(String[] args) {
        get("/", (req, res) -> {
            return "No route specified. Try /add/1,2";
        });
        get(
            "/add/:input",
            (req, res) -> add(req.params(":input"))
        );
    }

    private static int add(String input) {
        StringCalculator Calculator = new StringCalculator();
        return Calculator.add(input);
    }
}
