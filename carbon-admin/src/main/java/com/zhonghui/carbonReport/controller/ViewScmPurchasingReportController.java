package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.ScmContractArriveReturnDetail;
import com.zhonghui.carbonReport.domain.ViewScmPurchasingContractDetails;
import com.zhonghui.carbonReport.domain.ViewScmPurchasingReturnDetails;
import com.zhonghui.carbonReport.service.IViewScmPurchasingContractDetailsService;
import com.zhonghui.carbonReport.service.IViewScmPurchasingReturnDetailsService;
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
 * 采购报表统计Controller
 *
 * @author zhonghui
 * @date 2022-05-28
 */
@Api(tags = {"供应链SCM-采购报表统计"})
@RestController
@RequestMapping("/carbonReport/scmPurchase")
public class ViewScmPurchasingReportController extends BaseController {

    @Autowired
    private IViewScmPurchasingContractDetailsService viewScmPurchasingContractDetailsService;

    @Autowired
    private IViewScmPurchasingReturnDetailsService viewScmPurchasingReturnDetailsService;

    /**
     * 查询采购物料列表
     */
    @GetMapping("/material/list")
    @ApiOperation("查询产品统计列表")
    public TableDataInfo<List<ViewScmPurchasingContractDetails>> list(ViewScmPurchasingContractDetails viewScmPurchasingContractDetails) {
        startPage();
        List<ViewScmPurchasingContractDetails> list = viewScmPurchasingContractDetailsService.selectViewScmPurchasingContractDetailsList(viewScmPurchasingContractDetails);
        return getDataTable(list);
    }

    /**
     * 导出采购物料列表
     */
    @ApiOperation("导出产品统计列表")
    @Log(title = "采购物料", businessType = BusinessType.EXPORT)
    @PostMapping("/material/export")
    public void export(HttpServletResponse response, ViewScmPurchasingContractDetails viewScmPurchasingContractDetails) {
        List<ViewScmPurchasingContractDetails> list = viewScmPurchasingContractDetailsService.selectViewScmPurchasingContractDetailsList(viewScmPurchasingContractDetails);
        ExcelUtil<ViewScmPurchasingContractDetails> util = new ExcelUtil<ViewScmPurchasingContractDetails>(ViewScmPurchasingContractDetails.class);
        util.exportExcel(response, list, "采购物料列表");
    }

    /**
     * 查询采购退货列表
     */
    @GetMapping("/return/list")
    @ApiOperation("查询采购退货列表")
    public TableDataInfo list(ViewScmPurchasingReturnDetails viewScmPurchasingContractDetails) {
        startPage();
        List<ViewScmPurchasingReturnDetails> list = viewScmPurchasingReturnDetailsService.selectViewScmPurchasingReturnDetailsList(viewScmPurchasingContractDetails);
        return getDataTable(list);
    }

    /**
     * 导出采购退货列表
     */
    @ApiOperation("导出采购退货列表")
    @Log(title = "采购退货", businessType = BusinessType.EXPORT)
    @GetMapping("/return/export")
    public AjaxResult export(ViewScmPurchasingReturnDetails viewScmPurchasingContractDetails) {
        List<ViewScmPurchasingReturnDetails> list = viewScmPurchasingReturnDetailsService.selectViewScmPurchasingReturnDetailsList(viewScmPurchasingContractDetails);
        ExcelUtil<ViewScmPurchasingReturnDetails> util = new ExcelUtil<ViewScmPurchasingReturnDetails>(ViewScmPurchasingReturnDetails.class);
        return util.exportExcel(list, "采购退货列表");
    }

    @GetMapping("/contractInWarehouseReturnReport/byMonth")
    @ApiOperation("按月采购-入库-退货报表")
    public TableDataInfo selectContractDeliveryReturnMonthReport(ScmContractArriveReturnDetail scmContractArriveReturnDetail) {
        startPage();
        List<ScmContractArriveReturnDetail> list = viewScmPurchasingContractDetailsService.selectContractArriveReturnMonthReport(scmContractArriveReturnDetail);
        return getDataTable(list);
    }

    @GetMapping("/contractInWarehouseReturnReport/byQuarter")
    @ApiOperation("按季度统计采购-入库-退货报表")
    public TableDataInfo selectContractDeliveryReturnQuarterReport(ScmContractArriveReturnDetail scmContractArriveReturnDetail) {
        startPage();
        List<ScmContractArriveReturnDetail> list = viewScmPurchasingContractDetailsService.selectContractArriveReturnQuarterReport(scmContractArriveReturnDetail);
        return getDataTable(list);
    }
}
