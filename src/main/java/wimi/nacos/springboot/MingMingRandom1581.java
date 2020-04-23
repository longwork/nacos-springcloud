package wimi.nacos.springboot;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author 17495
 */
public class MingMingRandom1581 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<Integer> set = new TreeSet<>();
        int n = in.nextInt();
        while (n-- > 0) {
            set.add(in.nextInt());
        }
        System.out.println(set.size());
        boolean flag = true;
        for (Integer integer : set) {
            if (flag) {
                flag = false;
            } else {
                System.out.print(" ");
            }
            System.out.print(integer);
        }
        System.out.println();
        in.close();
    }
}
