package wimi.nacos.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class IdCardSort {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        r.gc();
        long startMem = r.freeMemory();
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        List<String> list = new ArrayList<>(n);
        while (n-- > 0) {
            list.add(cin.next());
        }
        list.sort((o1, o2) -> {
            if (o1.equals(o2)) {
                o1 = o1.substring(6, 14);
                o2 = o2.substring(6, 14);
            }
            return -o1.compareTo(o2);
        });
        list.forEach(System.out::println);
        long orz = r.freeMemory();
        System.out.println((startMem - orz) / 1048576.0);
        cin.close();
    }
}
