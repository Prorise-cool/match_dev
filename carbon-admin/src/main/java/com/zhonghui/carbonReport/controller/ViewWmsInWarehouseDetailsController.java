package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.ViewWmsInWarehouseDetails;
import com.zhonghui.carbonReport.service.IViewWmsInWarehouseDetailsService;
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
 * 入库明细报表Controller
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
@Api(tags = {"智能仓储WMS-入库明细报表"})
@RestController
@RequestMapping("/carbonReport/inWarehouseDetails")
public class ViewWmsInWarehouseDetailsController extends BaseController
{
    @Autowired
    private IViewWmsInWarehouseDetailsService viewWmsInWarehouseDetailsService;

    /**
     * 查询入库明细报表列表
     */
    @ApiOperation("查询入库明细报表列表")
    @GetMapping("/list")
    public TableDataInfo<List<ViewWmsInWarehouseDetails>> list(ViewWmsInWarehouseDetails viewWmsInWarehouseDetails)
    {
        startPage();
        List<ViewWmsInWarehouseDetails> list = viewWmsInWarehouseDetailsService.selectViewWmsInWarehouseDetailsList(viewWmsInWarehouseDetails);
        return getDataTable(list);
    }

    /**
     * 导出入库明细报表列表
     */
    @ApiOperation("导出入库明细报表列表")
    @Log(title = "入库明细报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ViewWmsInWarehouseDetails viewWmsInWarehouseDetails)
    {
        List<ViewWmsInWarehouseDetails> list = viewWmsInWarehouseDetailsService.selectViewWmsInWarehouseDetailsList(viewWmsInWarehouseDetails);
        ExcelUtil<ViewWmsInWarehouseDetails> util = new ExcelUtil<ViewWmsInWarehouseDetails>(ViewWmsInWarehouseDetails.class);
        util.exportExcel(response, list, "入库明细报表数据");
    }

    /**
     * 获取入库明细报表详细信息
     */
    @ApiOperation("获取入库明细报表详细信息")
    @GetMapping(value = "/{materialId}")
    public BaseResult<ViewWmsInWarehouseDetails> getInfo(@PathVariable("materialId") Long materialId)
    {
        return BaseResult.success(viewWmsInWarehouseDetailsService.selectViewWmsInWarehouseDetailsById(materialId));
    }
}
