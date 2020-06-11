package pers.demo.enterprise.service;

import com.alibaba.fastjson.JSONReader;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.stereotype.Service;
import pers.demo.enterprise.beans.EnterpriseBean;
import pers.demo.enterprise.beans.EnterpriseListBean;

import java.io.*;
import java.util.ArrayList;
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
    public List<EnterpriseBean> parseBeanFromJsonAndSave(String jsonPath) {
        List<EnterpriseBean> enterpriseBeans = new ArrayList<>();
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
            EnterpriseListBean enterpriseListBean = jsonReader.readObject(EnterpriseListBean.class);
            enterpriseBeans.addAll(enterpriseListBean.getErDataList());
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return enterpriseBeans;
    }
}
