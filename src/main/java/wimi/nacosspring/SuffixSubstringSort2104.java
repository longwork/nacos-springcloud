package wimi.nacosspring;

import java.util.Collections;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/**
 * @author Long
 * @date 16:56 2020-04-20 周一
 */
public class SuffixSubstringSort2104 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        while (in.hasNext()) {
            String str = in.next();
            List<String> list = new ArrayList<>();
            for (int i = str.length() - 1; i >= 0; i--) {
                list.add(str.substring(i));
            }
            Collections.sort(list);
            list.forEach(System.out::println);
        }
        in.close();
    }
}
