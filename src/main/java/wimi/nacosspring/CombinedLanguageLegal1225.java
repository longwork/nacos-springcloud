package wimi.nacosspring;

import java.util.Scanner;

/**
 * @author Long
 * @date 2020-04-19 20:25:24 周日
 */
public class CombinedLanguageLegal1225 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0) {
            String str = in.nextLine();
            char a = str.charAt(0);
            int i = a - '0';
            boolean flag = (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z');
            if (i >= 0 && i <= 9) {
                System.out.println("no");
            } else if (flag || a == '_') {
                String pattern = "[0-9a-zA-z_]";
                String[] split = str.split(pattern);
                if (split.length == 0) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
        in.close();
    }
}
