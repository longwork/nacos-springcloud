package wimi.nacos.springboot;

import java.util.Arrays;

import java.util.Scanner;

/**
 * @author 17495
 */
public class Median1487 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            if (n == 1) {
                System.out.println(String.format("%.2f", n / 1.0));
            } else if (n == 2) {
                int n1 = in.nextInt();
                int n2 = in.nextInt();
                double result = (n1 + n2) / 2.0;
                System.out.println(String.format("%.2f", result));
            } else {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = in.nextInt();
                }
                Arrays.sort(arr);
                int length = arr.length;
                double result;
                if ((length & 1) == 0) {
                    result = (arr[length / 2 - 1] + arr[length / 2]) / 2.0;
                } else {
                    result = arr[length / 2] / 1.0;
                }
                System.out.println(String.format("%.2f", result));
            }
        }
        in.close();
    }
}
