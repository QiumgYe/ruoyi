package com.ruoyi.system.domain.zk;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * house对象 zk_house
 * 
 * @author ruoyi
 * @date 2020-10-25
 */
public class ZkHouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 房产id */
    private String id;


    /** 平方数 */
    @Excel(name = "平方数")
    private String houseSize;

    /** 租金 */
    @Excel(name = "租金")
    private String houseMoney;

    /** 房产描述 */
    @Excel(name = "房产描述")
    private String houseDescription;

    /** 城市id */
    @Excel(name = "城市id")
    private String cityId;

    /** 房子名字 */
    @Excel(name = "房子名字")
    private String houseName;

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setHouseSize(String houseSize) 
    {
        this.houseSize = houseSize;
    }

    public String getHouseSize() 
    {
        return houseSize;
    }
    public void setHouseMoney(String houseMoney) 
    {
        this.houseMoney = houseMoney;
    }

    public String getHouseMoney() 
    {
        return houseMoney;
    }
    public void setHouseDescription(String houseDescription) 
    {
        this.houseDescription = houseDescription;
    }

    public String getHouseDescription() 
    {
        return houseDescription;
    }
    public void setCityId(String cityId) 
    {
        this.cityId = cityId;
    }

    public String getCityId() 
    {
        return cityId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())

            .append("houseSize", getHouseSize())
            .append("houseMoney", getHouseMoney())
            .append("houseDescription", getHouseDescription())
                .append("houseName", getHouseName())
            .append("cityId", getCityId())
            .toString();
    }
}
