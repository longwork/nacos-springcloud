package wimi.nacos.springboot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Long WenChao
 * @date 2020-04-23 15:59 周四
 */
public class StatisticsOfDifferentWords1658 {
    static Scanner in = new Scanner(System.in);
    private static final String REGEX = "\\s+";

    public static void main(String[] args) {
        while (in.hasNext()) {
            String str = in.nextLine();
            differentWords(str);
        }
        in.close();
    }

    private static void differentWords(String str) {
        str = str.trim();
        String[] split = str.split(REGEX);
        Map<String, Integer> map = new HashMap<>(str.length());
        for (String s : split) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            }
        }
        System.out.println(map.size());
    }
}
