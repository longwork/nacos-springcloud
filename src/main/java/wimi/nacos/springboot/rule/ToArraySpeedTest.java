package wimi.nacos.springboot.rule;

import java.util.ArrayList;

import java.util.List;

/**
 * @author Long
 * @date 17:45 2020-04-21 周二
 */
public class ToArraySpeedTest {
    private static final int COUNT = 100 * 100 * 100;

    public static void main(String[] args) {
        List<Double> list = new ArrayList<>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            list.add(i * 1.0);
        }

        long start = System.nanoTime();

        Double[] notEnoughArray = new Double[COUNT - 1];
        list.toArray(notEnoughArray);

        long middle1 = System.nanoTime();

        Double[] equalArray = new Double[COUNT];
        list.toArray(equalArray);

        long middle2 = System.nanoTime();

        Double[] doubleArray = new Double[COUNT * 2];
        list.toArray(doubleArray);

        long end = System.nanoTime();

        long notEnoughArrayTime = middle1 - start;
        long equalArrayTime = middle2 - middle1;
        long doubleArrayTime = end - middle2;

        System.out.println(notEnoughArrayTime / (1000.0 * 1000.0) + "ms");
        System.out.println(equalArrayTime / (1000.0 * 1000.0) + "ms");
        System.out.println(doubleArrayTime / (1000.0 * 1000.0) + "ms");
    }
}
