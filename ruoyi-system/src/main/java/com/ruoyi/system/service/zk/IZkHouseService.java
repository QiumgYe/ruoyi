package com.ruoyi.system.service.zk;

import java.util.List;
import com.ruoyi.system.domain.zk.ZkHouse;

/**
 * houseService接口
 * 
 * @author ruoyi
 * @date 2020-10-25
 */
public interface IZkHouseService 
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
     * 批量删除house
     * 
     * @param ids 需要删除的houseID
     * @return 结果
     */
    public int deleteZkHouseByIds(String[] ids);

    /**
     * 删除house信息
     * 
     * @param id houseID
     * @return 结果
     */
    public int deleteZkHouseById(String id);
}
