package com.ruoyi.system.service.zk;

import java.util.List;
import com.ruoyi.system.domain.zk.ZkRenter;

/**
 * renterService接口
 * 
 * @author zk
 * @date 2020-10-31
 */
public interface IZkRenterService 
{
    /**
     * 查询renter
     * 
     * @param id renterID
     * @return renter
     */
    public ZkRenter selectZkRenterById(String id);

    /**
     * 查询renter列表
     * 
     * @param zkRenter renter
     * @return renter集合
     */
    public List<ZkRenter> selectZkRenterList(ZkRenter zkRenter);


    public List<ZkRenter> selectZkRenterListByHouseId(String  id);

    /**
     * 新增renter
     * 
     * @param zkRenter renter
     * @return 结果
     */
    public int insertZkRenter(ZkRenter zkRenter);

    /**
     * 修改renter
     * 
     * @param zkRenter renter
     * @return 结果
     */
    public int updateZkRenter(ZkRenter zkRenter);

    /**
     * 批量删除renter
     * 
     * @param ids 需要删除的renterID
     * @return 结果
     */
    public int deleteZkRenterByIds(String[] ids);

    /**
     * 删除renter信息
     * 
     * @param id renterID
     * @return 结果
     */
    public int deleteZkRenterById(String id);
}
