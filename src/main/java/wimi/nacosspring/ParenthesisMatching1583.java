package wimi.nacosspring;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Long
 * @date 17:38 2020-04-20 周一
 */
public class ParenthesisMatching1583 {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        while (in.hasNext()) {
            String str = in.next();
            if (matches(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        out.close();
        in.close();
    }

    private static boolean matches(String str) {
        if ((str.length() & 1) != 0) {
            return false;
        }
        String s1 = str.substring(0, 1);
        String regex = "[(\\[{]";
        if (!s1.matches(regex)) {
            return false;
        }
        String[] arr = str.split("");
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if ("{".equals(s) || "(".equals(s) || "[".equals(s)) {
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
        String s1 = "{";
        String s2 = "(";
        if (s1.equals(str)) {
            return "}";
        } else if (s2.equals(str)) {
            return ")";
        } else {
            return "]";
        }
    }
}
