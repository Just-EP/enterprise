package pers.demo.enterprise.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import pers.demo.enterprise.beans.EnterpriseListBean;

/**
 * @author JustEP
 * @version 1.0
 * @classname EnterpriseMapper
 * @description 企业Mapper
 * @createtime 2020/06/09 22:33:00
 */
@Mapper
@Repository
public interface EnterpriseMapper {
    /**
     * 入库
     * @param enterpriseListBean beans
     * */
    void insertEnterprise(EnterpriseListBean enterpriseListBean);
}
