package com.gulimall.coupon.controller;

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
import com.gulimall.coupon.domain.SeckillSession;
import com.gulimall.coupon.service.ISeckillSessionService;
import com.gulimall.common.core.web.controller.BaseController;
import com.gulimall.common.core.web.domain.AjaxResult;
import com.gulimall.common.core.utils.poi.ExcelUtil;
import com.gulimall.common.core.web.page.TableDataInfo;

/**
 * 秒杀活动场次Controller
 * 
 * @author yebo
 * @date 2025-01-12
 */
@RestController
@RequestMapping("/session")
public class SeckillSessionController extends BaseController
{
    @Autowired
    private ISeckillSessionService seckillSessionService;

    /**
     * 查询秒杀活动场次列表
     */
//@RequiresPermissions("coupon:session:list")
    @GetMapping("/list")
    public TableDataInfo list(SeckillSession seckillSession)
    {
        startPage();
        List<SeckillSession> list = seckillSessionService.selectSeckillSessionList(seckillSession);
        return getDataTable(list);
    }

    /**
     * 导出秒杀活动场次列表
     */
    //@RequiresPermissions("coupon:session:export")
    @Log(title = "秒杀活动场次", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SeckillSession seckillSession)
    {
        List<SeckillSession> list = seckillSessionService.selectSeckillSessionList(seckillSession);
        ExcelUtil<SeckillSession> util = new ExcelUtil<SeckillSession>(SeckillSession.class);
        util.exportExcel(response, list, "秒杀活动场次数据");
    }

    /**
     * 获取秒杀活动场次详细信息
     */
    //@RequiresPermissions("coupon:session:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(seckillSessionService.selectSeckillSessionById(id));
    }

    /**
     * 新增秒杀活动场次
     */
    //@RequiresPermissions("coupon:session:add")
    @Log(title = "秒杀活动场次", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SeckillSession seckillSession)
    {
        return toAjax(seckillSessionService.insertSeckillSession(seckillSession));
    }

    /**
     * 修改秒杀活动场次
     */
    // @RequiresPermissions("coupon:session:edit")
    @Log(title = "秒杀活动场次", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SeckillSession seckillSession)
    {
        return toAjax(seckillSessionService.updateSeckillSession(seckillSession));
    }

    /**
     * 删除秒杀活动场次
     */
    //@RequiresPermissions("coupon:session:remove")
    @Log(title = "秒杀活动场次", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(seckillSessionService.deleteSeckillSessionByIds(ids));
    }
}
