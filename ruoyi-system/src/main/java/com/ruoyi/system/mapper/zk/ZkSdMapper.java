package com.ruoyi.system.mapper.zk;

import java.util.List;
import com.ruoyi.system.domain.zk.ZkSd;

/**
 * sdMapper接口
 * 
 * @author zk
 * @date 2020-10-31
 */
public interface ZkSdMapper 
{
    /**
     * 查询sd
     * 
     * @param id sdID
     * @return sd
     */
    public ZkSd selectZkSdById(String id);

    /**
     * 查询sd列表
     * 
     * @param zkSd sd
     * @return sd集合
     */
    public List<ZkSd> selectZkSdList(ZkSd zkSd);

    /**
     * 新增sd
     * 
     * @param zkSd sd
     * @return 结果
     */
    public int insertZkSd(ZkSd zkSd);

    /**
     * 修改sd
     * 
     * @param zkSd sd
     * @return 结果
     */
    public int updateZkSd(ZkSd zkSd);

    /**
     * 删除sd
     * 
     * @param id sdID
     * @return 结果
     */
    public int deleteZkSdById(String id);

    /**
     * 批量删除sd
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZkSdByIds(String[] ids);
}
