package com.ruoyi.system.service.zk.impl;

import java.util.List;

import com.ruoyi.system.tool.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.zk.ZkHouseMapper;
import com.ruoyi.system.domain.zk.ZkHouse;
import com.ruoyi.system.service.zk.IZkHouseService;

/**
 * houseService业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-25
 */
@Service
public class ZkHouseServiceImpl implements IZkHouseService 
{
    @Autowired
    private ZkHouseMapper zkHouseMapper;

    /**
     * 查询house
     * 
     * @param id houseID
     * @return house
     */
    @Override
    public ZkHouse selectZkHouseById(String id)
    {
        return zkHouseMapper.selectZkHouseById(id);
    }

    /**
     * 查询house列表
     * 
     * @param zkHouse house
     * @return house
     */
    @Override
    public List<ZkHouse> selectZkHouseList(ZkHouse zkHouse)
    {
        return zkHouseMapper.selectZkHouseList(zkHouse);
    }


    @Override
    public List<ZkHouse> selectZkHouseListByCityId(String cityId)
    {
        return zkHouseMapper.selectZkHouseListByCityId(cityId);
    }

    /**
     * 新增house
     * 
     * @param zkHouse house
     * @return 结果
     */
    @Override
    public int insertZkHouse(ZkHouse zkHouse)
    {
        zkHouse.setId(UUIDUtil.UUID());
        return zkHouseMapper.insertZkHouse(zkHouse);
    }

    /**
     * 修改house
     * 
     * @param zkHouse house
     * @return 结果
     */
    @Override
    public int updateZkHouse(ZkHouse zkHouse)
    {
        return zkHouseMapper.updateZkHouse(zkHouse);
    }

    /**
     * 批量删除house
     * 
     * @param ids 需要删除的houseID
     * @return 结果
     */
    @Override
    public int deleteZkHouseByIds(String[] ids)
    {
        return zkHouseMapper.deleteZkHouseByIds(ids);
    }

    /**
     * 删除house信息
     * 
     * @param id houseID
     * @return 结果
     */
    @Override
    public int deleteZkHouseById(String id)
    {
        return zkHouseMapper.deleteZkHouseById(id);
    }
}
