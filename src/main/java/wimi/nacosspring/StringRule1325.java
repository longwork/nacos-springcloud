package wimi.nacosspring;

import java.util.Scanner;

/**
 * @author Long
 * @date 16:28 2020-04-20 周一
 */
public class StringRule1325 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNext()) {
            int n = in.nextInt();
            System.out.println(recursion(n));
        }
    }

    private static String recursion(int n) {
        if (n == 1) {
            return "A";
        } else {
            return recursion(n - 1) + (char) (64 + n) + recursion(n - 1);
        }
    }
}
