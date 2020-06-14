package pers.demo.enterprise.utils;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalTime;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/06/09 22:37:00
 */
public class DdlGeneratorTest {

    @Test
    public void generate() {
//        String generate = DdlGenerator.generate(EnterpriseBean.class);
//        System.out.println("DDL = " + generate);
        System.out.println(LocalTime.now());
        System.out.println(LocalTime.of(16,0,0));
        Duration between = Duration.between(LocalTime.now(), LocalTime.of(16, 0, 0));
        System.out.println(between.toMillis()/1000.0);

    }
}