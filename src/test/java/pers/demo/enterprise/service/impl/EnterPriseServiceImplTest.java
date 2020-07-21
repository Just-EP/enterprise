package pers.demo.enterprise.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.demo.enterprise.service.EnterPriseService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/10 23:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnterPriseServiceImplTest {

    @Resource(name = "serviceMySql")
    private EnterPriseService service;

    @Test
    public void parseBeanFromJson() {
//        String path = "D:\\资料\\Enterprise-Registration-Data-of-Chinese-Mainland-json\\Enterprise-Registration-Data\\json";
        String path = "D:\\资料\\Enterprise-Registration-Data-of-Chinese-Mainland-json\\Enterprise-Registration-Data\\error";
        Boolean aBoolean = service.parseBeanFromJsonAndSave(path);
        System.out.println(aBoolean);
    }
    @Test
    public void testCreateEnterPriseTables(){
        List<String> years = new ArrayList<>();
        for (int i = 1978; i < 2020; i++) {
            years.add(i+"");
        }
        String main = "base_enterprise_test";
        service.createEnterPriseTables(years,main);
    }
}