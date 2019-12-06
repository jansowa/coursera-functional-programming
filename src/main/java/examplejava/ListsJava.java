package examplejava;

import example.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ListsJava {
    final static int sumImperative(List<Integer> intList) {
        int sum = 0;
        for (int i=0; i<intList.size(); i++){
            sum += intList.get(i);
        }
        return sum;
    }

    final static Function<List<Integer>, Integer> sum = (intList) ->
            intList.isEmpty() ?
                    0 : intList.get(0) + ListsJava.sum.apply(intList.subList(1, intList.size()));

    final static Function<List<Integer>, Integer> max = (intList) -> {
        if (intList.isEmpty()) {
            throw new NoSuchElementException();
        }
        return ListsJava.maxHelper.apply(intList.subList(1, intList.size()), intList.get(0));
    };

    final static BiFunction<List<Integer>, Integer, Integer> maxHelper = (intList, currentMax) ->
        intList.isEmpty() ?
            currentMax :
            ListsJava.maxHelper.apply(intList.subList(1, intList.size()), Math.max(intList.get(0), currentMax));
}
