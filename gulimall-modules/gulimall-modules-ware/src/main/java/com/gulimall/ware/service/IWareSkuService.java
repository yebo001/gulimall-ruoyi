package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.WareSku;

/**
 * 商品库存Service接口
 * 
 * @author yebo
 * @date 2025-01-12
 */
public interface IWareSkuService 
{
    /**
     * 查询商品库存
     * 
     * @param id 商品库存主键
     * @return 商品库存
     */
    public WareSku selectWareSkuById(Long id);

    /**
     * 查询商品库存列表
     * 
     * @param wareSku 商品库存
     * @return 商品库存集合
     */
    public List<WareSku> selectWareSkuList(WareSku wareSku);

    /**
     * 新增商品库存
     * 
     * @param wareSku 商品库存
     * @return 结果
     */
    public int insertWareSku(WareSku wareSku);

    /**
     * 修改商品库存
     * 
     * @param wareSku 商品库存
     * @return 结果
     */
    public int updateWareSku(WareSku wareSku);

    /**
     * 批量删除商品库存
     * 
     * @param ids 需要删除的商品库存主键集合
     * @return 结果
     */
    public int deleteWareSkuByIds(Long[] ids);

    /**
     * 删除商品库存信息
     * 
     * @param id 商品库存主键
     * @return 结果
     */
    public int deleteWareSkuById(Long id);
}
