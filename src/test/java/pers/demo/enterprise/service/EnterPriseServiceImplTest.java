package pers.demo.enterprise.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/10 23:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnterPriseServiceImplTest {

    @Autowired
    private EnterPriseService service;

    @Test
    public void parseBeanFromJson() {
        String path = "D:\\资料\\Enterprise-Registration-Data-of-Chinese-Mainland-json\\Enterprise-Registration-Data";
        service.parseBeanFromJson(path);
    }
}