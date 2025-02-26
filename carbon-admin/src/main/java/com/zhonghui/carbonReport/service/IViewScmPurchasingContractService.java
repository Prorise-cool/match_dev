package com.zhonghui.carbonReport.service;

import com.zhonghui.carbonReport.domain.ViewScmPurchasingContract;

import java.util.List;

/**
 * 采购合同报表Service接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface IViewScmPurchasingContractService 
{
    /**
     * 查询采购合同报表
     * 
     * @param contractId 采购合同报表主键
     * @return 采购合同报表
     */
    public ViewScmPurchasingContract selectViewScmPurchasingContractByContractId(Long contractId);

    /**
     * 查询采购合同报表列表
     * 
     * @param viewScmPurchasingContract 采购合同报表
     * @return 采购合同报表集合
     */
    public List<ViewScmPurchasingContract> selectViewScmPurchasingContractList(ViewScmPurchasingContract viewScmPurchasingContract);

    /**
     * 按月份统计
     *
     * @param viewScmPurchasingContract 采购合同报表
     * @return 采购合同报表集合
     */
    public List<ViewScmPurchasingContract> selectMonthReport(ViewScmPurchasingContract viewScmPurchasingContract);

    /**
     * 按季度份统计
     *
     * @param viewScmPurchasingContract 采购合同报表
     * @return 采购合同报表集合
     */
    public List<ViewScmPurchasingContract> selectQuarterReport(ViewScmPurchasingContract viewScmPurchasingContract);


    /**
     * 按月份统计供应商对账
     *
     * @param viewScmPurchasingContract 采购合同报表
     * @return 采购合同报表集合
     */
    public List<ViewScmPurchasingContract> selectMonthSupplierReport(ViewScmPurchasingContract viewScmPurchasingContract);

    /**
     * 按季度统计供应商对账
     *
     * @param viewScmPurchasingContract 采购合同报表
     * @return 采购合同报表集合
     */
    public List<ViewScmPurchasingContract> selectQuarterSupplierReport(ViewScmPurchasingContract viewScmPurchasingContract);
}
