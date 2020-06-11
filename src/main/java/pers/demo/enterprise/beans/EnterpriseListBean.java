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
}
