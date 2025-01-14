package com.gulimall.member.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.member.domain.GrowthChangeHistory;
import com.gulimall.member.service.IGrowthChangeHistoryService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 成长值变化历史记录Controller
 * 
 * @author yebo
 * @date 2025-01-12
 */
@RestController
@RequestMapping("/history")
public class GrowthChangeHistoryController extends BaseController
{
    @Autowired
    private IGrowthChangeHistoryService growthChangeHistoryService;

    /**
     * 查询成长值变化历史记录列表
     */
//@RequiresPermissions("member:history:list")
    @GetMapping("/list")
    public TableDataInfo list(GrowthChangeHistory growthChangeHistory)
    {
        startPage();
        List<GrowthChangeHistory> list = growthChangeHistoryService.selectGrowthChangeHistoryList(growthChangeHistory);
        return getDataTable(list);
    }

    /**
     * 导出成长值变化历史记录列表
     */
    //@RequiresPermissions("member:history:export")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, GrowthChangeHistory growthChangeHistory)
    {
        List<GrowthChangeHistory> list = growthChangeHistoryService.selectGrowthChangeHistoryList(growthChangeHistory);
        ExcelUtil<GrowthChangeHistory> util = new ExcelUtil<GrowthChangeHistory>(GrowthChangeHistory.class);
        util.exportExcel(response, list, "成长值变化历史记录数据");
    }

    /**
     * 获取成长值变化历史记录详细信息
     */
    //@RequiresPermissions("member:history:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(growthChangeHistoryService.selectGrowthChangeHistoryById(id));
    }

    /**
     * 新增成长值变化历史记录
     */
    //@RequiresPermissions("member:history:add")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody GrowthChangeHistory growthChangeHistory)
    {
        return toAjax(growthChangeHistoryService.insertGrowthChangeHistory(growthChangeHistory));
    }

    /**
     * 修改成长值变化历史记录
     */
    // @RequiresPermissions("member:history:edit")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody GrowthChangeHistory growthChangeHistory)
    {
        return toAjax(growthChangeHistoryService.updateGrowthChangeHistory(growthChangeHistory));
    }

    /**
     * 删除成长值变化历史记录
     */
    //@RequiresPermissions("member:history:remove")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(growthChangeHistoryService.deleteGrowthChangeHistoryByIds(ids));
    }
}
