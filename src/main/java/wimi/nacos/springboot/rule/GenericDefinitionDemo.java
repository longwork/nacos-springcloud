package wimi.nacos.springboot.rule;

/**
 * @author Long
 * @date 15:29 2020-04-21 周二
 */
public class GenericDefinitionDemo<T> {
    static <String, T> T get(T alibaba) {
        return alibaba;
    }

    public static void main(String[] args) {
        Integer first = 222;
        Long second = 333L;
        Integer integer = get(first);
        System.out.println(integer);
    }
}
