package wimi.nacos.springboot;

import java.util.Scanner;

/**
 * @author Long WenChao
 * @date 2020-04-24 17:37 周五
 */
public class Knock71313 {
    static Scanner in = new Scanner(System.in);

    private static final String S = "7";
    private static final int N = 7;

    public static void main(String[] args) {
        while (in.hasNext()) {
            int n = in.nextInt();
            contains(n);
        }
    }

    private static void contains(int num) {
        if (num < N) {
            return;
        }
        System.out.println(N);
        for (int i = 8; i <= num; i++) {
            String str = String.valueOf(i);
            if (str.contains(S) || i % N == 0) {
                System.out.println(i);
            }
        }
    }
}
