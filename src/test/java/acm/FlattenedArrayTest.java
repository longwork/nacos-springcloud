package acm;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/12 16:10
 */
public class FlattenedArrayTest {
    //private static final Scanner CIN = new Scanner(System.in);

    @Test
    public void test1() {
//        while (CIN.hasNext()) {
//            List<String> numList = new ArrayList<>();
//            int n = CIN.nextInt();
//            int temp;
//            for (int i = 0; i < n; i++) {
//                temp = CIN.nextInt();
//                numList.add(String.valueOf(temp));
//            }
//
//            Runtime r = Runtime.getRuntime();
//            r.gc();
//            long startMemory = r.freeMemory();
//            long startTime = System.currentTimeMillis();
//
//            sortList(numList);
//
//            long endTime = System.currentTimeMillis();
//            long endMemory = r.freeMemory();
//
//            System.out.println((endTime - startTime) / 1000.0);
//            System.out.println((startMemory - endMemory) / 1000.0);
//        }
//        CIN.close();
    }

    @Test
    public void test2() {
//        while (CIN.hasNext()) {
//            int n = CIN.nextInt();
//            String[] strings = new String[n];
//            int temp;
//            for (int i = 0; i < n; i++) {
//                temp = CIN.nextInt();
//                strings[i] = String.valueOf(temp);
//            }
//            Runtime r = Runtime.getRuntime();
//            r.gc();
//
//            long startMemory = r.freeMemory();
//            long startTime = System.currentTimeMillis();
//
//            sortArray(strings);
//            long endTime = System.currentTimeMillis();
//            long endMemory = r.freeMemory();
//
//            System.out.println((endTime - startTime) / 1000.0);
//            System.out.println((startMemory - endMemory) / 1000.0);
//        }
//        CIN.close();
    }

    private static void sortList(List<String> numList) {
        System.out.println(
                numList.stream()
                        .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1))
                        .collect(Collectors.joining())
        );
    }

    private static void sortArray(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = 0; j < strings.length - i - 1; j++) {
                String s1 = strings[j] + strings[j + 1];
                String s2 = strings[j + 1] + strings[j];
                if (s1.compareTo(s2) > 0) {
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string);
        }
        System.out.println(sb);
    }
}
