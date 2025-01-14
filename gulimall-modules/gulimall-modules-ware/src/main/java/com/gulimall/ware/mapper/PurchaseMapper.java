package com.gulimall.ware.mapper;

import java.util.List;
import com.gulimall.ware.domain.Purchase;

/**
 * 采购信息Mapper接口
 * 
 * @author yebo
 * @date 2025-01-12
 */
public interface PurchaseMapper 
{
    /**
     * 查询采购信息
     * 
     * @param id 采购信息主键
     * @return 采购信息
     */
    public Purchase selectPurchaseById(Long id);

    /**
     * 查询采购信息列表
     * 
     * @param purchase 采购信息
     * @return 采购信息集合
     */
    public List<Purchase> selectPurchaseList(Purchase purchase);

    /**
     * 新增采购信息
     * 
     * @param purchase 采购信息
     * @return 结果
     */
    public int insertPurchase(Purchase purchase);

    /**
     * 修改采购信息
     * 
     * @param purchase 采购信息
     * @return 结果
     */
    public int updatePurchase(Purchase purchase);

    /**
     * 删除采购信息
     * 
     * @param id 采购信息主键
     * @return 结果
     */
    public int deletePurchaseById(Long id);

    /**
     * 批量删除采购信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePurchaseByIds(Long[] ids);
}
