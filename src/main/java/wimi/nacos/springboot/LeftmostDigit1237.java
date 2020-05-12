package wimi.nacos.springboot;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/12 17:22
 */
public class LeftmostDigit1237 {
    private static final Scanner CIN = new Scanner(System.in);

    private static final int MOD = 10;

    public static void main(String[] args) {
        int t = CIN.nextInt();
        while (t-- > 0) {
            int n = CIN.nextInt();
            leftDigit(n);
        }
    }

    private static void leftDigit(int n) {
        if (n % MOD == 0) {
            System.out.println(1);
            return;
        }
        BigInteger bigInteger = new BigInteger("1");
        BigInteger nBig = new BigInteger(String.valueOf(n));
        for (int i = 0; i < n; i++) {
            bigInteger = bigInteger.multiply(nBig);
        }
        System.out.println(bigInteger.toString().substring(0, 1));
    }
}
