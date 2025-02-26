package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.ViewWmsMaterialInventoryDetails;
import com.zhonghui.carbonReport.service.IViewWmsMaterialInventoryDetailsService;
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
 * 库存明细报表Controller
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
@Api(tags = {"智能仓储WMS-库存明细报表"})
@RestController
@RequestMapping("/carbonReport/materialInventoryDetails")
public class ViewWmsMaterialInventoryDetailsController extends BaseController
{
    @Autowired
    private IViewWmsMaterialInventoryDetailsService viewWmsMaterialInventoryDetailsService;

    /**
     * 查询库存明细报表列表
     */
    @ApiOperation("查询库存明细报表列表")
    @GetMapping("/list")
    public TableDataInfo<List<ViewWmsMaterialInventoryDetails>> list(ViewWmsMaterialInventoryDetails viewWmsMaterialInventoryDetails)
    {
        startPage();
        List<ViewWmsMaterialInventoryDetails> list = viewWmsMaterialInventoryDetailsService.selectViewWmsMaterialInventoryDetailsList(viewWmsMaterialInventoryDetails);
        return getDataTable(list);
    }

    /**
     * 导出库存明细报表列表
     */
    @ApiOperation("导出库存明细报表列表")
    @Log(title = "库存明细报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ViewWmsMaterialInventoryDetails viewWmsMaterialInventoryDetails)
    {
        List<ViewWmsMaterialInventoryDetails> list = viewWmsMaterialInventoryDetailsService.selectViewWmsMaterialInventoryDetailsList(viewWmsMaterialInventoryDetails);
        ExcelUtil<ViewWmsMaterialInventoryDetails> util = new ExcelUtil<ViewWmsMaterialInventoryDetails>(ViewWmsMaterialInventoryDetails.class);
        util.exportExcel(response, list, "库存明细报表数据");
    }

    /**
     * 获取库存明细报表详细信息
     */
    @ApiOperation("获取库存明细报表详细信息")
    @GetMapping(value = "/{warehouseId}")
    public BaseResult<ViewWmsMaterialInventoryDetails> getInfo(@PathVariable("warehouseId") Long warehouseId)
    {
        return BaseResult.success(viewWmsMaterialInventoryDetailsService.selectViewWmsMaterialInventoryDetailsById(warehouseId));
    }
}
