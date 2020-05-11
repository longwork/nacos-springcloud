package wimi.nacos.springboot;

import java.util.Scanner;

/**
 * @author Long WenChao
 * @date 2020-04-24 16:52 周五
 */
public class ConversionUrl2831 {
    static Scanner in = new Scanner(System.in);
    private static final String REGEX = "\\.";
    private static final int LENGTH = 8;

    public static void main(String[] args) {
        while (in.hasNext()) {
            String str = in.next();
            conversionUrl(str);
        }
    }

    private static void conversionUrl(String str) {
        String[] split = str.split(REGEX);
        if (split.length == 1) {
            Integer x1 = Integer.valueOf(str.substring(0, 8), 2);
            Integer x2 = Integer.valueOf(str.substring(8, 16), 2);
            Integer x3 = Integer.valueOf(str.substring(16, 24), 2);
            Integer x4 = Integer.valueOf(str.substring(24, 32), 2);
            System.out.println(x1 + "." + x2 + "." + x3 + "." + x4);
        } else {
            StringBuilder sb = new StringBuilder();
            for (String value : split) {
                StringBuilder s = new StringBuilder(Integer.toBinaryString(Integer.parseInt(value)));
                for (int i = s.length(); i < LENGTH; i++) {
                    s.insert(0, "0");
                }
                sb.append(s);
            }
            System.out.println(sb.toString());
        }
    }
}
