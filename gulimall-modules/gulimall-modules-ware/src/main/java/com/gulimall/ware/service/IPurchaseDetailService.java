package com.gulimall.ware.service;

import java.util.List;
import com.gulimall.ware.domain.PurchaseDetail;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author yebo
 * @date 2025-01-12
 */
public interface IPurchaseDetailService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PurchaseDetail selectPurchaseDetailById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param purchaseDetail 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PurchaseDetail> selectPurchaseDetailList(PurchaseDetail purchaseDetail);

    /**
     * 新增【请填写功能名称】
     * 
     * @param purchaseDetail 【请填写功能名称】
     * @return 结果
     */
    public int insertPurchaseDetail(PurchaseDetail purchaseDetail);

    /**
     * 修改【请填写功能名称】
     * 
     * @param purchaseDetail 【请填写功能名称】
     * @return 结果
     */
    public int updatePurchaseDetail(PurchaseDetail purchaseDetail);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deletePurchaseDetailByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePurchaseDetailById(Long id);
}
