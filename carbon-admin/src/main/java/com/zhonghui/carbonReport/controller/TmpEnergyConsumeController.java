package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.TmpEnergyConsume;
import com.zhonghui.carbonReport.service.ITmpEnergyConsumeService;
import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 能耗临时Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags="能耗临时")
@RestController
@RequestMapping("/carbonReport/tpmEnergyConsume")
public class TmpEnergyConsumeController extends BaseController
{
    @Autowired
    private ITmpEnergyConsumeService tmpEnergyConsumeService;

    /**
     * 查询能耗临时列表
     */
    @ApiOperation("查询能耗临时列表")
    @GetMapping("/list")
    public TableDataInfo<List<TmpEnergyConsume>> list(TmpEnergyConsume tmpEnergyConsume)
    {
        startPage();
        List<TmpEnergyConsume> list = tmpEnergyConsumeService.selectTmpEnergyConsumeList(tmpEnergyConsume);
        return getDataTable(list);
    }

    /**
     * 导出能耗临时列表
     */
    @ApiOperation("导出能耗临时列表")
    @Log(title = "能耗临时", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TmpEnergyConsume tmpEnergyConsume)
    {
        List<TmpEnergyConsume> list = tmpEnergyConsumeService.selectTmpEnergyConsumeList(tmpEnergyConsume);
        ExcelUtil<TmpEnergyConsume> util = new ExcelUtil<TmpEnergyConsume>(TmpEnergyConsume.class);
        util.exportExcel(response, list, "能耗临时数据");
    }

    /**
     * 获取能耗临时详细信息
     */
    @ApiOperation("获取能耗临时详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult<TmpEnergyConsume> getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(tmpEnergyConsumeService.selectTmpEnergyConsumeById(id));
    }

    /**
     * 新增能耗临时
     */
    @ApiOperation("新增能耗临时")
    @Log(title = "能耗临时", businessType = BusinessType.INSERT)
    @PostMapping
    public BaseResult<Integer> add(@RequestBody TmpEnergyConsume tmpEnergyConsume)
    {
        return BaseResult.success(tmpEnergyConsumeService.insertTmpEnergyConsume(tmpEnergyConsume));
    }

    /**
     * 修改能耗临时
     */
    @ApiOperation("修改能耗临时")
    @Log(title = "能耗临时", businessType = BusinessType.UPDATE)
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody TmpEnergyConsume tmpEnergyConsume)
    {
        return BaseResult.success(tmpEnergyConsumeService.updateTmpEnergyConsume(tmpEnergyConsume));
    }

    /**
     * 删除能耗临时
     */
    @ApiOperation("删除能耗临时")
    @Log(title = "能耗临时", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public BaseResult<Integer> remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(tmpEnergyConsumeService.deleteTmpEnergyConsumeByIds(ids));
    }
}
