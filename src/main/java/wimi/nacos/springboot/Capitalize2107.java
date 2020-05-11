package wimi.nacos.springboot;

import java.util.Scanner;

/**
 * @author Long WenChao
 * @date 2020-04-23 16:46 周四
 */
public class Capitalize2107 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNext()) {
            String str = in.nextLine();
            capitalize(str);
        }
    }

    private static void capitalize(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length-1; i++) {
            boolean flag1 = chars[i] >= 'a' && chars[i] <= 'z';
            boolean flag2 = chars[i + 1] >= 'a' && chars[i + 1] <= 'z';
            boolean flag3 = i > 0 && chars[i - 1] == ' ' && chars[i + 1] == ' ';
            boolean flag = flag1 && flag2 || flag3;
            if (flag) {
                chars[i] -= 32;
            }
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
    }
}
