package wimi.nacos.springboot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/12 16:34
 */
public class Ranking2118 {
    private static final Scanner CIN = new Scanner(System.in);

    public static void main(String[] args) {
        while (CIN.hasNext()) {
            int n = CIN.nextInt();
            List<Student> list = new ArrayList<>(n);
            Student student;
            for (int i = 0; i < n; i++) {
                String name = CIN.next();
                Integer age = CIN.nextInt();
                Integer score = CIN.nextInt();
                student = new Student(name, age, score);
                list.add(student);
            }
            list.sort(
                    Comparator.comparingInt(Student::getScore)
                            .thenComparing(Student::getName)
                            .thenComparingInt(Student::getAge)
            );
            list.forEach(System.out::println);
        }
    }

    static class Student {
        private final String name;
        private final Integer age;
        private final Integer score;

        public Student(String name, Integer age, Integer score) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Integer getScore() {
            return score;
        }

        @Override
        public String toString() {
            return this.name + " " + this.age + " " + this.score;
        }
    }
}
