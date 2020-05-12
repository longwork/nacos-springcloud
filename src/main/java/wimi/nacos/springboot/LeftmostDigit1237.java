package wimi.nacos.springboot;

import java.util.Scanner;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/12 17:22
 */
public class LeftmostDigit1237 {
    private static final Scanner CIN = new Scanner(System.in);

    public static void main(String[] args) {
        int t = CIN.nextInt();
        while (t-- > 0) {
            int n = CIN.nextInt();
            int tot;
            if (n > 10) {
                tot = n / 10;
            } else {
                tot = n;
            }
            int temp = 1;
            for (int i = 0; i < n; i++) {
                temp = temp * tot;
                if (temp > 100) {
                    temp = temp / 100;
                }
            }
            System.out.println(temp >= 10 ? temp / 10 : temp);
        }
    }
}
