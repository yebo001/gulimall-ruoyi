package com.gulimall.member.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gulimall.common.log.annotation.Log;
import com.gulimall.common.log.enums.BusinessType;
import com.gulimall.member.domain.MemberStatisticsInfo;
import com.gulimall.member.service.IMemberStatisticsInfoService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 会员统计信息Controller
 * 
 * @author yebo
 * @date 2025-01-12
 */
@RestController
@RequestMapping("/info")
public class MemberStatisticsInfoController extends BaseController
{
    @Autowired
    private IMemberStatisticsInfoService memberStatisticsInfoService;

    /**
     * 查询会员统计信息列表
     */
//@RequiresPermissions("member:info:list")
    @GetMapping("/list")
    public TableDataInfo list(MemberStatisticsInfo memberStatisticsInfo)
    {
        startPage();
        List<MemberStatisticsInfo> list = memberStatisticsInfoService.selectMemberStatisticsInfoList(memberStatisticsInfo);
        return getDataTable(list);
    }

    /**
     * 导出会员统计信息列表
     */
    //@RequiresPermissions("member:info:export")
    @Log(title = "会员统计信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberStatisticsInfo memberStatisticsInfo)
    {
        List<MemberStatisticsInfo> list = memberStatisticsInfoService.selectMemberStatisticsInfoList(memberStatisticsInfo);
        ExcelUtil<MemberStatisticsInfo> util = new ExcelUtil<MemberStatisticsInfo>(MemberStatisticsInfo.class);
        util.exportExcel(response, list, "会员统计信息数据");
    }

    /**
     * 获取会员统计信息详细信息
     */
    //@RequiresPermissions("member:info:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(memberStatisticsInfoService.selectMemberStatisticsInfoById(id));
    }

    /**
     * 新增会员统计信息
     */
    //@RequiresPermissions("member:info:add")
    @Log(title = "会员统计信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberStatisticsInfo memberStatisticsInfo)
    {
        return toAjax(memberStatisticsInfoService.insertMemberStatisticsInfo(memberStatisticsInfo));
    }

    /**
     * 修改会员统计信息
     */
    // @RequiresPermissions("member:info:edit")
    @Log(title = "会员统计信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberStatisticsInfo memberStatisticsInfo)
    {
        return toAjax(memberStatisticsInfoService.updateMemberStatisticsInfo(memberStatisticsInfo));
    }

    /**
     * 删除会员统计信息
     */
    //@RequiresPermissions("member:info:remove")
    @Log(title = "会员统计信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(memberStatisticsInfoService.deleteMemberStatisticsInfoByIds(ids));
    }
}
