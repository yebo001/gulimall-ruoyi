package com.gulimall.product.service.impl;

import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.product.mapper.SpuInfoMapper;
import com.gulimall.product.domain.SpuInfo;
import com.gulimall.product.service.ISpuInfoService;

/**
 * spu信息Service业务层处理
 * 
 * @author yebo
 * @date 2025-01-11
 */
@Service
public class SpuInfoServiceImpl implements ISpuInfoService 
{
    @Autowired
    private SpuInfoMapper spuInfoMapper;

    /**
     * 查询spu信息
     * 
     * @param id spu信息主键
     * @return spu信息
     */
    @Override
    public SpuInfo selectSpuInfoById(Long id)
    {
        return spuInfoMapper.selectSpuInfoById(id);
    }

    /**
     * 查询spu信息列表
     * 
     * @param spuInfo spu信息
     * @return spu信息
     */
    @Override
    public List<SpuInfo> selectSpuInfoList(SpuInfo spuInfo)
    {
        return spuInfoMapper.selectSpuInfoList(spuInfo);
    }

    /**
     * 新增spu信息
     * 
     * @param spuInfo spu信息
     * @return 结果
     */
    @Override
    public int insertSpuInfo(SpuInfo spuInfo)
    {
        spuInfo.setCreateTime(DateUtils.getNowDate());
        return spuInfoMapper.insertSpuInfo(spuInfo);
    }

    /**
     * 修改spu信息
     * 
     * @param spuInfo spu信息
     * @return 结果
     */
    @Override
    public int updateSpuInfo(SpuInfo spuInfo)
    {
        spuInfo.setUpdateTime(DateUtils.getNowDate());
        return spuInfoMapper.updateSpuInfo(spuInfo);
    }

    /**
     * 批量删除spu信息
     * 
     * @param ids 需要删除的spu信息主键
     * @return 结果
     */
    @Override
    public int deleteSpuInfoByIds(Long[] ids)
    {
        return spuInfoMapper.deleteSpuInfoByIds(ids);
    }

    /**
     * 删除spu信息信息
     * 
     * @param id spu信息主键
     * @return 结果
     */
    @Override
    public int deleteSpuInfoById(Long id)
    {
        return spuInfoMapper.deleteSpuInfoById(id);
    }
}
