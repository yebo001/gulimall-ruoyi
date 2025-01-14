package com.gulimall.coupon.mapper;

import java.util.List;
import com.gulimall.coupon.domain.SeckillSkuRelation;

/**
 * 秒杀活动商品关联Mapper接口
 * 
 * @author yebo
 * @date 2025-01-12
 */
public interface SeckillSkuRelationMapper 
{
    /**
     * 查询秒杀活动商品关联
     * 
     * @param id 秒杀活动商品关联主键
     * @return 秒杀活动商品关联
     */
    public SeckillSkuRelation selectSeckillSkuRelationById(Long id);

    /**
     * 查询秒杀活动商品关联列表
     * 
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return 秒杀活动商品关联集合
     */
    public List<SeckillSkuRelation> selectSeckillSkuRelationList(SeckillSkuRelation seckillSkuRelation);

    /**
     * 新增秒杀活动商品关联
     * 
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    public int insertSeckillSkuRelation(SeckillSkuRelation seckillSkuRelation);

    /**
     * 修改秒杀活动商品关联
     * 
     * @param seckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    public int updateSeckillSkuRelation(SeckillSkuRelation seckillSkuRelation);

    /**
     * 删除秒杀活动商品关联
     * 
     * @param id 秒杀活动商品关联主键
     * @return 结果
     */
    public int deleteSeckillSkuRelationById(Long id);

    /**
     * 批量删除秒杀活动商品关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSeckillSkuRelationByIds(Long[] ids);
}
