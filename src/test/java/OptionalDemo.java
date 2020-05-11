import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/11 9:32
 */
public class OptionalDemo {

    @Test
    public void demo1() {
        User user = new User();
        user.setId(18);
        user.setName("龙龙");

        Optional<User> optional = Optional.of(user);

        Assert.assertNotNull(optional);

        // 校验id是否为null
        Integer integer = optional.map(User::getId).orElseThrow(() -> new RuntimeException("id为空"));
        Assert.assertNotNull(integer);

        // 校验name是否为null
        User user2 = optional.filter(user1 -> StringUtils.isNotBlank(user1.getName())).orElseThrow(() -> new RuntimeException("名字不能为空"));
        Assert.assertNotNull(user2);
    }

    @Test
    public void demo2() {
        User user = new User();

        Optional<User> optionalUser = Optional.of(user);
        Assert.assertNotNull(optionalUser);

        // 获取默认值
        String anElse = optionalUser.map(User::getName).orElse("默认名字");
        Assert.assertEquals(anElse, "默认名字");

        // optionalUser为空就获取另一个
        // optionalUser = Optional.empty();
        User orElseGet = optionalUser.orElseGet(() -> new User(22, "龙龙"));
        Assert.assertNotNull(orElseGet);
        System.out.println(orElseGet);

        // 存在做姓名+123 操作
        optionalUser.ifPresent(u -> u.setName(u.getName() + "123"));

        // 不存在返回一个默认值
        List<String> list = optionalUser.map(User::getMoneyList).orElse(Collections.emptyList());
        Assert.assertNotNull(list);

        System.out.println(optionalUser);

    }

    @Test
    public void demo3() {
        User user3 = new User(15, "程程", "大");
        Optional<User> user = Optional.of(user3);

        user.filter(u -> StringUtils.isNotBlank(u.getName()))
                .filter(u -> StringUtils.isNotBlank(u.getLocation()))
                .map(User::getId).orElseThrow(() -> new RuntimeException("user中属性不能为空"));

        Assert.assertNotNull(user);
        System.out.println(user);
    }

    @Test
    public void demo4() {
        Optional<Object> optional = Optional.empty();
        try {
            optional.orElseThrow(() -> {
                throw new RuntimeException("1212");
            });
        } catch (RuntimeException e) {
            System.out.println("该值为空");
            e.printStackTrace();
        }
    }

    @Test
    public void demo5() {
        Student u1 = new Student(18, 80, "long");
        Student u2 = new Student(20, 90, "wen");
        Student u3 = new Student(27, 50, "chao");
        List<Student> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);

        for (Student student : list) {
            // user为null，会报NullPointException
            Optional<Student> optional = Optional.of(student);
            Integer integer = optional.filter(o1 -> o1.getAge() >= 18).map(Student::getScore).orElse(0);
            if (integer >= 80) {
                System.out.println("被选中的名字：" + student.getName());
            }
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        private Integer id;
        private String name;
        private String location;
        private List<String> moneyList;

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public User(Integer id, String name, String location) {
            this.id = id;
            this.name = name;
            this.location = location;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Student {
        private Integer age;
        private Integer score;
        private String name;
    }
}
