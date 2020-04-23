import org.junit.Test;

/**
 * @author Long
 * @date 17:15 2020-04-21 周二
 */
public class CodeTest {
    @Test
    public void test() {
        String[] args = {"a", "b"};
        Object obj = args;
        ((String[]) obj)[0] = "object";
    }
}
