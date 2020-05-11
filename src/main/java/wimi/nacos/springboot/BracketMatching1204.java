package wimi.nacos.springboot;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Long WenChao
 * @date 2020-04-23 15:33 周四
 */
public class BracketMatching1204 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        while (n-- > 0) {
            String str = in.next();
            if (matches(str)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean matches(String str) {
        if ((str.length() & 1) != 0) {
            return false;
        }
        String s1 = str.substring(0, 1);
        String regex = "[(\\[]";
        if (!s1.matches(regex)) {
            return false;
        }
        String[] arr = str.split("");
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if ("(".equals(s) || "[".equals(s)) {
                stack.push(s);
            } else {
                String pop = stack.pop();
                String traction = traction(pop);
                if (!traction.equals(s)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String traction(String str) {
        String s1 = "[";
        if (s1.equals(str)) {
            return "]";
        } else {
            return ")";
        }
    }
}
