package com.gulimall.product.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gulimall.common.core.annotation.Excel;
import com.gulimall.common.core.web.domain.BaseEntity;

/**
 * spu信息对象 pms_spu_info
 * 
 * @author yebo
 * @date 2025-01-11
 */
public class SpuInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long id;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String spuName;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String spuDescription;

    /** 所属分类id */
    @Excel(name = "所属分类id")
    private Long catalogId;

    /** 品牌id */
    @Excel(name = "品牌id")
    private Long brandId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal weight;

    /** 上架状态[0 - 下架，1 - 上架] */
    @Excel(name = "上架状态[0 - 下架，1 - 上架]")
    private Integer publishStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSpuName(String spuName) 
    {
        this.spuName = spuName;
    }

    public String getSpuName() 
    {
        return spuName;
    }
    public void setSpuDescription(String spuDescription) 
    {
        this.spuDescription = spuDescription;
    }

    public String getSpuDescription() 
    {
        return spuDescription;
    }
    public void setCatalogId(Long catalogId) 
    {
        this.catalogId = catalogId;
    }

    public Long getCatalogId() 
    {
        return catalogId;
    }
    public void setBrandId(Long brandId) 
    {
        this.brandId = brandId;
    }

    public Long getBrandId() 
    {
        return brandId;
    }
    public void setWeight(BigDecimal weight) 
    {
        this.weight = weight;
    }

    public BigDecimal getWeight() 
    {
        return weight;
    }
    public void setPublishStatus(Integer publishStatus) 
    {
        this.publishStatus = publishStatus;
    }

    public Integer getPublishStatus() 
    {
        return publishStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("spuName", getSpuName())
            .append("spuDescription", getSpuDescription())
            .append("catalogId", getCatalogId())
            .append("brandId", getBrandId())
            .append("weight", getWeight())
            .append("publishStatus", getPublishStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
