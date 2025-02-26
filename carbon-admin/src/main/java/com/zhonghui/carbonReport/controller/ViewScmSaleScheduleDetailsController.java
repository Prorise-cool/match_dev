package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.ViewScmSaleContractDetails;
import com.zhonghui.carbonReport.domain.ViewScmSaleScheduleDetails;
import com.zhonghui.carbonReport.service.IViewScmSaleContractDetailsService;
import com.zhonghui.carbonReport.service.IViewScmSaleScheduleDetailsService;
import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
import com.zhonghui.common.core.domain.AjaxResult;
import com.zhonghui.common.core.page.TableDataInfo;
import com.zhonghui.common.enums.BusinessType;
import com.zhonghui.common.utils.DateUtils;
import com.zhonghui.common.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * 销售计划达成率报表Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags = {"供应链SCM-销售计划达成率报表"})
@RestController
@RequestMapping("/carbonReport/saleScheduleDetails")
public class ViewScmSaleScheduleDetailsController extends BaseController
{
    @Autowired
    private IViewScmSaleScheduleDetailsService viewScmSaleScheduleDetailsService;

    @Autowired
    private IViewScmSaleContractDetailsService viewScmSaleContractDetailsService;

    /**
     * 查询销售计划达成率报表列表
     */
    @ApiOperation("查询销售计划达成率报表列表")
    @GetMapping("/list")
    public TableDataInfo<List<ViewScmSaleScheduleDetails>> list(ViewScmSaleScheduleDetails viewScmSaleScheduleDetails)
    {
        startPage();
        List<ViewScmSaleScheduleDetails> list = viewScmSaleScheduleDetailsService.selectViewScmSaleScheduleDetailsList(viewScmSaleScheduleDetails);
        list.stream().forEach(item -> {
            ViewScmSaleContractDetails viewScmSaleContractDetails = new ViewScmSaleContractDetails();
            viewScmSaleContractDetails.getParams().put("beginSignDate", DateUtils.dateTime(item.getStartDate()));
            viewScmSaleContractDetails.getParams().put("endSignDate", DateUtils.dateTime(item.getEndDate()));
            viewScmSaleContractDetails.setMaterialId(item.getMaterialId());
            List<ViewScmSaleContractDetails> detailList = viewScmSaleContractDetailsService.selectViewScmSaleContractDetailsList(viewScmSaleContractDetails);
            BigDecimal saleAmount = new BigDecimal("0");
            for (ViewScmSaleContractDetails detail : detailList) {
                saleAmount = saleAmount.add(detail.getTotalAmount());
            }
            item.setSaleAmount(saleAmount);
        });
        return getDataTable(list);
    }

    /**
     * 导出销售计划达成率报表列表
     */
    @ApiOperation("导出销售计划达成率报表列表")
    @Log(title = "销售计划达成率报表", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ViewScmSaleScheduleDetails viewScmSaleScheduleDetails) {
        List<ViewScmSaleScheduleDetails> list = viewScmSaleScheduleDetailsService.selectViewScmSaleScheduleDetailsList(viewScmSaleScheduleDetails);
        list.stream().forEach(item -> {
            ViewScmSaleContractDetails viewScmSaleContractDetails = new ViewScmSaleContractDetails();
            viewScmSaleContractDetails.getParams().put("beginSignDate", DateUtils.dateTime(item.getStartDate()));
            viewScmSaleContractDetails.getParams().put("endSignDate", DateUtils.dateTime(item.getEndDate()));
            viewScmSaleContractDetails.setMaterialId(item.getMaterialId());
            List<ViewScmSaleContractDetails> detailList = viewScmSaleContractDetailsService.selectViewScmSaleContractDetailsList(viewScmSaleContractDetails);
            BigDecimal saleAmount = new BigDecimal("0");
            for (ViewScmSaleContractDetails detail : detailList) {
                saleAmount = saleAmount.add(detail.getTotalAmount());
            }
            item.setSaleAmount(saleAmount);
            if (saleAmount.compareTo(item.getSales()) >= 0) {
                item.setStatus("1");
            }
        });
        ExcelUtil<ViewScmSaleScheduleDetails> util = new ExcelUtil<ViewScmSaleScheduleDetails>(ViewScmSaleScheduleDetails.class);
        return util.exportExcel(list, "saleScheduleDetailsReport");
    }
}
