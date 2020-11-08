package com.ruoyi.system.service.zk.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.tool.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.zk.ZkSdMapper;
import com.ruoyi.system.domain.zk.ZkSd;
import com.ruoyi.system.service.zk.IZkSdService;

/**
 * sdService业务层处理
 * 
 * @author zk
 * @date 2020-10-31
 */
@Service
public class ZkSdServiceImpl implements IZkSdService 
{
    @Autowired
    private ZkSdMapper zkSdMapper;

    /**
     * 查询sd
     * 
     * @param id sdID
     * @return sd
     */
    @Override
    public ZkSd selectZkSdById(String id)
    {
        return zkSdMapper.selectZkSdById(id);
    }

    /**
     * 查询sd列表
     * 
     * @param zkSd sd
     * @return sd
     */
    @Override
    public List<ZkSd> selectZkSdList(ZkSd zkSd)
    {
        return zkSdMapper.selectZkSdList(zkSd);
    }

    /**
     * 新增sd
     * 
     * @param zkSd sd
     * @return 结果
     */
    @Override
    public int insertZkSd(ZkSd zkSd)
    {
        zkSd.setCreateTime(DateUtils.getNowDate());
        zkSd.setId(UUIDUtil.UUID());
        return zkSdMapper.insertZkSd(zkSd);
    }

    /**
     * 修改sd
     * 
     * @param zkSd sd
     * @return 结果
     */
    @Override
    public int updateZkSd(ZkSd zkSd)
    {
        return zkSdMapper.updateZkSd(zkSd);
    }

    /**
     * 批量删除sd
     * 
     * @param ids 需要删除的sdID
     * @return 结果
     */
    @Override
    public int deleteZkSdByIds(String[] ids)
    {
        return zkSdMapper.deleteZkSdByIds(ids);
    }

    /**
     * 删除sd信息
     * 
     * @param id sdID
     * @return 结果
     */
    @Override
    public int deleteZkSdById(String id)
    {
        return zkSdMapper.deleteZkSdById(id);
    }
}
