package pers.demo.enterprise.service;

import com.alibaba.fastjson.JSONReader;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.demo.enterprise.beans.EnterpriseBean;
import pers.demo.enterprise.beans.EnterpriseListBean;
import pers.demo.enterprise.mapper.EnterpriseMapper;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/10 23:29
 */
@Service
@Slf4j
public class EnterPriseServiceImpl implements EnterPriseService{

    private final EnterpriseMapper mapper;

    @Autowired
    public EnterPriseServiceImpl(EnterpriseMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<EnterpriseBean> parseBeanFromJsonAndSave(String jsonPath) {
        LocalDateTime startTime = LocalDateTime.now();
        log.info("startTime:{}",startTime);
        List<EnterpriseBean> enterpriseBeans = new ArrayList<>();
        File jsonFile = new File(jsonPath);
        Collection<File> files = FileUtils.listFiles(jsonFile, TrueFileFilter.TRUE, TrueFileFilter.TRUE);
        for (File file : files) {
            LocalDateTime oneFileStartTime = LocalDateTime.now();
            log.info("startTime:{} 解析并存储start:{}",oneFileStartTime,file);
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            JSONReader jsonReader = new JSONReader(Objects.requireNonNull(reader));
            EnterpriseListBean enterpriseListBean = jsonReader.readObject(EnterpriseListBean.class);
            List<EnterpriseBean> erDataList = enterpriseListBean.getErDataList();
            List<List<EnterpriseBean>> partitionBeans = Lists.partition(erDataList, 1000);
            partitionBeans.stream().map(partitionBean -> {
                EnterpriseListBean listBean = new EnterpriseListBean();
                listBean.setErDataList(partitionBean);
                return listBean;
            }).forEach(listBean -> {
                try {
                    mapper.insertEnterprise(listBean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            LocalDateTime oneFileEndTime = LocalDateTime.now();
            log.info("endTime:{} 解析并存储end:{}",oneFileEndTime,file);
            log.info("耗时:{}秒", Duration.between(oneFileStartTime,oneFileEndTime).toMillis()/1000.0);
        }
        LocalDateTime endTime = LocalDateTime.now();
        log.info("endTime:{}",endTime);
        log.info("总耗时:{}秒", Duration.between(startTime,endTime).toMillis()/1000.0);
        return enterpriseBeans;
    }

    @Override
    public String createEnterPriseTables(List<String> years, String mainTableName) {
        List<String> tableNames = years.stream().map(year -> mainTableName + "_" + year).collect(Collectors.toList());
        for (String tableName : tableNames) {
            mapper.createTables(tableName);
        }
        return null;
    }
}
