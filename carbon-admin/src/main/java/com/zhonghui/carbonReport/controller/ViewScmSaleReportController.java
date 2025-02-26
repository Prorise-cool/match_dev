package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.RepContractDeliveryReturnDetail;
import com.zhonghui.carbonReport.domain.ViewScmSaleContract;
import com.zhonghui.carbonReport.domain.ViewScmSaleContractDetails;
import com.zhonghui.carbonReport.service.IViewScmSaleContractDetailsService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 销售报表统计Controller
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Api(tags = {"供应链SCM-销售报表统计"})
@RestController
@RequestMapping("/carbonReport/scmSale")
public class ViewScmSaleReportController extends BaseController
{
    @Autowired
    private IViewScmSaleContractDetailsService viewScmSaleContractDetailsService;

    @Autowired
    private IViewScmSaleContractService viewScmSaleContractService;

    /**
     * 查询销售合同明细报表列表
     */
    @ApiOperation("查询销售合同明细列表")
    @GetMapping("/list")
    public TableDataInfo<List<ViewScmSaleContractDetails>> list(ViewScmSaleContractDetails viewScmSaleContractDetails)
    {
        startPage();
        List<ViewScmSaleContractDetails> list = viewScmSaleContractDetailsService.selectViewScmSaleContractDetailsList(viewScmSaleContractDetails);
        return getDataTable(list);
    }

    /**
     * 导出销售合同明细报表列表
     */
    @ApiOperation("导出销售合同明细列表")
    @Log(title = "销售合同明细报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ViewScmSaleContractDetails viewScmSaleContractDetails)
    {
        List<ViewScmSaleContractDetails> list = viewScmSaleContractDetailsService.selectViewScmSaleContractDetailsList(viewScmSaleContractDetails);
        ExcelUtil<ViewScmSaleContractDetails> util = new ExcelUtil<ViewScmSaleContractDetails>(ViewScmSaleContractDetails.class);
        util.exportExcel(response, list, "销售合同明细报表数据");
    }

    /**
     * 销售台账
     */
    @GetMapping("/saleBook/list")
    @ApiOperation("销售台账")
    public TableDataInfo saleBookList(ViewScmSaleContractDetails viewScmSaleContractDetails) {
        startPage();
        List<ViewScmSaleContractDetails> list = viewScmSaleContractDetailsService.selectSaleBookReport(viewScmSaleContractDetails);
        return getDataTable(list);
    }

    /**
     * 导出销售台账
     */
    @ApiOperation("导出销售台账")
    @Log(title = "销售台账", businessType = BusinessType.EXPORT)
    @PostMapping("/saleBook/export")
    public void exportSaleBook(HttpServletResponse response, ViewScmSaleContractDetails viewScmSaleContractDetails) {
        List<ViewScmSaleContractDetails> list = viewScmSaleContractDetailsService.selectSaleBookReport(viewScmSaleContractDetails);
        ExcelUtil<ViewScmSaleContractDetails> util = new ExcelUtil<ViewScmSaleContractDetails>(ViewScmSaleContractDetails.class);
        util.exportExcel(response, list, "销售台账");
    }

    /**
     * 查询月销售合同报表列表
     */
    @GetMapping("/saleContractReport/byMonth")
    @ApiOperation("查询销售合同报表列表")
    public TableDataInfo selectMonthSaleContractReport(ViewScmSaleContract viewScmSaleContract) {
        startPage();
        List<ViewScmSaleContract> list = viewScmSaleContractService.selectMonthSaleContractReport(viewScmSaleContract);
        return getDataTable(list);
    }

    /**
     * 导出销售合同报表列表
     */
    @ApiOperation("导出销售合同报表列表")
    @Log(title = "销售合同报表", businessType = BusinessType.EXPORT)
    @GetMapping("/saleContractReport/month/export")
    public AjaxResult export(ViewScmSaleContract viewScmSaleContract) {
        List<ViewScmSaleContract> list = viewScmSaleContractService.selectViewScmSaleContractList(viewScmSaleContract);
        ExcelUtil<ViewScmSaleContract> util = new ExcelUtil<ViewScmSaleContract>(ViewScmSaleContract.class);
        return util.exportExcel(list, "saleContractReport");
    }

    @GetMapping("/contractDeliveryReturnReport/byMonth")
    @ApiOperation("按月份统计销售-发货-退货报表")
    public TableDataInfo selectContractDeliveryReturnMonthReport(RepContractDeliveryReturnDetail contractDeliveryReturnDetail) {
        startPage();
        List<RepContractDeliveryReturnDetail> list = viewScmSaleContractDetailsService.selectContractDeliveryReturnMonthReport(contractDeliveryReturnDetail);
        return getDataTable(list);
    }

    @GetMapping("/contractDeliveryReturnReport/byQuarter")
    @ApiOperation("按季度统计销售-发货-退货报表")
    public TableDataInfo selectContractDeliveryReturnQuarterReport(RepContractDeliveryReturnDetail contractDeliveryReturnDetail) {
        startPage();
        List<RepContractDeliveryReturnDetail> list = viewScmSaleContractDetailsService.selectContractDeliveryReturnQuarterReport(contractDeliveryReturnDetail);
        return getDataTable(list);
    }

}
