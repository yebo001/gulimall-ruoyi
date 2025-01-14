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
import com.gulimall.member.domain.MemberLoginLog;
import com.gulimall.member.service.IMemberLoginLogService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 会员登录记录Controller
 * 
 * @author yebo
 * @date 2025-01-12
 */
@RestController
@RequestMapping("/log")
public class MemberLoginLogController extends BaseController
{
    @Autowired
    private IMemberLoginLogService memberLoginLogService;

    /**
     * 查询会员登录记录列表
     */
//@RequiresPermissions("member:log:list")
    @GetMapping("/list")
    public TableDataInfo list(MemberLoginLog memberLoginLog)
    {
        startPage();
        List<MemberLoginLog> list = memberLoginLogService.selectMemberLoginLogList(memberLoginLog);
        return getDataTable(list);
    }

    /**
     * 导出会员登录记录列表
     */
    //@RequiresPermissions("member:log:export")
    @Log(title = "会员登录记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MemberLoginLog memberLoginLog)
    {
        List<MemberLoginLog> list = memberLoginLogService.selectMemberLoginLogList(memberLoginLog);
        ExcelUtil<MemberLoginLog> util = new ExcelUtil<MemberLoginLog>(MemberLoginLog.class);
        util.exportExcel(response, list, "会员登录记录数据");
    }

    /**
     * 获取会员登录记录详细信息
     */
    //@RequiresPermissions("member:log:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(memberLoginLogService.selectMemberLoginLogById(id));
    }

    /**
     * 新增会员登录记录
     */
    //@RequiresPermissions("member:log:add")
    @Log(title = "会员登录记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MemberLoginLog memberLoginLog)
    {
        return toAjax(memberLoginLogService.insertMemberLoginLog(memberLoginLog));
    }

    /**
     * 修改会员登录记录
     */
    // @RequiresPermissions("member:log:edit")
    @Log(title = "会员登录记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MemberLoginLog memberLoginLog)
    {
        return toAjax(memberLoginLogService.updateMemberLoginLog(memberLoginLog));
    }

    /**
     * 删除会员登录记录
     */
    //@RequiresPermissions("member:log:remove")
    @Log(title = "会员登录记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(memberLoginLogService.deleteMemberLoginLogByIds(ids));
    }
}
