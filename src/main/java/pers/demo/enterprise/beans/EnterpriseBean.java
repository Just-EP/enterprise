package pers.demo.enterprise.beans;

import lombok.Data;

/**
 * 企业实体类
 *     "name":"企业名称",
 *     "code":"统一社会信用代码",
 *     "registrationDay":"注册日期",
 *     "character":"企业类型",
 *     "legalRepresentative":"法人代表",
 *     "capital":"注册资金",
 *     "businessScope":"经营范围",
 *     "province":"所在省份",
 *     "city":"地区",
 *     "address":"注册地址"
 * */
@Data
public class EnterpriseBean{
    private String character;
    private String legalRepresentative;
    private String capital;
    private String code;
    private String address;
    private String province;
    private String city;
    private String name;
    private String businessScope;
    private String registrationDay;
}
