package wimi.nacos.springboot.rule;

/**
 * @author Long
 * @date 15:10 2020-04-21 周二
 */
public class StaticCode {
    static String prior = "done";
    static String last = !f() ? g() : prior;

    private static boolean f() {
        return true;
    }

    private static String g() {
        return "hello world";
    }

    static {
        System.out.println(last);
        String g = StaticCode.g();
        System.out.println(g);
    }

    public static void main(String[] args) {

    }
}
