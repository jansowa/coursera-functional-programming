package recfunjava;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

public class RecFunJava {
    final static BiFunction<Integer, Integer, Integer> pascal = (column, row) ->
            column == 0 || row.equals(column)?
                    1 : RecFunJava.pascal.apply(column - 1, row - 1) + RecFunJava.pascal.apply(column, row - 1);

    final static Function<String, Boolean> balance = text -> {
        return RecFunJava.balanceHelper.apply(text, 0);
    };

    private final static BiFunction<String, Integer, Boolean> balanceHelper = (text, openingParenth) -> {
        if (text.length() == 0) {
            if (openingParenth>0)
                return false;
            else
                return true;
        } else if (text.charAt(0) == '(') {
            return RecFunJava.balanceHelper.apply(text.substring(1), openingParenth+1);
        } else if (text.charAt(0) == ')') {
            if (openingParenth==0)
                return false;
            else
                return RecFunJava.balanceHelper.apply(text.substring(1), openingParenth-1);
        } else {
            return RecFunJava.balanceHelper.apply(text.substring(1), openingParenth);
        }
    };

    public static void main(String[] args) {
        System.out.println("Element in pascal triangle with column 4, row 6:");
        System.out.println(
                pascal.apply(4, 6)
        );

        System.out.println("Balance of `(if (zero? x) max (/ 1 x))`:");
        System.out.println(
                balance.apply("(if (zero? x) max (/ 1 x))")
        );
        System.out.println("Balance of '())(':");
        System.out.println(
                balance.apply("())(")
        );
    }
}
