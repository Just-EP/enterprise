package pers.demo.enterprise.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import pers.demo.enterprise.utils.SnowflakeIdWorker;
import pers.demo.enterprise.utils.SpringUtil;

import java.util.Objects;

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
@Document(collection="enterprise_info")
public class EnterpriseBean{
    @Id
    private Long id;
    @Field("character")
    private String character;
    @Field("legal_representative")
    private String legalRepresentative;
    @Field("capital")
    private String capital;
    @Field("code")
    private String code;
    @Field("address")
    private String address;
    @Field("province")
    private String province;
    @Field("city")
    private String city;
    @Field("name")
    private String name;
    @Field("business_scope")
    private String businessScope;
    @Field("registration_day")
    private String registrationDay;


    public EnterpriseBean() {
        SnowflakeIdWorker worker = (SnowflakeIdWorker) SpringUtil.getBean("snowflakeIdWorker");
        id = worker.nextId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessScope() {
        return businessScope;
    }

    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    public String getRegistrationDay() {
        return registrationDay;
    }

    public void setRegistrationDay(String registrationDay) {
        this.registrationDay = registrationDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnterpriseBean that = (EnterpriseBean) o;
        return code.equals(that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "EnterpriseBean{" +
                "id=" + id +
                ", character='" + character + '\'' +
                ", legalRepresentative='" + legalRepresentative + '\'' +
                ", capital='" + capital + '\'' +
                ", code='" + code + '\'' +
                ", address='" + address + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", name='" + name + '\'' +
                ", businessScope='" + businessScope + '\'' +
                ", registrationDay='" + registrationDay + '\'' +
                '}';
    }
}
