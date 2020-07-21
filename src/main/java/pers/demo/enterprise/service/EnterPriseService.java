package pers.demo.enterprise.service;

import pers.demo.enterprise.beans.EnterpriseBean;

import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/10 23:29
 */
public interface EnterPriseService {
    /**
     * 从Json文件中解析
     * @param jsonPath json文件夹路径
     * @return result
     * */
    Boolean parseBeanFromJsonAndSave(String jsonPath);

    /**
     * 以某个字段为条件查询
     * @param filedName 字段名称
     * @return result
     * */
    List<EnterpriseBean> findEnterPrisesByCondition(String filedName);

    /**
     * 创建分表
     * @param years 创建那些年的表格
     * @param mainTableName 主表名
     * @return 保留
     * */
    String createEnterPriseTables(List<String> years,String mainTableName);
}
