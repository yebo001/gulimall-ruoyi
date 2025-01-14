package com.gulimall.member.service.impl;

import java.util.List;
import com.gulimall.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.MemberCollectSpuMapper;
import com.gulimall.member.domain.MemberCollectSpu;
import com.gulimall.member.service.IMemberCollectSpuService;

/**
 * 会员收藏的商品Service业务层处理
 * 
 * @author yebo
 * @date 2025-01-12
 */
@Service
public class MemberCollectSpuServiceImpl implements IMemberCollectSpuService 
{
    @Autowired
    private MemberCollectSpuMapper memberCollectSpuMapper;

    /**
     * 查询会员收藏的商品
     * 
     * @param id 会员收藏的商品主键
     * @return 会员收藏的商品
     */
    @Override
    public MemberCollectSpu selectMemberCollectSpuById(Long id)
    {
        return memberCollectSpuMapper.selectMemberCollectSpuById(id);
    }

    /**
     * 查询会员收藏的商品列表
     * 
     * @param memberCollectSpu 会员收藏的商品
     * @return 会员收藏的商品
     */
    @Override
    public List<MemberCollectSpu> selectMemberCollectSpuList(MemberCollectSpu memberCollectSpu)
    {
        return memberCollectSpuMapper.selectMemberCollectSpuList(memberCollectSpu);
    }

    /**
     * 新增会员收藏的商品
     * 
     * @param memberCollectSpu 会员收藏的商品
     * @return 结果
     */
    @Override
    public int insertMemberCollectSpu(MemberCollectSpu memberCollectSpu)
    {
        memberCollectSpu.setCreateTime(DateUtils.getNowDate());
        return memberCollectSpuMapper.insertMemberCollectSpu(memberCollectSpu);
    }

    /**
     * 修改会员收藏的商品
     * 
     * @param memberCollectSpu 会员收藏的商品
     * @return 结果
     */
    @Override
    public int updateMemberCollectSpu(MemberCollectSpu memberCollectSpu)
    {
        return memberCollectSpuMapper.updateMemberCollectSpu(memberCollectSpu);
    }

    /**
     * 批量删除会员收藏的商品
     * 
     * @param ids 需要删除的会员收藏的商品主键
     * @return 结果
     */
    @Override
    public int deleteMemberCollectSpuByIds(Long[] ids)
    {
        return memberCollectSpuMapper.deleteMemberCollectSpuByIds(ids);
    }

    /**
     * 删除会员收藏的商品信息
     * 
     * @param id 会员收藏的商品主键
     * @return 结果
     */
    @Override
    public int deleteMemberCollectSpuById(Long id)
    {
        return memberCollectSpuMapper.deleteMemberCollectSpuById(id);
    }
}
