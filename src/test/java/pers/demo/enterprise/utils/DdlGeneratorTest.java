package pers.demo.enterprise.utils;

import org.junit.Test;
import pers.demo.enterprise.beans.EnterpriseBean;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/06/09 22:37:00
 */
public class DdlGeneratorTest {

    @Test
    public void generate() {
        String generate = DdlGenerator.generate(EnterpriseBean.class);
        System.out.println("DDL = " + generate);
    }
}