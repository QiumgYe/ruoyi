package com.ruoyi.system.mapper.zk;

import java.util.List;
import com.ruoyi.system.domain.zk.ZkHouse;

/**
 * houseMapper接口
 * 
 * @author ruoyi
 * @date 2020-10-25
 */
public interface ZkHouseMapper 
{
    /**
     * 查询house
     * 
     * @param id houseID
     * @return house
     */
    public ZkHouse selectZkHouseById(String id);

    /**
     * 查询house列表
     * 
     * @param zkHouse house
     * @return house集合
     */
    public List<ZkHouse> selectZkHouseList(ZkHouse zkHouse);


    /**
     * 根据cityId 来找house
     *
     * @param zkHouse house
     * @return house集合
     */
    public List<ZkHouse> selectZkHouseListByCityId(String cityId);

    /**
     * 新增house
     * 
     * @param zkHouse house
     * @return 结果
     */
    public int insertZkHouse(ZkHouse zkHouse);

    /**
     * 修改house
     * 
     * @param zkHouse house
     * @return 结果
     */
    public int updateZkHouse(ZkHouse zkHouse);

    /**
     * 删除house
     * 
     * @param id houseID
     * @return 结果
     */
    public int deleteZkHouseById(String id);

    /**
     * 批量删除house
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZkHouseByIds(String[] ids);
}
