package com.ruoyi.system.domain.zk;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * renter对象 zk_renter
 * 
 * @author zk
 * @date 2020-10-31
 */
public class ZkRenter extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 租客id */
    private String id;

    /** 租客名字 */
    @Excel(name = "租客名字")
    private String renterName;

    /** 租客年龄 */
    @Excel(name = "租客年龄")
    private Integer renterAge;

    /** 租客性别 */
    @Excel(name = "租客性别")
    private String renterSex;

    /** 租客电话 */
    @Excel(name = "租客电话")
    private String renterPhone;

    /** 租客户口地址 */
    @Excel(name = "租客户口地址")
    private String renterAddress;

    /** 租客身份证id */
    @Excel(name = "租客身份证id")
    private String renterIdCard;

    /** 房子id号 */
    @Excel(name = "房子id号")
    private String houseId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setRenterName(String renterName) 
    {
        this.renterName = renterName;
    }

    public String getRenterName() 
    {
        return renterName;
    }
    public void setRenterAge(Integer renterAge) 
    {
        this.renterAge = renterAge;
    }

    public Integer getRenterAge() 
    {
        return renterAge;
    }
    public void setRenterSex(String renterSex) 
    {
        this.renterSex = renterSex;
    }

    public String getRenterSex() 
    {
        return renterSex;
    }
    public void setRenterPhone(String renterPhone) 
    {
        this.renterPhone = renterPhone;
    }

    public String getRenterPhone() 
    {
        return renterPhone;
    }
    public void setRenterAddress(String renterAddress) 
    {
        this.renterAddress = renterAddress;
    }

    public String getRenterAddress() 
    {
        return renterAddress;
    }
    public void setRenterIdCard(String renterIdCard) 
    {
        this.renterIdCard = renterIdCard;
    }

    public String getRenterIdCard() 
    {
        return renterIdCard;
    }
    public void setHouseId(String houseId) 
    {
        this.houseId = houseId;
    }

    public String getHouseId() 
    {
        return houseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("renterName", getRenterName())
            .append("renterAge", getRenterAge())
            .append("renterSex", getRenterSex())
            .append("renterPhone", getRenterPhone())
            .append("renterAddress", getRenterAddress())
            .append("renterIdCard", getRenterIdCard())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("houseId", getHouseId())
            .toString();
    }
}
