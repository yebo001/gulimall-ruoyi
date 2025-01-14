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
import com.gulimall.coupon.domain.CouponSpuCategoryRelation;
import com.gulimall.coupon.service.ICouponSpuCategoryRelationService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 优惠券分类关联Controller
 * 
 * @author yebo
 * @date 2025-01-12
 */
@RestController
@RequestMapping("/relation")
public class CouponSpuCategoryRelationController extends BaseController
{
    @Autowired
    private ICouponSpuCategoryRelationService couponSpuCategoryRelationService;

    /**
     * 查询优惠券分类关联列表
     */
//@RequiresPermissions("coupon:relation:list")
    @GetMapping("/list")
    public TableDataInfo list(CouponSpuCategoryRelation couponSpuCategoryRelation)
    {
        startPage();
        List<CouponSpuCategoryRelation> list = couponSpuCategoryRelationService.selectCouponSpuCategoryRelationList(couponSpuCategoryRelation);
        return getDataTable(list);
    }

    /**
     * 导出优惠券分类关联列表
     */
    //@RequiresPermissions("coupon:relation:export")
    @Log(title = "优惠券分类关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CouponSpuCategoryRelation couponSpuCategoryRelation)
    {
        List<CouponSpuCategoryRelation> list = couponSpuCategoryRelationService.selectCouponSpuCategoryRelationList(couponSpuCategoryRelation);
        ExcelUtil<CouponSpuCategoryRelation> util = new ExcelUtil<CouponSpuCategoryRelation>(CouponSpuCategoryRelation.class);
        util.exportExcel(response, list, "优惠券分类关联数据");
    }

    /**
     * 获取优惠券分类关联详细信息
     */
    //@RequiresPermissions("coupon:relation:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(couponSpuCategoryRelationService.selectCouponSpuCategoryRelationById(id));
    }

    /**
     * 新增优惠券分类关联
     */
    //@RequiresPermissions("coupon:relation:add")
    @Log(title = "优惠券分类关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation)
    {
        return toAjax(couponSpuCategoryRelationService.insertCouponSpuCategoryRelation(couponSpuCategoryRelation));
    }

    /**
     * 修改优惠券分类关联
     */
    // @RequiresPermissions("coupon:relation:edit")
    @Log(title = "优惠券分类关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation)
    {
        return toAjax(couponSpuCategoryRelationService.updateCouponSpuCategoryRelation(couponSpuCategoryRelation));
    }

    /**
     * 删除优惠券分类关联
     */
    //@RequiresPermissions("coupon:relation:remove")
    @Log(title = "优惠券分类关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(couponSpuCategoryRelationService.deleteCouponSpuCategoryRelationByIds(ids));
    }
}
