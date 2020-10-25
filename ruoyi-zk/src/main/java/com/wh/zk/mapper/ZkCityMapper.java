package com.wh.zk.mapper;

import java.util.List;
import com.wh.zk.domain.ZkCity;

/**
 * cityMapper接口
 * 
 * @author wh
 * @date 2020-10-25
 */
public interface ZkCityMapper 
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
     * 删除city
     * 
     * @param id cityID
     * @return 结果
     */
    public int deleteZkCityById(String id);

    /**
     * 批量删除city
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZkCityByIds(String[] ids);
}
