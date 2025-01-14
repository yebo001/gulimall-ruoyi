package com.gulimall.coupon.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.SpuBoundsMapper;
import com.gulimall.coupon.domain.SpuBounds;
import com.gulimall.coupon.service.ISpuBoundsService;

/**
 * 商品spu积分设置Service业务层处理
 * 
 * @author yebo
 * @date 2025-01-12
 */
@Service
public class SpuBoundsServiceImpl implements ISpuBoundsService 
{
    @Autowired
    private SpuBoundsMapper spuBoundsMapper;

    /**
     * 查询商品spu积分设置
     * 
     * @param id 商品spu积分设置主键
     * @return 商品spu积分设置
     */
    @Override
    public SpuBounds selectSpuBoundsById(Long id)
    {
        return spuBoundsMapper.selectSpuBoundsById(id);
    }

    /**
     * 查询商品spu积分设置列表
     * 
     * @param spuBounds 商品spu积分设置
     * @return 商品spu积分设置
     */
    @Override
    public List<SpuBounds> selectSpuBoundsList(SpuBounds spuBounds)
    {
        return spuBoundsMapper.selectSpuBoundsList(spuBounds);
    }

    /**
     * 新增商品spu积分设置
     * 
     * @param spuBounds 商品spu积分设置
     * @return 结果
     */
    @Override
    public int insertSpuBounds(SpuBounds spuBounds)
    {
        return spuBoundsMapper.insertSpuBounds(spuBounds);
    }

    /**
     * 修改商品spu积分设置
     * 
     * @param spuBounds 商品spu积分设置
     * @return 结果
     */
    @Override
    public int updateSpuBounds(SpuBounds spuBounds)
    {
        return spuBoundsMapper.updateSpuBounds(spuBounds);
    }

    /**
     * 批量删除商品spu积分设置
     * 
     * @param ids 需要删除的商品spu积分设置主键
     * @return 结果
     */
    @Override
    public int deleteSpuBoundsByIds(Long[] ids)
    {
        return spuBoundsMapper.deleteSpuBoundsByIds(ids);
    }

    /**
     * 删除商品spu积分设置信息
     * 
     * @param id 商品spu积分设置主键
     * @return 结果
     */
    @Override
    public int deleteSpuBoundsById(Long id)
    {
        return spuBoundsMapper.deleteSpuBoundsById(id);
    }
}
