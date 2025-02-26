package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.ViewWmsOutWarehouseDetails;
import com.zhonghui.carbonReport.service.IViewWmsOutWarehouseDetailsService;
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
 * 物料出库明细报表Controller
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
@Api(tags = {"智能仓储WMS-物料出库明细报表"})
@RestController
@RequestMapping("/carbonReport/outWarehouseDetails")
public class ViewWmsOutWarehouseDetailsController extends BaseController
{
    @Autowired
    private IViewWmsOutWarehouseDetailsService viewWmsOutWarehouseDetailsService;

    /**
     * 查询物料出库明细报表列表
     */
    @ApiOperation("查询物料出库明细报表列表")
    @GetMapping("/list")
    public TableDataInfo<List<ViewWmsOutWarehouseDetails>> list(ViewWmsOutWarehouseDetails viewWmsOutWarehouseDetails)
    {
        startPage();
        List<ViewWmsOutWarehouseDetails> list = viewWmsOutWarehouseDetailsService.selectViewWmsOutWarehouseDetailsList(viewWmsOutWarehouseDetails);
        return getDataTable(list);
    }

    /**
     * 导出物料出库明细报表列表
     */
    @ApiOperation("导出物料出库明细报表列表")
    @Log(title = "物料出库明细报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ViewWmsOutWarehouseDetails viewWmsOutWarehouseDetails)
    {
        List<ViewWmsOutWarehouseDetails> list = viewWmsOutWarehouseDetailsService.selectViewWmsOutWarehouseDetailsList(viewWmsOutWarehouseDetails);
        ExcelUtil<ViewWmsOutWarehouseDetails> util = new ExcelUtil<ViewWmsOutWarehouseDetails>(ViewWmsOutWarehouseDetails.class);
        util.exportExcel(response, list, "物料出库明细报表数据");
    }

    /**
     * 获取物料出库明细报表详细信息
     */
    @ApiOperation("获取物料出库明细报表详细信息")
    @GetMapping(value = "/{materialId}")
    public BaseResult<ViewWmsOutWarehouseDetails> getInfo(@PathVariable("materialId") Long materialId)
    {
        return BaseResult.success(viewWmsOutWarehouseDetailsService.selectViewWmsOutWarehouseDetailsByMaterialId(materialId));
    }
}
