package com.ruoyi.web.controller.zk;

import java.util.List;

import com.ruoyi.system.domain.zk.ZkHouse;
import com.ruoyi.system.service.zk.IZkHouseService;
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
 * houseController
 * 
 * @author ruoyi
 * @date 2020-10-25
 */
@RestController
@RequestMapping("/zk/house")
public class ZkHouseController extends BaseController
{
    @Autowired
    private IZkHouseService zkHouseService;

    /**
     * 查询house列表
     */
    @PreAuthorize("@ss.hasPermi('zk:house:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZkHouse zkHouse)
    {
        startPage();
        List<ZkHouse> list = zkHouseService.selectZkHouseList(zkHouse);
        return getDataTable(list);
    }

    /**
     * 导出house列表
     */
    @PreAuthorize("@ss.hasPermi('zk:house:export')")
    @Log(title = "house", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZkHouse zkHouse)
    {
        List<ZkHouse> list = zkHouseService.selectZkHouseList(zkHouse);
        ExcelUtil<ZkHouse> util = new ExcelUtil<ZkHouse>(ZkHouse.class);
        return util.exportExcel(list, "house");
    }

    /**
     * 获取house详细信息
     */
    @PreAuthorize("@ss.hasPermi('zk:house:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(zkHouseService.selectZkHouseById(id));
    }

    /**
     * 新增house
     */
    @PreAuthorize("@ss.hasPermi('zk:house:add')")
    @Log(title = "house", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZkHouse zkHouse)
    {
        return toAjax(zkHouseService.insertZkHouse(zkHouse));
    }

    /**
     * 修改house
     */
    @PreAuthorize("@ss.hasPermi('zk:house:edit')")
    @Log(title = "house", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZkHouse zkHouse)
    {
        return toAjax(zkHouseService.updateZkHouse(zkHouse));
    }

    /**
     * 删除house
     */
    @PreAuthorize("@ss.hasPermi('zk:house:remove')")
    @Log(title = "house", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(zkHouseService.deleteZkHouseByIds(ids));
    }


    /**
     * 根据cityId 来查找 house
     */
    @PreAuthorize("@ss.hasPermi('zk:house:query')")
    @GetMapping(value = "/cityid/{id}")
    public TableDataInfo getInfoByCityId(@PathVariable("id") String id)
    {
        startPage();
        List<ZkHouse> list = zkHouseService.selectZkHouseListByCityId(id);
        return getDataTable(list);
    }
}
