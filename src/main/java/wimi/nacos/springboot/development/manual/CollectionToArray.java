package wimi.nacos.springboot.development.manual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Long WenChao
 * @date 2020-04-23 14:29 周四
 */
public class CollectionToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(2);
        list.add("wimi");
        list.add("development");
        String[] array = list.toArray(new String[0]);
        System.out.println(Arrays.toString(array));
    }
}
