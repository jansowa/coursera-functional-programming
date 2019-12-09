package examplejava;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FactorialJava {
    final static Function<Integer, Integer> factorial = n ->
            FactorialJava.factorialHelper.apply(1, n);

    private final static BiFunction<Integer, Integer, Integer> factorialHelper =
            (currentProduct, n) ->
                    n == 0 ?
                            currentProduct :
                            FactorialJava.factorialHelper.apply(currentProduct * n, n - 1);

    public static void main(String[] agrs) {
        System.out.println(
                Optional.of(5)
                        .map(factorial)
                        .get()
        );
    }
}
