package wimi.nacos.springboot;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/08 17:18
 */
public class AbsoluteValueSorting1060 {
    private static final Scanner CIN = new Scanner(System.in);

    public static void main(String[] args) {
        while (CIN.hasNext()) {
            int n = CIN.nextInt();
            if (n == 0) {
                return;
            }
            Integer[] arr = new Integer[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = CIN.nextInt();
            }
            Arrays.sort(arr, Comparator.comparingInt(Math::abs));
            boolean flag = false;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (flag) {
                    System.out.print(" ");
                }
                flag = true;
                System.out.print(arr[i]);
            }
            System.out.println();
        }
        CIN.close();
    }
}
