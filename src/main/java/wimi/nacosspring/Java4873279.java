package wimi.nacosspring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Administrator
 */
public class Java4873279 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(100);
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String s = cin.next();
            int len = s.length();
            for (int j = 0; j < len; j++) {
                char c = s.charAt(j);
                if (c != '-') {
                    int nul;
                    if (c >= '0' && c <= '9') {
                        nul = (c - '0');
                    } else {
                        nul = getNum(c);
                    }
                    sb.append(nul);
                }
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        boolean ok = false;
        for (Object st : keys) {
            String s = (String) st;
            if (map.get(s) > 1) {
                ok = true;
                System.out.println(s.substring(0, 3) + "-" + s.substring(3) + " " + map.get(s));
            }
        }
        if (!ok) {
            System.out.println("No duplicates.");
        }
    }

    private static int getNum(char c) {
        char a1 = 'A', c1 = 'C', d1 = 'D', f1 = 'F';
        char g1 = 'G', i1 = 'I', j1 = 'J', l1 = 'L';
        char m1 = 'M', o1 = 'O', p1 = 'P', s1 = 'S';
        char t1 = 'T', v1 = 'V';
        if (c >= a1 && c <= c1) {
            return 2;
        } else if (c >= d1 && c <= f1) {
            return 3;
        } else if (c >= g1 && c <= i1) {
            return 4;
        } else if (c >= j1 && c <= l1) {
            return 5;
        } else if (c >= m1 && c <= o1) {
            return 6;
        } else if (c >= p1 && c <= s1) {
            return 7;
        } else if (c >= t1 && c <= v1) {
            return 8;
        } else {
            return 9;
        }
    }
}
