import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Long WenChao
 * @date 2020-04-23 14:17 周四
 */
public class FloatingPointTest {
    @Test
    public void main() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);
        Assert.assertEquals(x, y);
    }
}
