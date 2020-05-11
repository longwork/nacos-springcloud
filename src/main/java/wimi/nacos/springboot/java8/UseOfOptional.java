package wimi.nacos.springboot.java8;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.Optional;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/11 9:08
 */
public class UseOfOptional {
    public static void main(String[] args) {
        String id = null;
        String name = getName(id);
        String s = Optional.of(name).orElse("123");
        System.out.println(s);

    }

    private static String getName(String name) {
        return Optional.ofNullable(name)
                .filter(StringUtils::isNotBlank)
                .orElse("Unknown");
    }
}
