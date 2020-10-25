package com.wh.zk.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * city对象 zk_city
 * 
 * @author wh
 * @date 2020-10-25
 */
public class ZkCity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 城市id */
    private String id;

    /** 城市描述：如广东省深圳市 */
    @Excel(name = "城市描述：如广东省深圳市")
    private String cityDescription;

    /** 城市水费单价 */
    @Excel(name = "城市水费单价")
    private Integer waterPrice;

    /** 城市电费单价 */
    @Excel(name = "城市电费单价")
    private Integer elecPrice;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setCityDescription(String cityDescription) 
    {
        this.cityDescription = cityDescription;
    }

    public String getCityDescription() 
    {
        return cityDescription;
    }
    public void setWaterPrice(Integer waterPrice) 
    {
        this.waterPrice = waterPrice;
    }

    public Integer getWaterPrice() 
    {
        return waterPrice;
    }
    public void setElecPrice(Integer elecPrice) 
    {
        this.elecPrice = elecPrice;
    }

    public Integer getElecPrice() 
    {
        return elecPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cityDescription", getCityDescription())
            .append("waterPrice", getWaterPrice())
            .append("elecPrice", getElecPrice())
            .toString();
    }
}
