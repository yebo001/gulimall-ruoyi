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
import com.gulimall.order.domain.OrderReturnApply;
import com.gulimall.order.service.IOrderReturnApplyService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 订单退货申请Controller
 * 
 * @author yebo
 * @date 2025-01-12
 */
@RestController
@RequestMapping("/apply")
public class OrderReturnApplyController extends BaseController
{
    @Autowired
    private IOrderReturnApplyService orderReturnApplyService;

    /**
     * 查询订单退货申请列表
     */
//@RequiresPermissions("order:apply:list")
    @GetMapping("/list")
    public TableDataInfo list(OrderReturnApply orderReturnApply)
    {
        startPage();
        List<OrderReturnApply> list = orderReturnApplyService.selectOrderReturnApplyList(orderReturnApply);
        return getDataTable(list);
    }

    /**
     * 导出订单退货申请列表
     */
    //@RequiresPermissions("order:apply:export")
    @Log(title = "订单退货申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrderReturnApply orderReturnApply)
    {
        List<OrderReturnApply> list = orderReturnApplyService.selectOrderReturnApplyList(orderReturnApply);
        ExcelUtil<OrderReturnApply> util = new ExcelUtil<OrderReturnApply>(OrderReturnApply.class);
        util.exportExcel(response, list, "订单退货申请数据");
    }

    /**
     * 获取订单退货申请详细信息
     */
    //@RequiresPermissions("order:apply:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(orderReturnApplyService.selectOrderReturnApplyById(id));
    }

    /**
     * 新增订单退货申请
     */
    //@RequiresPermissions("order:apply:add")
    @Log(title = "订单退货申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrderReturnApply orderReturnApply)
    {
        return toAjax(orderReturnApplyService.insertOrderReturnApply(orderReturnApply));
    }

    /**
     * 修改订单退货申请
     */
    // @RequiresPermissions("order:apply:edit")
    @Log(title = "订单退货申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrderReturnApply orderReturnApply)
    {
        return toAjax(orderReturnApplyService.updateOrderReturnApply(orderReturnApply));
    }

    /**
     * 删除订单退货申请
     */
    //@RequiresPermissions("order:apply:remove")
    @Log(title = "订单退货申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(orderReturnApplyService.deleteOrderReturnApplyByIds(ids));
    }
}
