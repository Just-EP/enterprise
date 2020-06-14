package pers.demo.enterprise.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.demo.enterprise.beans.EnterpriseBean;

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

    @Autowired
    private EnterPriseService service;

    @Test
    public void parseBeanFromJson() {
//        String path = "D:\\资料\\Enterprise-Registration-Data-of-Chinese-Mainland-json\\Enterprise-Registration-Data\\json";
        String path = "D:\\资料\\Enterprise-Registration-Data-of-Chinese-Mainland-json\\Enterprise-Registration-Data\\error";
        List<EnterpriseBean> enterpriseBeans = service.parseBeanFromJsonAndSave(path);
        System.out.println();
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