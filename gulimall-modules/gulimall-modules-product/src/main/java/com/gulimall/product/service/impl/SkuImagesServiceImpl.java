package com.gulimall.product.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.SkuImagesMapper;
import com.gulimall.product.domain.SkuImages;
import com.gulimall.product.service.ISkuImagesService;

/**
 * sku图片Service业务层处理
 * 
 * @author yebo
 * @date 2025-01-11
 */
@Service
public class SkuImagesServiceImpl implements ISkuImagesService 
{
    @Autowired
    private SkuImagesMapper skuImagesMapper;

    /**
     * 查询sku图片
     * 
     * @param id sku图片主键
     * @return sku图片
     */
    @Override
    public SkuImages selectSkuImagesById(Long id)
    {
        return skuImagesMapper.selectSkuImagesById(id);
    }

    /**
     * 查询sku图片列表
     * 
     * @param skuImages sku图片
     * @return sku图片
     */
    @Override
    public List<SkuImages> selectSkuImagesList(SkuImages skuImages)
    {
        return skuImagesMapper.selectSkuImagesList(skuImages);
    }

    /**
     * 新增sku图片
     * 
     * @param skuImages sku图片
     * @return 结果
     */
    @Override
    public int insertSkuImages(SkuImages skuImages)
    {
        return skuImagesMapper.insertSkuImages(skuImages);
    }

    /**
     * 修改sku图片
     * 
     * @param skuImages sku图片
     * @return 结果
     */
    @Override
    public int updateSkuImages(SkuImages skuImages)
    {
        return skuImagesMapper.updateSkuImages(skuImages);
    }

    /**
     * 批量删除sku图片
     * 
     * @param ids 需要删除的sku图片主键
     * @return 结果
     */
    @Override
    public int deleteSkuImagesByIds(Long[] ids)
    {
        return skuImagesMapper.deleteSkuImagesByIds(ids);
    }

    /**
     * 删除sku图片信息
     * 
     * @param id sku图片主键
     * @return 结果
     */
    @Override
    public int deleteSkuImagesById(Long id)
    {
        return skuImagesMapper.deleteSkuImagesById(id);
    }
}
