package com.gulimall.product.mapper;

import java.util.List;
import com.gulimall.product.domain.SkuSaleAttrValue;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku销售属性&值Mapper接口
 * 
 * @author yebo
 * @date 2025-01-11
 */
@Mapper
public interface SkuSaleAttrValueMapper 
{
    /**
     * 查询sku销售属性&值
     * 
     * @param id sku销售属性&值主键
     * @return sku销售属性&值
     */
    public SkuSaleAttrValue selectSkuSaleAttrValueById(Long id);

    /**
     * 查询sku销售属性&值列表
     * 
     * @param skuSaleAttrValue sku销售属性&值
     * @return sku销售属性&值集合
     */
    public List<SkuSaleAttrValue> selectSkuSaleAttrValueList(SkuSaleAttrValue skuSaleAttrValue);

    /**
     * 新增sku销售属性&值
     * 
     * @param skuSaleAttrValue sku销售属性&值
     * @return 结果
     */
    public int insertSkuSaleAttrValue(SkuSaleAttrValue skuSaleAttrValue);

    /**
     * 修改sku销售属性&值
     * 
     * @param skuSaleAttrValue sku销售属性&值
     * @return 结果
     */
    public int updateSkuSaleAttrValue(SkuSaleAttrValue skuSaleAttrValue);

    /**
     * 删除sku销售属性&值
     * 
     * @param id sku销售属性&值主键
     * @return 结果
     */
    public int deleteSkuSaleAttrValueById(Long id);

    /**
     * 批量删除sku销售属性&值
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSkuSaleAttrValueByIds(Long[] ids);
}
