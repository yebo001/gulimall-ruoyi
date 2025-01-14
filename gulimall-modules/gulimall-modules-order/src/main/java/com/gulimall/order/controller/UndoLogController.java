package com.gulimall.order.controller;

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
import com.gulimall.order.domain.UndoLog;
import com.gulimall.order.service.IUndoLogService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author yebo
 * @date 2025-01-12
 */
@RestController
@RequestMapping("/log")
public class UndoLogController extends BaseController
{
    @Autowired
    private IUndoLogService undoLogService;

    /**
     * 查询【请填写功能名称】列表
     */
//@RequiresPermissions("order:log:list")
    @GetMapping("/list")
    public TableDataInfo list(UndoLog undoLog)
    {
        startPage();
        List<UndoLog> list = undoLogService.selectUndoLogList(undoLog);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    //@RequiresPermissions("order:log:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UndoLog undoLog)
    {
        List<UndoLog> list = undoLogService.selectUndoLogList(undoLog);
        ExcelUtil<UndoLog> util = new ExcelUtil<UndoLog>(UndoLog.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    //@RequiresPermissions("order:log:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(undoLogService.selectUndoLogById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    //@RequiresPermissions("order:log:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UndoLog undoLog)
    {
        return toAjax(undoLogService.insertUndoLog(undoLog));
    }

    /**
     * 修改【请填写功能名称】
     */
    // @RequiresPermissions("order:log:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UndoLog undoLog)
    {
        return toAjax(undoLogService.updateUndoLog(undoLog));
    }

    /**
     * 删除【请填写功能名称】
     */
    //@RequiresPermissions("order:log:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(undoLogService.deleteUndoLogByIds(ids));
    }
}
