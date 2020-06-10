package pers.demo.enterprise.service;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.stereotype.Service;
import pers.demo.enterprise.beans.EnterpriseBean;

import java.io.File;
import java.util.Collection;
import java.util.List;

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
            String absolutePath = file.getAbsolutePath();
            System.out.println(absolutePath);
        }
        return null;
    }
}
