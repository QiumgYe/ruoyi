package com.ruoyi.web.controller.zk;

import java.util.List;

import com.ruoyi.system.domain.zk.ZkHouse;
import com.ruoyi.system.domain.zk.ZkRenter;
import com.ruoyi.system.service.zk.IZkRenterService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * renterController
 * 
 * @author zk
 * @date 2020-10-31
 */
@RestController
@RequestMapping("/zk/renter")
public class ZkRenterController extends BaseController
{
    @Autowired
    private IZkRenterService zkRenterService;

    /**
     * 查询renter列表
     */
    @PreAuthorize("@ss.hasPermi('zk:renter:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZkRenter zkRenter)
    {
        startPage();
        List<ZkRenter> list = zkRenterService.selectZkRenterList(zkRenter);
        return getDataTable(list);
    }

    /**
     * 导出renter列表
     */
    @PreAuthorize("@ss.hasPermi('zk:renter:export')")
    @Log(title = "renter", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZkRenter zkRenter)
    {
        List<ZkRenter> list = zkRenterService.selectZkRenterList(zkRenter);
        ExcelUtil<ZkRenter> util = new ExcelUtil<ZkRenter>(ZkRenter.class);
        return util.exportExcel(list, "renter");
    }

    /**
     * 获取renter详细信息
     */
    @PreAuthorize("@ss.hasPermi('zk:renter:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(zkRenterService.selectZkRenterById(id));
    }

    /**
     * 新增renter
     */
    @PreAuthorize("@ss.hasPermi('zk:renter:add')")
    @Log(title = "renter", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZkRenter zkRenter)
    {
        return toAjax(zkRenterService.insertZkRenter(zkRenter));
    }

    /**
     * 修改renter
     */
    @PreAuthorize("@ss.hasPermi('zk:renter:edit')")
    @Log(title = "renter", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZkRenter zkRenter)
    {
        return toAjax(zkRenterService.updateZkRenter(zkRenter));
    }

    /**
     * 删除renter
     */
    @PreAuthorize("@ss.hasPermi('zk:renter:remove')")
    @Log(title = "renter", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(zkRenterService.deleteZkRenterByIds(ids));
    }


    /**
     * 根据houseId 来查找 renter
     */
    @PreAuthorize("@ss.hasPermi('zk:house:query')")
    @GetMapping(value = "/houseId/{id}")
    public TableDataInfo getInfoByHouseId(@PathVariable("id") String id)
    {
        startPage();
        List<ZkRenter> list = zkRenterService.selectZkRenterListByHouseId(id);
        return getDataTable(list);
    }
}
