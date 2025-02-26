package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.ViewScmPurchasingArriveDetails;
import com.zhonghui.carbonReport.service.IViewScmPurchasingArriveDetailsService;
import com.zhonghui.common.annotation.Log;
import com.zhonghui.common.core.controller.BaseController;
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
 * 采购入库统计报表Controller
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Api(tags="供应链SCM-采购入库统计报表")
@RestController
@RequestMapping("/carbonReport/purchasingArriveDetails")
public class ViewScmPurchasingArriveDetailsController extends BaseController
{
    @Autowired
    private IViewScmPurchasingArriveDetailsService viewScmPurchasingArriveDetailsService;

    /**
     * 查询采购入库统计列表
     */
    @ApiOperation("查询采购入库统计列表")
    @GetMapping("/list")
    public TableDataInfo<List<ViewScmPurchasingArriveDetails>> list(ViewScmPurchasingArriveDetails viewScmPurchasingArriveDetails)
    {
        startPage();
        List<ViewScmPurchasingArriveDetails> list = viewScmPurchasingArriveDetailsService.selectViewScmPurchasingArriveDetailsList(viewScmPurchasingArriveDetails);
        return getDataTable(list);
    }

    /**
     * 导出采购入库统计列表
     */
    @ApiOperation("导出采购入库统计列表")
    @Log(title = "采购入库统计列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ViewScmPurchasingArriveDetails viewScmPurchasingArriveDetails)
    {
        List<ViewScmPurchasingArriveDetails> list = viewScmPurchasingArriveDetailsService.selectViewScmPurchasingArriveDetailsList(viewScmPurchasingArriveDetails);
        ExcelUtil<ViewScmPurchasingArriveDetails> util = new ExcelUtil<ViewScmPurchasingArriveDetails>(ViewScmPurchasingArriveDetails.class);
        util.exportExcel(response, list, "采购到货详细报表数据");
    }
}
