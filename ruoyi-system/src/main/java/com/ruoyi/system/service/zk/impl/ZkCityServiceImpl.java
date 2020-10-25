package com.ruoyi.system.service.zk.impl;


import com.ruoyi.system.domain.zk.ZkCity;
import com.ruoyi.system.mapper.zk.ZkCityMapper;
import com.ruoyi.system.service.zk.IZkCityService;
import com.ruoyi.system.tool.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * cityService业务层处理
 * 
 * @author wh
 * @date 2020-10-25
 */
@Service
public class ZkCityServiceImpl implements IZkCityService
{
    @Autowired
    private ZkCityMapper zkCityMapper;

    /**
     * 查询city
     * 
     * @param id cityID
     * @return city
     */
    @Override
    public ZkCity selectZkCityById(String id)
    {
        return zkCityMapper.selectZkCityById(id);
    }

    /**
     * 查询city列表
     * 
     * @param zkCity city
     * @return city
     */
    @Override
    public List<ZkCity> selectZkCityList(ZkCity zkCity)
    {
        return zkCityMapper.selectZkCityList(zkCity);
    }

    /**
     * 新增city
     * 
     * @param zkCity city
     * @return 结果
     */
    @Override
    public int insertZkCity(ZkCity zkCity)
    {

        zkCity.setId(UUIDUtil.UUID());
        return zkCityMapper.insertZkCity(zkCity);
    }

    /**
     * 修改city
     * 
     * @param zkCity city
     * @return 结果
     */
    @Override
    public int updateZkCity(ZkCity zkCity)
    {
        return zkCityMapper.updateZkCity(zkCity);
    }

    /**
     * 批量删除city
     * 
     * @param ids 需要删除的cityID
     * @return 结果
     */
    @Override
    public int deleteZkCityByIds(String[] ids)
    {
        return zkCityMapper.deleteZkCityByIds(ids);
    }

    /**
     * 删除city信息
     * 
     * @param id cityID
     * @return 结果
     */
    @Override
    public int deleteZkCityById(String id)
    {
        return zkCityMapper.deleteZkCityById(id);
    }
}
