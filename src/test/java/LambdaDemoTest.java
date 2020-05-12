import org.junit.Test;

import java.util.function.*;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/11 10:55
 */
public class LambdaDemoTest {

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    interface Converter {
        void convert(int i);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    @Test
    public void demo1() {
        //类型声明
        MathOperation addition = Integer::sum;

        // 不用类型声明
        MathOperation subtraction = Integer::sum;

        // 大括号中返回语句
        MathOperation multiplication = Integer::sum;

        System.out.println("10 + 5 = " + new LambdaDemoTest().operate(10, 5, addition));
        System.out.println("10 + 5 = " + new LambdaDemoTest().operate(10, 5, subtraction));
        System.out.println("11 + 4 = " + new LambdaDemoTest().operate(11, 4, multiplication));

        //不用括号
        GreetingService greetingService1 = message -> System.out.println("Hello" + message);

        //用括号
        GreetingService greetingService2 = (message) -> System.out.println("Hello" + message);

        greetingService1.sayMessage("Run");
        greetingService2.sayMessage("Google");
    }

    @Test
    public void demo2() {
        final int num = 10;
        Converter stringConverter = o1 -> System.out.println(o1 + num);
        stringConverter.convert(10);
    }

    @Test
    public void demo3() {
        // Function<T, R> -T作为输入，返回的R作为输出
        Function<String, String> fun = x -> {
            System.out.print(x);
            return "Function";
        };
        System.out.println(": " + fun.apply("hello world"));

        // Predicate<T> -T作为输入，返回的boolean值作为输出
        Predicate<String> pre = o -> {
            System.out.print(o);
            return false;
        };
        System.out.println(": " + pre.test("hello World"));

        //Consumer<T> - T作为输入，执行某种动作但没有返回值
        Consumer<String> con = System.out::println;
        con.accept("hello world");

        //Supplier<T> - 没有任何输入，返回T
        Supplier<String> supp = () -> "Supplier";
        System.out.println(supp.get());

        //BinaryOperator<T> -两个T作为输入，返回一个T作为输出，对于“reduce”操作很有用
        BinaryOperator<String> operator = (o1, o2) -> {
            System.out.print(o1 + " " + o2);
            return "Binary Operator ";
        };
        String result = operator.apply("hello", "world");
        System.out.println("：" + result);
    }
}
