package wimi.nacos.springboot.rule;

import java.lang.reflect.Field;

/**
 * @author Long
 * @date 16:40 2020-04-21 周二
 */
public class ClassTest {
    static Class<One> one = One.class;
    static Class<Another> another = Another.class;

    public static void main(String[] args) throws Exception {
        One oneObject = one.newInstance();
        oneObject.call();

        Another anotherObject = another.newInstance();
        anotherObject.speak();

        Field privateFieldInOne = one.getDeclaredField("inner");

        privateFieldInOne.setAccessible(true);

        privateFieldInOne.set(oneObject, "world changed.");

        System.out.println(oneObject.getInner());
    }
}

class One {
    private String inner = "time flies.";

    public void call() {
        System.out.println("hello world.");
    }

    public String getInner() {
        return inner;
    }
}

class Another {
    public void speak() {
        System.out.println("easy coding.");
    }
}
