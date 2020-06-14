package pers.demo.enterprise.beans;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @date 2020/6/11 21:30
 */
@Data
@Alias("EnterpriseListBean")
public class EnterpriseListBean {
    private List<EnterpriseBean> erDataList;
    /**
     * 自动生成表名
     * */
    public String getTableName() {
        EnterpriseBean enterpriseBean = erDataList.get(0);
        //每条记录都会有固定格式的日期1979-12-29,获取前4个字符
        String mainEnterpriseTableName = "base_enterprise_test";
        return mainEnterpriseTableName +"_"+enterpriseBean.getRegistrationDay().substring(0,4);
    }
}
