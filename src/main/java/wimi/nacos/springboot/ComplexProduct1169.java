package wimi.nacos.springboot;

import java.util.Scanner;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/12 17:00
 */
public class ComplexProduct1169 {
    private static final Scanner CIN = new Scanner(System.in);

    public static void main(String[] args) {
        int a = CIN.nextInt();
        int b = CIN.nextInt();
        int c = CIN.nextInt();
        int d = CIN.nextInt();
        if (a == c && b == d) {
            System.out.println((a * a - b * b) + " " + (2 * a * b));
        } else if (a == c && b + d == 0) {
            System.out.println((a * a + b * b) + " " + 0);
        } else if (a + c == 0 && d == b) {
            System.out.println(-(a * a + b * b) + " " + 0);
        } else {
            System.out.println((a * c - b * d) + " " + (c * b + a * d));
        }
        CIN.close();
    }
}
