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
    List<EnterpriseBean> parseBeanFromJsonAndSave(String jsonPath);
}
