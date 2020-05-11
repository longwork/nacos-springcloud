package wimi.nacos.springboot.rule;

/**
 * @author Long
 * @date 8:53 2020-04-21 周二
 */
public class SwitchString {
    public static void main(String[] args) {
        String s = "sd";

        method(s);
    }

    private static void method(String param) {
        switch (param) {
            case "sth":
                System.out.println("it's sth");
                break;
            case "null":
                System.out.println("it's null");
                break;
            default:
                System.out.println("default");
        }
    }
}
