import org.junit.Test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectionTest {
    /**
     * Name测试
     */
    @Test
    public void NameDetection() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.next();
            String pattern = "[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(str);
            System.out.println(m.matches());
        }
        cin.close();
    }

    /**
     * Email检测
     */
    @Test
    public void EmailDetection() {
        String str = "12@qq.com";
        String pattern = "\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }

    /**
     * 手机号检查
     */
    @Test
    public void PhoneDetection() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.next();
            String pattern = "0?(13|14|15|18|17)[0-9]{9}";

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(str);
            System.out.println(m.matches());
        }
    }

    /**
     * 日期检测
     */
    @Test
    public void BirthDetection() {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String str = cin.next();
//            String pattern = "1\\d-\\d{1,2}-\\d{1,2}";
            String pattern = "0?(20|19)[2-9][0-9]-0?([01])[0-9]-0?([0123])[0-9]";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(str);
            System.out.println(m.matches());
        }
    }


}
