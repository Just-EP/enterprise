package pers.demo.enterprise.utils;

import com.alibaba.fastjson.JSONReader;
import pers.demo.enterprise.beans.EnterpriseBean;
import pers.demo.enterprise.beans.EnterpriseListBean;

import java.io.*;
import java.util.List;
import java.util.Objects;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/21 21:41
 */
public class EnterpriseBeanUtil {
    public static List<EnterpriseBean> getBeanFromFile(File file){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONReader jsonReader = new JSONReader(Objects.requireNonNull(reader));
        EnterpriseListBean enterpriseListBean = jsonReader.readObject(EnterpriseListBean.class);
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return enterpriseListBean.getErDataList();
    }
}
