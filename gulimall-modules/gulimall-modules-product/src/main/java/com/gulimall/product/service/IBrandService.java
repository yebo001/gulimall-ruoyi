package com.gulimall.product.service;

import java.util.List;
import com.gulimall.product.domain.Brand;

/**
 * 品牌Service接口
 * 
 * @author yebo
 * @date 2025-01-11
 */
public interface IBrandService 
{
    /**
     * 查询品牌
     * 
     * @param brandId 品牌主键
     * @return 品牌
     */
    public Brand selectBrandByBrandId(Long brandId);

    /**
     * 查询品牌列表
     * 
     * @param brand 品牌
     * @return 品牌集合
     */
    public List<Brand> selectBrandList(Brand brand);

    /**
     * 新增品牌
     * 
     * @param brand 品牌
     * @return 结果
     */
    public int insertBrand(Brand brand);

    /**
     * 修改品牌
     * 
     * @param brand 品牌
     * @return 结果
     */
    public int updateBrand(Brand brand);

    /**
     * 批量删除品牌
     * 
     * @param brandIds 需要删除的品牌主键集合
     * @return 结果
     */
    public int deleteBrandByBrandIds(Long[] brandIds);

    /**
     * 删除品牌信息
     * 
     * @param brandId 品牌主键
     * @return 结果
     */
    public int deleteBrandByBrandId(Long brandId);
}
