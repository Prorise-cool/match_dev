package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.ViewScmPurchasingContract;
import com.zhonghui.carbonReport.service.IViewScmPurchasingContractService;
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
 * 采购合同报表Controller
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Api(tags = {"供应链SCM-采购合同报表"})
@RestController
@RequestMapping("/carbonReport/purchasingContract")
public class ViewScmPurchasingContractController extends BaseController
{
    @Autowired
    private IViewScmPurchasingContractService viewScmPurchasingContractService;

    /**
     * 查询采购合同报表列表
     */
    @ApiOperation("查询采购合同报表列表")
    @GetMapping("/list")
    public TableDataInfo<List<ViewScmPurchasingContract>> list(ViewScmPurchasingContract viewScmPurchasingContract)
    {
        startPage();
        List<ViewScmPurchasingContract> list = viewScmPurchasingContractService.selectViewScmPurchasingContractList(viewScmPurchasingContract);
        return getDataTable(list);
    }

    /**
     * 导出采购合同报表列表
     */
    @ApiOperation("导出采购合同报表列表")
    @Log(title = "采购合同报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ViewScmPurchasingContract viewScmPurchasingContract)
    {
        List<ViewScmPurchasingContract> list = viewScmPurchasingContractService.selectViewScmPurchasingContractList(viewScmPurchasingContract);
        ExcelUtil<ViewScmPurchasingContract> util = new ExcelUtil<ViewScmPurchasingContract>(ViewScmPurchasingContract.class);
        util.exportExcel(response, list, "采购合同报表数据");
    }

    /**
     * 获取采购合同报表详细信息
     */
    @ApiOperation("获取采购合同报表详细信息")
    @GetMapping(value = "/{contractId}")
    public BaseResult<ViewScmPurchasingContract> getInfo(@PathVariable("contractId") Long contractId)
    {
        return BaseResult.success(viewScmPurchasingContractService.selectViewScmPurchasingContractByContractId(contractId));
    }

    @GetMapping("/byMonth")
    @ApiOperation("月份统计采购付款")
    public TableDataInfo selectMonthReport(ViewScmPurchasingContract viewScmPurchasingContract) {
        startPage();
        List<ViewScmPurchasingContract> list = viewScmPurchasingContractService.selectMonthReport(viewScmPurchasingContract);
        return getDataTable(list);
    }


    @GetMapping("/byQuarter")
    @ApiOperation("季度统计采购付款")
    public TableDataInfo selectQuarterReport(ViewScmPurchasingContract viewScmPurchasingContract) {
        startPage();
        List<ViewScmPurchasingContract> list = viewScmPurchasingContractService.selectQuarterReport(viewScmPurchasingContract);
        return getDataTable(list);
    }

    @GetMapping("/supplier/byMonth")
    @ApiOperation("月份统计供应商对账")
    public TableDataInfo selectMonthSupplierReport(ViewScmPurchasingContract viewScmPurchasingContract) {
        startPage();
        List<ViewScmPurchasingContract> list = viewScmPurchasingContractService.selectMonthSupplierReport(viewScmPurchasingContract);
        return getDataTable(list);
    }

    @GetMapping("/supplier/byQuarter")
    @ApiOperation("季度统计供应商对账")
    public TableDataInfo selectQuarterSupplierReport(ViewScmPurchasingContract viewScmPurchasingContract) {
        startPage();
        List<ViewScmPurchasingContract> list = viewScmPurchasingContractService.selectQuarterSupplierReport(viewScmPurchasingContract);
        return getDataTable(list);
    }

}
