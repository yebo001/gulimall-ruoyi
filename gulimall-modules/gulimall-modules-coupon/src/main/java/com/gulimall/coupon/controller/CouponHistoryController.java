package com.gulimall.coupon.controller;

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
import com.gulimall.coupon.domain.CouponHistory;
import com.gulimall.coupon.service.ICouponHistoryService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 优惠券领取历史记录Controller
 * 
 * @author yebo
 * @date 2025-01-12
 */
@RestController
@RequestMapping("/history")
public class CouponHistoryController extends BaseController
{
    @Autowired
    private ICouponHistoryService couponHistoryService;

    /**
     * 查询优惠券领取历史记录列表
     */
//@RequiresPermissions("coupon:history:list")
    @GetMapping("/list")
    public TableDataInfo list(CouponHistory couponHistory)
    {
        startPage();
        List<CouponHistory> list = couponHistoryService.selectCouponHistoryList(couponHistory);
        return getDataTable(list);
    }

    /**
     * 导出优惠券领取历史记录列表
     */
    //@RequiresPermissions("coupon:history:export")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CouponHistory couponHistory)
    {
        List<CouponHistory> list = couponHistoryService.selectCouponHistoryList(couponHistory);
        ExcelUtil<CouponHistory> util = new ExcelUtil<CouponHistory>(CouponHistory.class);
        util.exportExcel(response, list, "优惠券领取历史记录数据");
    }

    /**
     * 获取优惠券领取历史记录详细信息
     */
    //@RequiresPermissions("coupon:history:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(couponHistoryService.selectCouponHistoryById(id));
    }

    /**
     * 新增优惠券领取历史记录
     */
    //@RequiresPermissions("coupon:history:add")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CouponHistory couponHistory)
    {
        return toAjax(couponHistoryService.insertCouponHistory(couponHistory));
    }

    /**
     * 修改优惠券领取历史记录
     */
    // @RequiresPermissions("coupon:history:edit")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CouponHistory couponHistory)
    {
        return toAjax(couponHistoryService.updateCouponHistory(couponHistory));
    }

    /**
     * 删除优惠券领取历史记录
     */
    //@RequiresPermissions("coupon:history:remove")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(couponHistoryService.deleteCouponHistoryByIds(ids));
    }
}
