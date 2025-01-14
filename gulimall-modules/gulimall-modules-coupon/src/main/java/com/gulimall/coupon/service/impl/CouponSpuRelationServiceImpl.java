package com.gulimall.coupon.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.CouponSpuRelationMapper;
import com.gulimall.coupon.domain.CouponSpuRelation;
import com.gulimall.coupon.service.ICouponSpuRelationService;

/**
 * 优惠券与产品关联Service业务层处理
 * 
 * @author yebo
 * @date 2025-01-12
 */
@Service
public class CouponSpuRelationServiceImpl implements ICouponSpuRelationService 
{
    @Autowired
    private CouponSpuRelationMapper couponSpuRelationMapper;

    /**
     * 查询优惠券与产品关联
     * 
     * @param id 优惠券与产品关联主键
     * @return 优惠券与产品关联
     */
    @Override
    public CouponSpuRelation selectCouponSpuRelationById(Long id)
    {
        return couponSpuRelationMapper.selectCouponSpuRelationById(id);
    }

    /**
     * 查询优惠券与产品关联列表
     * 
     * @param couponSpuRelation 优惠券与产品关联
     * @return 优惠券与产品关联
     */
    @Override
    public List<CouponSpuRelation> selectCouponSpuRelationList(CouponSpuRelation couponSpuRelation)
    {
        return couponSpuRelationMapper.selectCouponSpuRelationList(couponSpuRelation);
    }

    /**
     * 新增优惠券与产品关联
     * 
     * @param couponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    @Override
    public int insertCouponSpuRelation(CouponSpuRelation couponSpuRelation)
    {
        return couponSpuRelationMapper.insertCouponSpuRelation(couponSpuRelation);
    }

    /**
     * 修改优惠券与产品关联
     * 
     * @param couponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    @Override
    public int updateCouponSpuRelation(CouponSpuRelation couponSpuRelation)
    {
        return couponSpuRelationMapper.updateCouponSpuRelation(couponSpuRelation);
    }

    /**
     * 批量删除优惠券与产品关联
     * 
     * @param ids 需要删除的优惠券与产品关联主键
     * @return 结果
     */
    @Override
    public int deleteCouponSpuRelationByIds(Long[] ids)
    {
        return couponSpuRelationMapper.deleteCouponSpuRelationByIds(ids);
    }

    /**
     * 删除优惠券与产品关联信息
     * 
     * @param id 优惠券与产品关联主键
     * @return 结果
     */
    @Override
    public int deleteCouponSpuRelationById(Long id)
    {
        return couponSpuRelationMapper.deleteCouponSpuRelationById(id);
    }
}
