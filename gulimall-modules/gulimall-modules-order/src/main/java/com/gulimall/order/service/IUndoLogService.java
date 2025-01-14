package com.gulimall.order.service;

import java.util.List;
import com.gulimall.order.domain.UndoLog;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author yebo
 * @date 2025-01-12
 */
public interface IUndoLogService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public UndoLog selectUndoLogById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param undoLog 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<UndoLog> selectUndoLogList(UndoLog undoLog);

    /**
     * 新增【请填写功能名称】
     * 
     * @param undoLog 【请填写功能名称】
     * @return 结果
     */
    public int insertUndoLog(UndoLog undoLog);

    /**
     * 修改【请填写功能名称】
     * 
     * @param undoLog 【请填写功能名称】
     * @return 结果
     */
    public int updateUndoLog(UndoLog undoLog);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteUndoLogByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteUndoLogById(Long id);
}
