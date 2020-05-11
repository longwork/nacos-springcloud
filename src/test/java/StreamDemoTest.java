import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/11 14:38
 */
public class StreamDemoTest {

    @Test
    public void demo1() {
        // 创建无限流，会一直跑下去
        // Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        // iterate.forEach(o -> System.out.print(o + " "));


        // 同样是创建无限流，但是用limit截取 只会输出10次
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(o -> System.out.print(o + " "));
        System.out.println();

        Stream<Integer> limit = Stream.iterate(0, n -> n + 2).limit(10);
        List<Integer> collect = limit.collect(Collectors.toList());
        List<Integer> collect1 = collect.stream().limit(3).collect(Collectors.toList());
        collect.forEach(o -> System.out.print(o + " "));
        System.out.println();
        collect1.forEach(o -> System.out.print(o + " "));
    }

    // collect的使用 stream流中一旦使用collect或者foreach，会结束当前流的操作
    @Test
    public void demo2() {
        String[] arr = {"1", "2", "334", "1564646531", "544"};
        Stream<String> stream = Arrays.stream(arr);

        //stream.collect(Collectors.toList()).forEach(o -> System.out.print(o + " "));

        //stream.collect(Collectors.toSet()).forEach(o -> System.out.print(o + " "));

        //将 集合全部拼接到一块
        //String collect = stream.collect(Collectors.joining());
        //System.out.println(collect); //输出 123341564646531544
        //输出结果开始头为Start--，结尾为--End，中间用拼接符号“||”
        String collect = stream.collect(Collectors.joining("||", "Start--", "--End"));
        System.out.println(collect);

        // 形成一个ArrayList集合在输出
        stream.collect(Collectors.toCollection(ArrayList::new)).forEach(o -> System.out.print(o + " "));

        //stream.collect(Collectors.toUnmodifiableList()).forEach(o -> System.out.print(o + " "));

        //stream.collect(Collectors.toUnmodifiableSet()).forEach(o -> System.out.print(o + " "));
    }

    @Test
    public void demo3() {
        Integer integer = Stream.of(1, 2, 3, 4)
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println(integer);

        // 通过条件分割数组
        Stream.of(1, 2, 3, 4)
                .collect(Collectors.partitioningBy(o -> o % 2 == 0))
                .forEach((key, value) -> System.out.println("key = " + key + ", vale = " + value));

        // 通过条件分组
        Stream.of(1, 2, 3, 4)
                .collect(Collectors.groupingBy(o -> o % 2 == 0))
                .forEach((key, value) -> System.out.println("key = " + key + ", vale = " + value));

    }

    // reduce的使用 归约
    @Test
    public void demo4() {
        Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, Integer::max);
        System.out.println(reduce);

        Integer reduce1 = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        System.out.println(reduce1);
    }

    @Test
    public void demo() {
        List<Integer> collect = Stream.of(16, 43, 45, 23).collect(Collectors.toList());
        sort(collect);

        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        int c = cin.nextInt();
        List<Integer> collect1 = Stream.of(a, b, c).collect(Collectors.toList());
        sort(collect1);

        cin.close();
    }

    public static void sort(List<Integer> numList) {
        List<NumberInfo> list = numList.stream()
                .map(o1 -> new NumberInfo(String.valueOf(o1)))
                .collect(Collectors.toList());

        int maxLength = list.stream()
                .max(Comparator.comparingInt(NumberInfo::numLength))
                .map(NumberInfo::numLength)
                .orElse(0);

        list.forEach(o -> o.convent(maxLength));
        list.sort(Comparator.comparingInt(o -> o.numberWithNine));
        String result = list.stream()
                .map(o -> o.number)
                .collect(Collectors.joining());

        System.out.println(list.isEmpty() ? "0" : result);
    }

    static class NumberInfo {
        String number;
        Integer numberWithNine;

        private int numLength() {
            return this.number.length();
        }

        private void convent(Integer maxLength) {
            String replace = String.format("%-" + maxLength + "s", this.number)
                    .replace(" ", "9");
            this.numberWithNine = Integer.parseInt(replace);
        }

        public NumberInfo(String number) {
            this.number = number;
        }
    }
}
