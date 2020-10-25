package com.wh.zk.service;

import java.util.List;
import com.wh.zk.domain.ZkCity;

/**
 * cityService接口
 * 
 * @author wh
 * @date 2020-10-25
 */
public interface IZkCityService 
{
    /**
     * 查询city
     * 
     * @param id cityID
     * @return city
     */
    public ZkCity selectZkCityById(String id);

    /**
     * 查询city列表
     * 
     * @param zkCity city
     * @return city集合
     */
    public List<ZkCity> selectZkCityList(ZkCity zkCity);

    /**
     * 新增city
     * 
     * @param zkCity city
     * @return 结果
     */
    public int insertZkCity(ZkCity zkCity);

    /**
     * 修改city
     * 
     * @param zkCity city
     * @return 结果
     */
    public int updateZkCity(ZkCity zkCity);

    /**
     * 批量删除city
     * 
     * @param ids 需要删除的cityID
     * @return 结果
     */
    public int deleteZkCityByIds(String[] ids);

    /**
     * 删除city信息
     * 
     * @param id cityID
     * @return 结果
     */
    public int deleteZkCityById(String id);
}
