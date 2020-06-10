package pers.demo.enterprise.utils;

import pers.demo.enterprise.beans.EnterpriseBean;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

/**
 * @author JustEP
 * @version 1.0
 * @createtime 2020/06/09 22:34:00
 */
public class DdlGenerator {
    private static final Properties properties = new Properties();
    static {
        try {
            InputStream resourceAsStream = DdlGenerator.class.getClassLoader().getResourceAsStream("type.properties");
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String generate(Class<EnterpriseBean> clazz){
        StringBuilder ddlSb = new StringBuilder();
        ddlSb.append( "CREATE TABLE 'enterprise'.'enterprise_test' (");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String name = declaredField.getName();
            String typeName = declaredField.getType().getSimpleName();
            String ddlType = (String) properties.get(typeName);
            System.out.println(name);
            System.out.println(typeName);
            System.out.println(ddlType);
        }
        ddlSb.append(");");
        return ddlSb.toString();
    }
}
