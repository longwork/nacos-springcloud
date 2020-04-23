package wimi.nacos.springboot;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 17495
 */
public class AsciiSort1205 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (n-- > 0) {
            String str = in.next();
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            boolean flag = true;
            for (char c : arr) {
                if (flag) {
                    flag = false;
                } else {
                    System.out.print(" ");
                }
                System.out.print(c);
            }
            System.out.println();
        }
        in.close();
    }
}
