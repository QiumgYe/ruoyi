package com.ruoyi.system.domain.zk;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * sd对象 zk_sd
 * 
 * @author zk
 * @date 2020-10-31
 */
public class ZkSd extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 水电费id */
    private String id;

    /** 使用水的量 */
    @Excel(name = "使用水的量")
    private BigDecimal sdWater;

    /** 使用电的量 */
    @Excel(name = "使用电的量")
    private BigDecimal sdElec;

    /** 是否付款 */
    @Excel(name = "是否付款")
    private Integer isPay;

    /** 房号Id */
    @Excel(name = "房号Id")
    private String houseId;

    /** 付款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "付款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 最迟时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最迟时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date  latestTime;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setSdWater(BigDecimal sdWater) 
    {
        this.sdWater = sdWater;
    }

    public BigDecimal getSdWater() 
    {
        return sdWater;
    }
    public void setSdElec(BigDecimal sdElec) 
    {
        this.sdElec = sdElec;
    }

    public BigDecimal getSdElec() 
    {
        return sdElec;
    }
    public void setIsPay(Integer isPay) 
    {
        this.isPay = isPay;
    }

    public Integer getIsPay() 
    {
        return isPay;
    }
    public void setHouseId(String houseId) 
    {
        this.houseId = houseId;
    }

    public String getHouseId() 
    {
        return houseId;
    }
    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
    }
    public void setlatestTime(Date  latestTime)
    {
        this. latestTime =  latestTime;
    }

    public Date getlatestTime()
    {
        return  latestTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sdWater", getSdWater())
            .append("sdElec", getSdElec())
            .append("isPay", getIsPay())
            .append("houseId", getHouseId())
            .append("createTime", getCreateTime())
            .append("payTime", getPayTime())
            .append(" latestTime", getlatestTime())
            .toString();
    }
}
