package com.ruoyi.system.domain.zk;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
    private Double waterPrice;

    /** 城市电费单价 */
    @Excel(name = "城市电费单价")
    private Double elecPrice;

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

    public Double getWaterPrice() {
        return waterPrice;
    }

    public void setWaterPrice(Double waterPrice) {
        this.waterPrice = waterPrice;
    }

    public Double getElecPrice() {
        return elecPrice;
    }

    public void setElecPrice(Double elecPrice) {
        this.elecPrice = elecPrice;
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
