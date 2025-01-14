package com.gulimall.ware.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.ware.mapper.WareInfoMapper;
import com.gulimall.ware.domain.WareInfo;
import com.gulimall.ware.service.IWareInfoService;

/**
 * 仓库信息Service业务层处理
 * 
 * @author yebo
 * @date 2025-01-12
 */
@Service
public class WareInfoServiceImpl implements IWareInfoService 
{
    @Autowired
    private WareInfoMapper wareInfoMapper;

    /**
     * 查询仓库信息
     * 
     * @param id 仓库信息主键
     * @return 仓库信息
     */
    @Override
    public WareInfo selectWareInfoById(Long id)
    {
        return wareInfoMapper.selectWareInfoById(id);
    }

    /**
     * 查询仓库信息列表
     * 
     * @param wareInfo 仓库信息
     * @return 仓库信息
     */
    @Override
    public List<WareInfo> selectWareInfoList(WareInfo wareInfo)
    {
        return wareInfoMapper.selectWareInfoList(wareInfo);
    }

    /**
     * 新增仓库信息
     * 
     * @param wareInfo 仓库信息
     * @return 结果
     */
    @Override
    public int insertWareInfo(WareInfo wareInfo)
    {
        return wareInfoMapper.insertWareInfo(wareInfo);
    }

    /**
     * 修改仓库信息
     * 
     * @param wareInfo 仓库信息
     * @return 结果
     */
    @Override
    public int updateWareInfo(WareInfo wareInfo)
    {
        return wareInfoMapper.updateWareInfo(wareInfo);
    }

    /**
     * 批量删除仓库信息
     * 
     * @param ids 需要删除的仓库信息主键
     * @return 结果
     */
    @Override
    public int deleteWareInfoByIds(Long[] ids)
    {
        return wareInfoMapper.deleteWareInfoByIds(ids);
    }

    /**
     * 删除仓库信息信息
     * 
     * @param id 仓库信息主键
     * @return 结果
     */
    @Override
    public int deleteWareInfoById(Long id)
    {
        return wareInfoMapper.deleteWareInfoById(id);
    }
}
