package wimi.nacosspring;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Long
 * @date 13:09 2020-04-20 周一
 */
public class EasyCode1267 {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        while (in.hasNext()) {
            String str = in.nextLine();
            if ("END".equals(str)) {
                break;
            }
            transitionString(str);
            System.out.println();
        }
        out.close();
        in.close();
    }

    private static void transitionString(String s) {
        char[] c = s.toCharArray();
        for (char value : c) {
            if (value == 'A' || value == 'W' || value == 'F') {
                out.print("I");
            } else if (value == 'C') {
                out.print("L");
            } else if (value == 'M') {
                out.print("o");
            } else if (value == 'S') {
                out.print("v");
            } else if (value == 'D' || value == 'P' || value == 'G' || value == 'B') {
                out.print("e");
            } else if (value == 'L') {
                out.print("Y");
            } else if (value == 'X') {
                out.print("u");
            } else {
                System.out.printf("%c", value);
            }
        }
    }
}
