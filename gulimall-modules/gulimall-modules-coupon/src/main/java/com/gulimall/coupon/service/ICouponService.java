package com.gulimall.coupon.service;

import java.util.List;
import com.gulimall.coupon.domain.Coupon;

/**
 * 优惠券信息Service接口
 * 
 * @author yebo
 * @date 2025-01-12
 */
public interface ICouponService 
{
    /**
     * 查询优惠券信息
     * 
     * @param id 优惠券信息主键
     * @return 优惠券信息
     */
    public Coupon selectCouponById(Long id);

    /**
     * 查询优惠券信息列表
     * 
     * @param coupon 优惠券信息
     * @return 优惠券信息集合
     */
    public List<Coupon> selectCouponList(Coupon coupon);

    /**
     * 新增优惠券信息
     * 
     * @param coupon 优惠券信息
     * @return 结果
     */
    public int insertCoupon(Coupon coupon);

    /**
     * 修改优惠券信息
     * 
     * @param coupon 优惠券信息
     * @return 结果
     */
    public int updateCoupon(Coupon coupon);

    /**
     * 批量删除优惠券信息
     * 
     * @param ids 需要删除的优惠券信息主键集合
     * @return 结果
     */
    public int deleteCouponByIds(Long[] ids);

    /**
     * 删除优惠券信息信息
     * 
     * @param id 优惠券信息主键
     * @return 结果
     */
    public int deleteCouponById(Long id);
}
