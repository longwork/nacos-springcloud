package wimi.nacos.springboot.java8;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/12 14:44
 */
public class SquareTwo {
    public static void main(String[] args) {
        Arrays.stream(new Integer[]{1, 2, 3, 4})
                .map(
                        ((Function<Integer, Integer>) o -> o * o)
                                .andThen(o -> o * o)
                                .andThen(o -> o + o)
                                .andThen(o -> o * 10)
                )
                .sorted((o1, o2) -> Integer.compare(o2, o1))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
