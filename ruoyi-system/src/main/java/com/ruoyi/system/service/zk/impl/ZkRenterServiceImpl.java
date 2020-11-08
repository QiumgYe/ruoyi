package com.ruoyi.system.service.zk.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.tool.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.zk.ZkRenterMapper;
import com.ruoyi.system.domain.zk.ZkRenter;
import com.ruoyi.system.service.zk.IZkRenterService;

/**
 * renterService业务层处理
 * 
 * @author zk
 * @date 2020-10-31
 */
@Service
public class ZkRenterServiceImpl implements IZkRenterService 
{
    @Autowired
    private ZkRenterMapper zkRenterMapper;

    /**
     * 查询renter
     * 
     * @param id renterID
     * @return renter
     */
    @Override
    public ZkRenter selectZkRenterById(String id)
    {
        return zkRenterMapper.selectZkRenterById(id);
    }

    /**
     * 查询renter列表
     * 
     * @param zkRenter renter
     * @return renter
     */
    @Override
    public List<ZkRenter> selectZkRenterList(ZkRenter zkRenter)
    {
        return zkRenterMapper.selectZkRenterList(zkRenter);
    }


    public List<ZkRenter> selectZkRenterListByHouseId(String id)
    {
        return zkRenterMapper.selectZkRenterListByHouseId(id);
    }

    /**
     * 新增renter
     * 
     * @param zkRenter renter
     * @return 结果
     */
    @Override
    public int insertZkRenter(ZkRenter zkRenter)
    {
        zkRenter.setCreateTime(DateUtils.getNowDate());
        zkRenter.setId(UUIDUtil.UUID());
        return zkRenterMapper.insertZkRenter(zkRenter);
    }

    /**
     * 修改renter
     * 
     * @param zkRenter renter
     * @return 结果
     */
    @Override
    public int updateZkRenter(ZkRenter zkRenter)
    {
        zkRenter.setUpdateTime(DateUtils.getNowDate());
        return zkRenterMapper.updateZkRenter(zkRenter);
    }

    /**
     * 批量删除renter
     * 
     * @param ids 需要删除的renterID
     * @return 结果
     */
    @Override
    public int deleteZkRenterByIds(String[] ids)
    {
        return zkRenterMapper.deleteZkRenterByIds(ids);
    }

    /**
     * 删除renter信息
     * 
     * @param id renterID
     * @return 结果
     */
    @Override
    public int deleteZkRenterById(String id)
    {
        return zkRenterMapper.deleteZkRenterById(id);
    }
}
