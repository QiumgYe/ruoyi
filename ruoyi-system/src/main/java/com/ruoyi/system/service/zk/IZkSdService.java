package com.ruoyi.system.service.zk;

import java.util.List;
import com.ruoyi.system.domain.zk.ZkSd;

/**
 * sdService接口
 * 
 * @author zk
 * @date 2020-10-31
 */
public interface IZkSdService 
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
     * 批量删除sd
     * 
     * @param ids 需要删除的sdID
     * @return 结果
     */
    public int deleteZkSdByIds(String[] ids);

    /**
     * 删除sd信息
     * 
     * @param id sdID
     * @return 结果
     */
    public int deleteZkSdById(String id);
}
