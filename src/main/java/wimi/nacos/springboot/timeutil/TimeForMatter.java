package wimi.nacos.springboot.timeutil;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author : wenchao.long
 * @date : Created in 2020/05/12 10:22
 */
public class TimeForMatter {
    public static void main(String[] args) {
        String str = "2019-10-10";
        LocalDate localDate = LocalDate.parse(str);
        System.out.println(localDate);

        String s1 = "2019-10-10 00:00:00";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localeDateTime = LocalDateTime.parse(s1, df);
        System.out.println(localeDateTime);

        ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
        Date date = Date.from(zonedDateTime.toInstant());
        System.out.println(date);

        LocalDateTime localDateTime = date.toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        System.out.println(localDateTime);
    }
}
