package wimi.nacosspring;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author : wenchao.long
 * @date : 2020/05/10 19:11:02
 */
public class FlattenedArray3084 {
    private static final Scanner CIN = new Scanner(System.in);

    public static void main(String[] args) {
        while (CIN.hasNext()) {
            int n = CIN.nextInt();
            int temp;
            String[] arr2 = new String[n];
            for (int i = 0; i < arr2.length; i++) {
                temp = CIN.nextInt();
                arr2[i] = String.valueOf(temp);
            }
            String[][] fun = fun(arr2);
            // Arrays.sort(arr2, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
            StringBuilder stringBuilder = new StringBuilder();
            /*for (String s : arr2) {
                stringBuilder.append(s);
            }*/
            for (int i = 0; i < n; i++) {
                stringBuilder.append(fun[i][0]);
            }
            System.out.println(stringBuilder.toString());
        }
        CIN.close();
    }

    private static String[][] fun(String[] arr) {
        Stream<String> stream = Arrays.stream(arr);
        int temp = stream.max(Comparator.comparingInt(String::length)).orElse("").length();
        System.out.println(temp);
        String[][] newArr = new String[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i][0] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            StringBuilder str = new StringBuilder(arr[i]);
            int length = str.length();
            if (str.length() < temp) {
                int tot = temp - length;
                for (int i1 = 0; i1 < tot; i1++) {
                    str.append("9");
                }
            }
            newArr[i][1] = str.toString();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                int t1 = Integer.parseInt(newArr[j][1]);
                int t2 = Integer.parseInt(newArr[j + 1][1]);
                if (t1 > t2) {
                    // 替换第二个值
                    String s1 = newArr[j][1];
                    newArr[j][1] = newArr[j + 1][1];
                    newArr[j + 1][1] = s1;
                    // 替换第一个值
                    String s2 = newArr[j][0];
                    newArr[j][0] = newArr[j + 1][0];
                    newArr[j + 1][0] = s2;
                }
            }
        }
        return newArr;
    }
}
