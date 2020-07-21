package pers.demo.enterprise.service.impl;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import pers.demo.enterprise.beans.EnterpriseBean;
import pers.demo.enterprise.service.EnterPriseService;
import pers.demo.enterprise.utils.EnterpriseBeanUtil;

import java.io.File;
import java.util.Collection;
import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/21 9:28
 */
@Service("serviceMongoDb")
public class EnterPriseServiceMongoDbImpl implements EnterPriseService {

    private final MongoTemplate mongoTemplate;

    public EnterPriseServiceMongoDbImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Boolean parseBeanFromJsonAndSave(String jsonPath) {
        File jsonFile = new File(jsonPath);
        Collection<File> files = FileUtils.listFiles(jsonFile, TrueFileFilter.TRUE, TrueFileFilter.TRUE);
        for (File file : files) {
            List<EnterpriseBean> beanFromFile = EnterpriseBeanUtil.getBeanFromFile(file);
            mongoTemplate.insert(beanFromFile,"enterprises");
        }
        return true;
    }

    @Override
    public List<EnterpriseBean> findEnterPrisesByCondition(String filedName) {
        Query query = Query.query(Criteria.where("id").is("3005476386701314"));
        return mongoTemplate.find(query, EnterpriseBean.class);
    }

    @Override
    public String createEnterPriseTables(List<String> years, String mainTableName) {
        return null;
    }
}
