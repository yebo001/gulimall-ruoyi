package com.gulimall.product.mapper;

import java.util.List;
import com.gulimall.product.domain.ProductAttrValue;
import org.apache.ibatis.annotations.Mapper;

/**
 * spu属性值Mapper接口
 * 
 * @author yebo
 * @date 2025-01-11
 */
@Mapper
public interface ProductAttrValueMapper 
{
    /**
     * 查询spu属性值
     * 
     * @param id spu属性值主键
     * @return spu属性值
     */
    public ProductAttrValue selectProductAttrValueById(Long id);

    /**
     * 查询spu属性值列表
     * 
     * @param productAttrValue spu属性值
     * @return spu属性值集合
     */
    public List<ProductAttrValue> selectProductAttrValueList(ProductAttrValue productAttrValue);

    /**
     * 新增spu属性值
     * 
     * @param productAttrValue spu属性值
     * @return 结果
     */
    public int insertProductAttrValue(ProductAttrValue productAttrValue);

    /**
     * 修改spu属性值
     * 
     * @param productAttrValue spu属性值
     * @return 结果
     */
    public int updateProductAttrValue(ProductAttrValue productAttrValue);

    /**
     * 删除spu属性值
     * 
     * @param id spu属性值主键
     * @return 结果
     */
    public int deleteProductAttrValueById(Long id);

    /**
     * 批量删除spu属性值
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductAttrValueByIds(Long[] ids);
}
