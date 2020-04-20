package wimi.nacosspring;

import java.io.PrintWriter;

import java.util.Scanner;

/**
 * @author Long
 * @date 2020-04-19 20:25:24 周日
 */
public class CombinedLanguageLegal1225 {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0) {
            String str = in.nextLine();
            if (match(str)) {
                out.println("yes");
            } else {
                out.println("no");
            }
        }
        out.close();
        in.close();
    }

    private static boolean match(String str) {
        String s = str.substring(0, 1);
        String regex = "[a-zA-z_]";
        if (!s.matches(regex)) {
            return false;
        }
        String[] split = str.split("[0-9a-zA-Z_]");
        return split.length == 0;
    }
}
