package wimi.nacos.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Long
 * @date 16:35 2020-04-21 周二
 */
public class DataSort1120 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (in.hasNext()) {
            list.add(in.next());
        }
        list.sort((o1, o2) -> {
            String[] s1 = o1.split("/");
            String[] s2 = o2.split("/");
            int d = Integer.parseInt(s1[2]) - Integer.parseInt(s2[2]);
            if (d != 0) {
                return d;
            }
            d = Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
            if (d != 0) {
                return d;
            }
            return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
        });
        list.forEach(System.out::println);
        in.close();
    }
}
