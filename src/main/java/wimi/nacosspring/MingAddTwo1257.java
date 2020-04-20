package wimi.nacosspring;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Long
 * @date 11:31 2020-04-20 周一
 */
public class MingAddTwo1257 {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        String s1 = in.next();
        String s2 = in.next();
        int result = in.nextInt();
        s1 = s1.substring(s1.length() - 1);
        s2 = s2.substring(s2.length() - 1);
        int i1 = Integer.parseInt(s1);
        int i2 = Integer.parseInt(s2);
        int i = (i1 + i2) % 10;
        if (i == result) {
            out.println("YES");
        } else {
            out.println("NO");
        }
        out.close();
        in.close();
    }
}
