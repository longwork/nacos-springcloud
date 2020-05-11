import org.junit.Test;

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

    interface Converter<T1, T2> {
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
        Converter<Integer, String> stringConverter = o1 -> System.out.println(o1 + num);
        stringConverter.convert(10);
    }
}
