package com.gulimall.ware.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gulimall.common.core.annotation.Excel;
import com.gulimall.common.core.web.domain.BaseEntity;

/**
 * 库存工作单对象 wms_ware_order_task_detail
 * 
 * @author yebo
 * @date 2025-01-12
 */
public class WareOrderTaskDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** sku_id */
    @Excel(name = "sku_id")
    private Long skuId;

    /** sku_name */
    @Excel(name = "sku_name")
    private String skuName;

    /** 购买个数 */
    @Excel(name = "购买个数")
    private Long skuNum;

    /** 工作单id */
    @Excel(name = "工作单id")
    private Long taskId;

    /** 仓库id */
    @Excel(name = "仓库id")
    private Long wareId;

    /** 1-已锁定  2-已解锁  3-扣减 */
    @Excel(name = "1-已锁定  2-已解锁  3-扣减")
    private Integer lockStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSkuId(Long skuId) 
    {
        this.skuId = skuId;
    }

    public Long getSkuId() 
    {
        return skuId;
    }
    public void setSkuName(String skuName) 
    {
        this.skuName = skuName;
    }

    public String getSkuName() 
    {
        return skuName;
    }
    public void setSkuNum(Long skuNum) 
    {
        this.skuNum = skuNum;
    }

    public Long getSkuNum() 
    {
        return skuNum;
    }
    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setWareId(Long wareId) 
    {
        this.wareId = wareId;
    }

    public Long getWareId() 
    {
        return wareId;
    }
    public void setLockStatus(Integer lockStatus) 
    {
        this.lockStatus = lockStatus;
    }

    public Integer getLockStatus() 
    {
        return lockStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("skuId", getSkuId())
            .append("skuName", getSkuName())
            .append("skuNum", getSkuNum())
            .append("taskId", getTaskId())
            .append("wareId", getWareId())
            .append("lockStatus", getLockStatus())
            .toString();
    }
}
