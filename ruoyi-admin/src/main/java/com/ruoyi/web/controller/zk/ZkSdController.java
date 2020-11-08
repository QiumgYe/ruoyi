package com.ruoyi.web.controller.zk;

import java.util.List;

import com.ruoyi.system.domain.zk.ZkSd;
import com.ruoyi.system.service.zk.IZkSdService;
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
 * sdController
 * 
 * @author zk
 * @date 2020-10-31
 */
@RestController
@RequestMapping("/zk/sd")
public class ZkSdController extends BaseController
{
    @Autowired
    private IZkSdService zkSdService;

    /**
     * 查询sd列表
     */
    @PreAuthorize("@ss.hasPermi('zk:sd:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZkSd zkSd)
    {
        startPage();
        List<ZkSd> list = zkSdService.selectZkSdList(zkSd);
        return getDataTable(list);
    }

    /**
     * 导出sd列表
     */
    @PreAuthorize("@ss.hasPermi('zk:sd:export')")
    @Log(title = "sd", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZkSd zkSd)
    {
        List<ZkSd> list = zkSdService.selectZkSdList(zkSd);
        ExcelUtil<ZkSd> util = new ExcelUtil<ZkSd>(ZkSd.class);
        return util.exportExcel(list, "sd");
    }

    /**
     * 获取sd详细信息
     */
    @PreAuthorize("@ss.hasPermi('zk:sd:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(zkSdService.selectZkSdById(id));
    }

    /**
     * 新增sd
     */
    @PreAuthorize("@ss.hasPermi('zk:sd:add')")
    @Log(title = "sd", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZkSd zkSd)
    {
        return toAjax(zkSdService.insertZkSd(zkSd));
    }

    /**
     * 修改sd
     */
    @PreAuthorize("@ss.hasPermi('zk:sd:edit')")
    @Log(title = "sd", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZkSd zkSd)
    {
        return toAjax(zkSdService.updateZkSd(zkSd));
    }

    /**
     * 删除sd
     */
    @PreAuthorize("@ss.hasPermi('zk:sd:remove')")
    @Log(title = "sd", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(zkSdService.deleteZkSdByIds(ids));
    }
}
