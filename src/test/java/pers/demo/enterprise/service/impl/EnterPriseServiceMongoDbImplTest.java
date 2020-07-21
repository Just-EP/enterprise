package pers.demo.enterprise.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.demo.enterprise.beans.EnterpriseBean;
import pers.demo.enterprise.service.EnterPriseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/21 22:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnterPriseServiceMongoDbImplTest {

    @Resource(name = "serviceMongoDb")
    private EnterPriseService service;
    @Test
    public void parseBeanFromJsonAndSave() {
        String path = "D:\\资料\\Enterprise-Registration-Data-of-Chinese-Mainland-json\\Enterprise-Registration-Data\\error";
        Boolean aBoolean = service.parseBeanFromJsonAndSave(path);
        System.out.println();
    }
    @Test
    public void findEnterPrisesByCondition() {
        List<EnterpriseBean> city = service.findEnterPrisesByCondition("city");
        System.out.println(city);
    }
}