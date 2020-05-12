package wimi.nacos.springboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/08 18:01
 */
public class FlattenedArray3084 {

    private static final Scanner CIN = new Scanner(System.in);

    public static void main(String[] args) {
        while (CIN.hasNext()) {
            List<String> numList = new ArrayList<>();
            int n = CIN.nextInt();
            int temp;
            for (int i = 0; i < n; i++) {
                temp = CIN.nextInt();
                numList.add(String.valueOf(temp));
            }
            sortList(numList);
        }
        CIN.close();
    }

    private static void sortList(List<String> numList) {
        numList.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder sb = new StringBuilder();
        numList.forEach(sb::append);
        System.out.println(sb);
    }
}
