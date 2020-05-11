package wimi.nacos.springboot.rule;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Long
 * @date 9:02 2020-04-22 周三
 */
public class SubListFailFast {
    public static void main(String[] args) {
        List masterList = new ArrayList<>();

        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        masterList.add("five");

        List branchList = masterList.subList(0, 3);
        branchList.forEach(System.out::println);

        //如下操作会导致branchList操作出现异常
        masterList.remove(0);
        masterList.add("ten");
        masterList.clear();


    }
}
