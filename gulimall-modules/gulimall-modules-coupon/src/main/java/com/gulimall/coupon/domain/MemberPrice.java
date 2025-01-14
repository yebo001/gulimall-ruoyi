package com.gulimall.coupon.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.gulimall.common.core.annotation.Excel;
import com.gulimall.common.core.web.domain.BaseEntity;

/**
 * 商品会员价格对象 sms_member_price
 * 
 * @author yebo
 * @date 2025-01-12
 */
public class MemberPrice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** sku_id */
    @Excel(name = "sku_id")
    private Long skuId;

    /** 会员等级id */
    @Excel(name = "会员等级id")
    private Long memberLevelId;

    /** 会员等级名 */
    @Excel(name = "会员等级名")
    private String memberLevelName;

    /** 会员对应价格 */
    @Excel(name = "会员对应价格")
    private BigDecimal memberPrice;

    /** 可否叠加其他优惠[0-不可叠加优惠，1-可叠加] */
    @Excel(name = "可否叠加其他优惠[0-不可叠加优惠，1-可叠加]")
    private Integer addOther;

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
    public void setMemberLevelId(Long memberLevelId) 
    {
        this.memberLevelId = memberLevelId;
    }

    public Long getMemberLevelId() 
    {
        return memberLevelId;
    }
    public void setMemberLevelName(String memberLevelName) 
    {
        this.memberLevelName = memberLevelName;
    }

    public String getMemberLevelName() 
    {
        return memberLevelName;
    }
    public void setMemberPrice(BigDecimal memberPrice) 
    {
        this.memberPrice = memberPrice;
    }

    public BigDecimal getMemberPrice() 
    {
        return memberPrice;
    }
    public void setAddOther(Integer addOther) 
    {
        this.addOther = addOther;
    }

    public Integer getAddOther() 
    {
        return addOther;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("skuId", getSkuId())
            .append("memberLevelId", getMemberLevelId())
            .append("memberLevelName", getMemberLevelName())
            .append("memberPrice", getMemberPrice())
            .append("addOther", getAddOther())
            .toString();
    }
}
