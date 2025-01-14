package com.gulimall.ware.controller;

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
import com.gulimall.ware.domain.PurchaseDetail;
import com.gulimall.ware.service.IPurchaseDetailService;
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
@RequestMapping("/detail")
public class PurchaseDetailController extends BaseController
{
    @Autowired
    private IPurchaseDetailService purchaseDetailService;

    /**
     * 查询【请填写功能名称】列表
     */
//@RequiresPermissions("ware:detail:list")
    @GetMapping("/list")
    public TableDataInfo list(PurchaseDetail purchaseDetail)
    {
        startPage();
        List<PurchaseDetail> list = purchaseDetailService.selectPurchaseDetailList(purchaseDetail);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    //@RequiresPermissions("ware:detail:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PurchaseDetail purchaseDetail)
    {
        List<PurchaseDetail> list = purchaseDetailService.selectPurchaseDetailList(purchaseDetail);
        ExcelUtil<PurchaseDetail> util = new ExcelUtil<PurchaseDetail>(PurchaseDetail.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    //@RequiresPermissions("ware:detail:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(purchaseDetailService.selectPurchaseDetailById(id));
    }

    /**
     * 新增【请填写功能名称】
     */
    //@RequiresPermissions("ware:detail:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PurchaseDetail purchaseDetail)
    {
        return toAjax(purchaseDetailService.insertPurchaseDetail(purchaseDetail));
    }

    /**
     * 修改【请填写功能名称】
     */
    // @RequiresPermissions("ware:detail:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PurchaseDetail purchaseDetail)
    {
        return toAjax(purchaseDetailService.updatePurchaseDetail(purchaseDetail));
    }

    /**
     * 删除【请填写功能名称】
     */
    //@RequiresPermissions("ware:detail:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(purchaseDetailService.deletePurchaseDetailByIds(ids));
    }
}
