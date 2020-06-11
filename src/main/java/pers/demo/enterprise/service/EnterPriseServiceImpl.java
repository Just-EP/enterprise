package pers.demo.enterprise.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.stereotype.Service;
import pers.demo.enterprise.beans.EnterpriseBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/10 23:29
 */
@Service
public class EnterPriseServiceImpl implements EnterPriseService{

    @Override
    public List<EnterpriseBean> parseBeanFromJson(String jsonPath) {
        File jsonFile = new File(jsonPath);
        Collection<File> files = FileUtils.listFiles(jsonFile, TrueFileFilter.TRUE, TrueFileFilter.TRUE);
        for (File file : files) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            JSONReader jsonReader = new JSONReader(Objects.requireNonNull(reader));
            EnterpriseBean enterpriseBean = jsonReader.readObject(EnterpriseBean.class);
            System.out.println(enterpriseBean);
        }
        return null;
    }
}
