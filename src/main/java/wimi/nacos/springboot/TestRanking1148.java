package wimi.nacos.springboot;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Long
 * @date 16:18 2020-04-21 周二
 */
public class TestRanking1148 {
    static Scanner in = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int m = in.nextInt(), n = in.nextInt();
        List<Score> list = new LinkedList<>();
        while (in.hasNext()) {
            int sum = 0, a = 0;
            String[] arr = in.nextLine().split("\\s+");
            for (int i = 1; i < arr.length; i++) {
                if (!arr[i].contains("(")) {
                    if (Integer.parseInt(arr[i]) <= 0) {
                        ++a;
                    }
                } else if (arr[i].contains("(") || arr[i].contains(")")) {
                    int x = arr[i].indexOf("(");
                    int y = arr[i].indexOf(")");
                    String s1 = arr[i].substring(x + 1, y);
                    String s2 = arr[i].substring(0, x);
                    int num1 = Integer.parseInt(s1);
                    int num2 = Integer.parseInt(s2);
                    sum += (num1 * n + num2);
                } else if (!(arr[i].contains("-") || arr[i].contains("("))) {
                    sum += Integer.parseInt(arr[i]);
                }
            }
            list.add(new Score(arr[0], (m - a), sum));
        }
        in.close();
        list.sort((o1, o2) -> {
            int a = o2.ac - o1.ac;
            if (a != 0) {
                return a;
            }
            int t = o1.time - o2.time;
            if (t != 0) {
                return t;
            }
            return o1.name.compareTo(o2.name);
        });
        for (Score s : list) {
            if (s.name.length() == 0) {
                continue;
            }
            out.println(s);
        }
        out.close();
    }

    private static class Score {
        private final String name;
        private final int ac;
        private final int time;

        public Score(String name, int ac, int time) {
            this.name = name;
            this.ac = ac;
            this.time = time;
        }

        @Override
        public String toString() {
            return String.format("%-10s %2d %4d",
                    this.name, this.ac, this.time);
        }
    }
}
