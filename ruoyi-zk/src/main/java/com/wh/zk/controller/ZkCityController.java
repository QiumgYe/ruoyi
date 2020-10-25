package com.wh.zk.controller;

import java.util.List;
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
import com.wh.zk.domain.ZkCity;
import com.wh.zk.service.IZkCityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * cityController
 * 
 * @author wh
 * @date 2020-10-25
 */
@RestController
@RequestMapping("/zk/city")
public class ZkCityController extends BaseController
{
    @Autowired
    private IZkCityService zkCityService;

    /**
     * 查询city列表
     */
    @PreAuthorize("@ss.hasPermi('zk:city:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZkCity zkCity)
    {
        startPage();
        List<ZkCity> list = zkCityService.selectZkCityList(zkCity);
        return getDataTable(list);
    }

    /**
     * 导出city列表
     */
    @PreAuthorize("@ss.hasPermi('zk:city:export')")
    @Log(title = "city", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZkCity zkCity)
    {
        List<ZkCity> list = zkCityService.selectZkCityList(zkCity);
        ExcelUtil<ZkCity> util = new ExcelUtil<ZkCity>(ZkCity.class);
        return util.exportExcel(list, "city");
    }

    /**
     * 获取city详细信息
     */
    @PreAuthorize("@ss.hasPermi('zk:city:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(zkCityService.selectZkCityById(id));
    }

    /**
     * 新增city
     */
    @PreAuthorize("@ss.hasPermi('zk:city:add')")
    @Log(title = "city", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZkCity zkCity)
    {
        return toAjax(zkCityService.insertZkCity(zkCity));
    }

    /**
     * 修改city
     */
    @PreAuthorize("@ss.hasPermi('zk:city:edit')")
    @Log(title = "city", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZkCity zkCity)
    {
        return toAjax(zkCityService.updateZkCity(zkCity));
    }

    /**
     * 删除city
     */
    @PreAuthorize("@ss.hasPermi('zk:city:remove')")
    @Log(title = "city", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(zkCityService.deleteZkCityByIds(ids));
    }
}
