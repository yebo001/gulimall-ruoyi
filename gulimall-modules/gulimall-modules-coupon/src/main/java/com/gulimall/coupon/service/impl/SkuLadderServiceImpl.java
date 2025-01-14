package com.gulimall.coupon.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.coupon.mapper.SkuLadderMapper;
import com.gulimall.coupon.domain.SkuLadder;
import com.gulimall.coupon.service.ISkuLadderService;

/**
 * 商品阶梯价格Service业务层处理
 * 
 * @author yebo
 * @date 2025-01-12
 */
@Service
public class SkuLadderServiceImpl implements ISkuLadderService 
{
    @Autowired
    private SkuLadderMapper skuLadderMapper;

    /**
     * 查询商品阶梯价格
     * 
     * @param id 商品阶梯价格主键
     * @return 商品阶梯价格
     */
    @Override
    public SkuLadder selectSkuLadderById(Long id)
    {
        return skuLadderMapper.selectSkuLadderById(id);
    }

    /**
     * 查询商品阶梯价格列表
     * 
     * @param skuLadder 商品阶梯价格
     * @return 商品阶梯价格
     */
    @Override
    public List<SkuLadder> selectSkuLadderList(SkuLadder skuLadder)
    {
        return skuLadderMapper.selectSkuLadderList(skuLadder);
    }

    /**
     * 新增商品阶梯价格
     * 
     * @param skuLadder 商品阶梯价格
     * @return 结果
     */
    @Override
    public int insertSkuLadder(SkuLadder skuLadder)
    {
        return skuLadderMapper.insertSkuLadder(skuLadder);
    }

    /**
     * 修改商品阶梯价格
     * 
     * @param skuLadder 商品阶梯价格
     * @return 结果
     */
    @Override
    public int updateSkuLadder(SkuLadder skuLadder)
    {
        return skuLadderMapper.updateSkuLadder(skuLadder);
    }

    /**
     * 批量删除商品阶梯价格
     * 
     * @param ids 需要删除的商品阶梯价格主键
     * @return 结果
     */
    @Override
    public int deleteSkuLadderByIds(Long[] ids)
    {
        return skuLadderMapper.deleteSkuLadderByIds(ids);
    }

    /**
     * 删除商品阶梯价格信息
     * 
     * @param id 商品阶梯价格主键
     * @return 结果
     */
    @Override
    public int deleteSkuLadderById(Long id)
    {
        return skuLadderMapper.deleteSkuLadderById(id);
    }
}
