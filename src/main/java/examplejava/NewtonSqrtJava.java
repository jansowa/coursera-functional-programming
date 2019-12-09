package examplejava;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class NewtonSqrtJava {
    final static BiFunction<Double, Double, Boolean> isGoodEnough = (guess, x) -> Math.abs(guess * guess - x) / x < 0.001;

    final static BiFunction<Double, Double, Double> improve = (guess, x) -> (guess + x / guess) / 2;

    final static BiFunction<Double, Double, Double> sqrtIter = (guess, x) ->
            isGoodEnough.apply(guess, x) ?
                    guess : NewtonSqrtJava.sqrtIter.apply(improve.apply(guess, x), x);

    final static Function<Double, Double> sqrt = x -> sqrtIter.apply(1.0, x);

    public static void main(String[] args) {
        System.out.println(
                Optional.of(2.0)
                        .map(sqrt)
                        .get()
        );
    }
}