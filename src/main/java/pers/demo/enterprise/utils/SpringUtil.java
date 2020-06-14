package pers.demo.enterprise.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/13 16:00
 */
@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }
    public static Object getBean(String id) {
        Object object;
        object = applicationContext.getBean(id);
        return object;
    }
}
