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
import com.gulimall.member.domain.MemberLevel;
import com.gulimall.member.service.IMemberLevelService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 会员等级Controller
 * 
 * @author yebo
 * @date 2025-01-12
 */
@RestController
@RequestMapping("/level")
public class MemberLevelController extends BaseController
{
    @Autowired
    private IMemberLevelService memberLevelService;

    /**
     * 查询会员等级列表
     */
//@RequiresPermissions("member:level:list")
    @GetMapping("/list")
    public TableDataInfo list(MemberLevel memberLevel)
    {
        startPage();
        List<MemberLevel> list = memberLevelService.selectMemberLevelList(memberLevel);
        return getDataTable(list);
    }

    /**
     * 导出会员等级列表
     */
    //@RequiresPermissions("member:level:export")
    @Log(title = "会员等级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberLevel memberLevel)
    {
        List<MemberLevel> list = memberLevelService.selectMemberLevelList(memberLevel);
        ExcelUtil<MemberLevel> util = new ExcelUtil<MemberLevel>(MemberLevel.class);
        util.exportExcel(response, list, "会员等级数据");
    }

    /**
     * 获取会员等级详细信息
     */
    //@RequiresPermissions("member:level:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(memberLevelService.selectMemberLevelById(id));
    }

    /**
     * 新增会员等级
     */
    //@RequiresPermissions("member:level:add")
    @Log(title = "会员等级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberLevel memberLevel)
    {
        return toAjax(memberLevelService.insertMemberLevel(memberLevel));
    }

    /**
     * 修改会员等级
     */
    // @RequiresPermissions("member:level:edit")
    @Log(title = "会员等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberLevel memberLevel)
    {
        return toAjax(memberLevelService.updateMemberLevel(memberLevel));
    }

    /**
     * 删除会员等级
     */
    //@RequiresPermissions("member:level:remove")
    @Log(title = "会员等级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(memberLevelService.deleteMemberLevelByIds(ids));
    }
}
