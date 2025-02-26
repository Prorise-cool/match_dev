package com.zhonghui.carbonReport.controller;

import com.zhonghui.carbonReport.domain.ViewScmSaleDeliveryDetails;
import com.zhonghui.carbonReport.service.IViewScmSaleDeliveryDetailsService;
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
 * 销售发货退货明细报表Controller
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Api(tags = {"供应链SCM-销售发货退货明细报表"})
@RestController
@RequestMapping("/carbonReport/saleDeliveryDetails")
public class ViewScmSaleDeliveryDetailsController extends BaseController
{
    @Autowired
    private IViewScmSaleDeliveryDetailsService viewScmSaleDeliveryDetailsService;

    /**
     * 查询销售发货退货明细报表列表
     */
    @ApiOperation("查询销售发货退货明细报表列表")
    @GetMapping("/list")
    public TableDataInfo<List<ViewScmSaleDeliveryDetails>> list(ViewScmSaleDeliveryDetails viewScmSaleDeliveryDetails)
    {
        startPage();
        List<ViewScmSaleDeliveryDetails> list = viewScmSaleDeliveryDetailsService.selectViewScmSaleDeliveryDetailsList(viewScmSaleDeliveryDetails);
        return getDataTable(list);
    }

    /**
     * 导出销售发货退货明细报表列表
     */
    @ApiOperation("导出销售发货退货明细报表列表")
    @Log(title = "销售发货退货明细报表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ViewScmSaleDeliveryDetails viewScmSaleDeliveryDetails)
    {
        List<ViewScmSaleDeliveryDetails> list = viewScmSaleDeliveryDetailsService.selectViewScmSaleDeliveryDetailsList(viewScmSaleDeliveryDetails);
        ExcelUtil<ViewScmSaleDeliveryDetails> util = new ExcelUtil<ViewScmSaleDeliveryDetails>(ViewScmSaleDeliveryDetails.class);
        util.exportExcel(response, list, "销售发货退货明细报表数据");
    }

    /**
     * 获取销售发货退货明细报表详细信息
     */
    @ApiOperation("获取销售发货退货明细报表详细信息")
    @GetMapping(value = "/{deliveryId}")
    public BaseResult<ViewScmSaleDeliveryDetails> getInfo(@PathVariable("deliveryId") Long deliveryId)
    {
        return BaseResult.success(viewScmSaleDeliveryDetailsService.selectViewScmSaleDeliveryDetailsByDeliveryId(deliveryId));
    }
}
