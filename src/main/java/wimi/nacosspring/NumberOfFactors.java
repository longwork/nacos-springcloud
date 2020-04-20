package wimi.nacosspring;

import java.util.*;

/**
 * @author Long
 * @date 17:21 2020-04-20 周一
 */
public class NumberOfFactors {
    static Scanner in = new Scanner(System.in);
    static List<Integer> primer = new LinkedList<>();

    static {
        primer.addAll(Arrays.asList(2, 3, 5, 7));
        for (int i = 11; i < 100; i += 2) {
            if (i % 3 != 0 && i % 5 != 0 && i % 7 != 0) {
                primer.add(i);
            }
        }
    }

    public static void main(String[] args) {
        int n = in.nextInt();
        long temp = 1;
        for (Integer x : primer) {
            int t = x;
            long s = 0;
            while (t <= n) {
                s += n / t;
                t *= x;
            }
            temp *= (s + 1);
        }
        System.out.println(temp);
    }
}
