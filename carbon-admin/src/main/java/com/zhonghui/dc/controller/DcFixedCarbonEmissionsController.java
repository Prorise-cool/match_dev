package com.zhonghui.dc.controller;

import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import com.zhonghui.dc.domain.DcFixedCarbonEmissions;
import com.zhonghui.dc.service.IDcFixedCarbonEmissionsService;
import com.zhonghui.response.BaseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 固定碳排放Controller
 * 
 * @author zhonghui
 * @date 2022-05-24
 */
@Api(tags="智造双碳—固定碳排放")
@RestController
@RequestMapping("/dc/fixedEmissions")
public class DcFixedCarbonEmissionsController extends BaseController
{
    @Autowired
    private IDcFixedCarbonEmissionsService dcFixedCarbonEmissionsService;

    /**
     * 查询固定碳排放列表
     */
    @ApiOperation("查询固定碳排放列表")
    @GetMapping("/list")
    public TableDataInfo<List<DcFixedCarbonEmissions>> list(DcFixedCarbonEmissions dcFixedCarbonEmissions)
    {
        startPage();
        List<DcFixedCarbonEmissions> list = dcFixedCarbonEmissionsService.selectDcFixedCarbonEmissionsList(dcFixedCarbonEmissions);
        return getDataTable(list);
    }

    /**
     * 导出固定碳排放列表
     */
    @Log(title = "固定碳排放", businessType = BusinessType.EXPORT)
    @ApiOperation("导出固定碳排放列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcFixedCarbonEmissions dcFixedCarbonEmissions)
    {
        List<DcFixedCarbonEmissions> list = dcFixedCarbonEmissionsService.selectDcFixedCarbonEmissionsList(dcFixedCarbonEmissions);
        ExcelUtil<DcFixedCarbonEmissions> util = new ExcelUtil<DcFixedCarbonEmissions>(DcFixedCarbonEmissions.class);
        util.exportExcel(response, list, "固定碳排放数据");
    }

    /**
     * 获取固定碳排放详细信息
     */
    @ApiOperation("获取固定碳排放详细信息")
    @GetMapping(value = "/{id}")
    public BaseResult<DcFixedCarbonEmissions> getInfo(@PathVariable("id") Long id)
    {
        return BaseResult.success(dcFixedCarbonEmissionsService.selectDcFixedCarbonEmissionsById(id));
    }

    /**
     * 新增固定碳排放
     */
    @Log(title = "固定碳排放", businessType = BusinessType.INSERT)
    @ApiOperation("新增固定碳排放")
    @PostMapping
    public BaseResult<Integer> add(@RequestBody DcFixedCarbonEmissions dcFixedCarbonEmissions)
    {
        return BaseResult.success(dcFixedCarbonEmissionsService.insertDcFixedCarbonEmissions(dcFixedCarbonEmissions));
    }

    /**
     * 修改固定碳排放
     */
    @Log(title = "固定碳排放", businessType = BusinessType.UPDATE)
    @ApiOperation("修改固定碳排放")
    @PutMapping
    public BaseResult<Integer> edit(@RequestBody DcFixedCarbonEmissions dcFixedCarbonEmissions)
    {
        return BaseResult.success(dcFixedCarbonEmissionsService.updateDcFixedCarbonEmissions(dcFixedCarbonEmissions));
    }

    /**
     * 删除固定碳排放
     */
    @Log(title = "固定碳排放", businessType = BusinessType.DELETE)
    @ApiOperation("删除固定碳排放")
	@DeleteMapping("/{ids}")
    public BaseResult<Integer> remove(@PathVariable Long[] ids)
    {
        return BaseResult.success(dcFixedCarbonEmissionsService.deleteDcFixedCarbonEmissionsByIds(ids));
    }
}
