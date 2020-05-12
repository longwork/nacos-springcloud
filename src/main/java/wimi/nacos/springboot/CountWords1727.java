package wimi.nacos.springboot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Long WenChao
 * @date 2020-04-23 16:23 周四
 */
public class CountWords1727 {
    static Scanner in = new Scanner(System.in);

    public static final String REGEX = "(\\s+|[^a-zA-z])";

    public static void main(String[] args) {
        while (in.hasNext()) {
            String str = in.nextLine();
            countWords(str);
        }
    }

    private static void countWords(String str) {
        str = str.trim();
        String[] split = str.split(REGEX);
        Map<String, Integer> map = new HashMap<>(split.length);
        for (String s : split) {
            s = s.toUpperCase();
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println(m.getKey() + ":" + m.getValue());
        }
    }
}
