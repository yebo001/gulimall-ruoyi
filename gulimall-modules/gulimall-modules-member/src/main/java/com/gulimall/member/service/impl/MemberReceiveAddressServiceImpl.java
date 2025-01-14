package com.gulimall.member.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gulimall.member.mapper.MemberReceiveAddressMapper;
import com.gulimall.member.domain.MemberReceiveAddress;
import com.gulimall.member.service.IMemberReceiveAddressService;

/**
 * 会员收货地址Service业务层处理
 * 
 * @author yebo
 * @date 2025-01-12
 */
@Service
public class MemberReceiveAddressServiceImpl implements IMemberReceiveAddressService 
{
    @Autowired
    private MemberReceiveAddressMapper memberReceiveAddressMapper;

    /**
     * 查询会员收货地址
     * 
     * @param id 会员收货地址主键
     * @return 会员收货地址
     */
    @Override
    public MemberReceiveAddress selectMemberReceiveAddressById(Long id)
    {
        return memberReceiveAddressMapper.selectMemberReceiveAddressById(id);
    }

    /**
     * 查询会员收货地址列表
     * 
     * @param memberReceiveAddress 会员收货地址
     * @return 会员收货地址
     */
    @Override
    public List<MemberReceiveAddress> selectMemberReceiveAddressList(MemberReceiveAddress memberReceiveAddress)
    {
        return memberReceiveAddressMapper.selectMemberReceiveAddressList(memberReceiveAddress);
    }

    /**
     * 新增会员收货地址
     * 
     * @param memberReceiveAddress 会员收货地址
     * @return 结果
     */
    @Override
    public int insertMemberReceiveAddress(MemberReceiveAddress memberReceiveAddress)
    {
        return memberReceiveAddressMapper.insertMemberReceiveAddress(memberReceiveAddress);
    }

    /**
     * 修改会员收货地址
     * 
     * @param memberReceiveAddress 会员收货地址
     * @return 结果
     */
    @Override
    public int updateMemberReceiveAddress(MemberReceiveAddress memberReceiveAddress)
    {
        return memberReceiveAddressMapper.updateMemberReceiveAddress(memberReceiveAddress);
    }

    /**
     * 批量删除会员收货地址
     * 
     * @param ids 需要删除的会员收货地址主键
     * @return 结果
     */
    @Override
    public int deleteMemberReceiveAddressByIds(Long[] ids)
    {
        return memberReceiveAddressMapper.deleteMemberReceiveAddressByIds(ids);
    }

    /**
     * 删除会员收货地址信息
     * 
     * @param id 会员收货地址主键
     * @return 结果
     */
    @Override
    public int deleteMemberReceiveAddressById(Long id)
    {
        return memberReceiveAddressMapper.deleteMemberReceiveAddressById(id);
    }
}
