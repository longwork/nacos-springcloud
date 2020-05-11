package wimi.nacos.springboot.rule;

import java.util.Arrays;
import java.util.List;

/**
 * @author Long
 * @date 17:25 2020-04-21 周二
 */
public class ArraysAsList {
    public static void main(String[] args) {
        String[] stringArray = new String[3];
        stringArray[0] = "one";
        stringArray[1] = "two";
        stringArray[2] = "three";

        List<String> stringList = Arrays.asList(stringArray);

        stringList.set(0, "oneList");

        System.out.println(stringArray[0]);

        stringList.forEach(System.out::println);
    }
}