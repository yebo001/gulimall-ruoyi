package com.gulimall.product.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gulimall.common.core.annotation.Excel;
import com.gulimall.common.core.web.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 商品三级分类对象 pms_category
 * 
 * @author yebo
 * @date 2025-01-11
 */
@Data
@TableName(value = "pms_category")
public class Category implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 分类id */
    private Long catId;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String name;

    /** 父分类id */
    @Excel(name = "父分类id")
    private Long parentCid;

    /** 层级 */
    @Excel(name = "层级")
    private Long catLevel;

    /** 是否显示[0-不显示，1显示] */
    @Excel(name = "是否显示[0-不显示，1显示]")
    @TableLogic(value = "1",delval = "0")
    private Integer showStatus;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 图标地址 */
    @Excel(name = "图标地址")
    private String icon;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String productUnit;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long productCount;

    /**
     * 所有子分类
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @TableField(exist = false)
    private List<Category> children;

}
