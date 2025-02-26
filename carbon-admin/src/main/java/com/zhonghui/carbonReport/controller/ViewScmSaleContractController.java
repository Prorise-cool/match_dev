package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.ViewScmFinanceReport;
import com.zhonghui.carbonReport.domain.ViewScmSaleContract;
import com.zhonghui.carbonReport.service.IViewScmSaleContractService;
import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.domain.AjaxResult;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 销售合同报表Controller
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Api(tags="供应链SCM-销售合同报表")
@RestController
@RequestMapping("/carbonReport/saleContract")
public class ViewScmSaleContractController extends BaseController
{
    @Autowired
    private IViewScmSaleContractService viewScmSaleContractService;

    /**
     * 查询按月统计销售合同报表列表
     */
    @GetMapping("/byMonth")
    @ApiOperation("查询按月统计销售合同报表列表")
    public TableDataInfo<List<ViewScmSaleContract>> listByMonth(ViewScmSaleContract viewScmSaleContract) {
        startPage();
        List<ViewScmSaleContract> list = viewScmSaleContractService.selectMonthSaleContractReport(viewScmSaleContract);
        return getDataTable(list);
    }

    /**
     * 查询按季度统计销售合同报表列表
     */
    @GetMapping("/byQuarter")
    @ApiOperation("查询按季度统计销售合同报表列表")
    public TableDataInfo listByQuarter(ViewScmSaleContract viewScmSaleContract) {
        startPage();
        List<ViewScmSaleContract> list = viewScmSaleContractService.selectQuarterSaleContractReport(viewScmSaleContract);
        return getDataTable(list);
    }

    /**
     * 导出按月统计销售合同报表列表
     */
    @ApiOperation("导出按月统计销售合同报表列表")
    @PreAuthorize("@ss.hasPermi('saleReport:saleContractReport:export')")
    @Log(title = "按月统计销售合同报表列表", businessType = BusinessType.EXPORT)
    @GetMapping("/export/byMonth")
    public AjaxResult exportByMonth(ViewScmSaleContract viewScmSaleContract) {
        List<ViewScmSaleContract> list = viewScmSaleContractService.selectMonthSaleContractReport(viewScmSaleContract);
        ExcelUtil<ViewScmSaleContract> util = new ExcelUtil<ViewScmSaleContract>(ViewScmSaleContract.class);
        return util.exportExcel(list, "月统计销售合同报表");
    }

    /**
     * 导出按季度统计销售合同报表列表
     */
    @ApiOperation("导出按季度统计销售合同报表列表")
    @Log(title = "按季度统计销售合同报表列表", businessType = BusinessType.EXPORT)
    @GetMapping("/export/byQuarter")
    public AjaxResult exportByQuarter(ViewScmSaleContract viewScmSaleContract) {
        List<ViewScmSaleContract> list = viewScmSaleContractService.selectQuarterSaleContractReport(viewScmSaleContract);
        ExcelUtil<ViewScmSaleContract> util = new ExcelUtil<ViewScmSaleContract>(ViewScmSaleContract.class);
        return util.exportExcel(list, "季度统计销售合同报表");
    }

    /**
     * 查询订单收款月统计
     */
    @GetMapping("/orderStat/byMonth")
    @ApiOperation("查询订单收款月统计")
    public TableDataInfo orderStatByMonth(ViewScmSaleContract viewScmSaleContract) {
        startPage();
        List<ViewScmSaleContract> list = viewScmSaleContractService.selectMonthOrderStatReport(viewScmSaleContract);
        return getDataTable(list);
    }

    /**
     * 查询订单收款季度统计
     */
    @GetMapping("/orderStat/byQuarter")
    @ApiOperation("查询订单收款季度统计")
    public TableDataInfo orderStatByQuarter(ViewScmSaleContract viewScmSaleContract) {
        startPage();
        List<ViewScmSaleContract> list = viewScmSaleContractService.selectQuarterOrderStatReport(viewScmSaleContract);
        return getDataTable(list);
    }

    /**
     * 财务收支月份统计
     */
    @GetMapping("/financeReport/byMonth")
    @ApiOperation("财务收支月份统计")
    public TableDataInfo financeByMonth(ViewScmFinanceReport viewScmFinanceReport) {
        startPage();
        List<ViewScmFinanceReport> list = viewScmSaleContractService.selectMonthFinanceReport(viewScmFinanceReport);
        return getDataTable(list);
    }

    /**
     * 财务收支季度统计
     */
    @GetMapping("/financeReport/byQuarter")
    @ApiOperation("财务收支季度统计")
    public TableDataInfo financeByQuarter(ViewScmFinanceReport viewScmFinanceReport) {
        startPage();
        List<ViewScmFinanceReport> list = viewScmSaleContractService.selectQuarterFinanceReport(viewScmFinanceReport);
        return getDataTable(list);
    }
}
