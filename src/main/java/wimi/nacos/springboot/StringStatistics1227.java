package wimi.nacos.springboot;

import java.util.Scanner;

/**
 * @author Long
 * @date 2020-04-19 19:27:32 周日
 */
public class StringStatistics1227 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            String str = in.next();
            char[] chars = str.toCharArray();
            int tot = 0;
            for (char c : chars) {
                int i = c - '0';
                if (i >= 0 && i <= 9) {
                    ++tot;
                }
            }
            System.out.println(tot);
        }
        in.close();
    }
}
