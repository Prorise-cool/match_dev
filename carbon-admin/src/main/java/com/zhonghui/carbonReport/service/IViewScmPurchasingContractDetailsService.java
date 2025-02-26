package com.zhonghui.carbonReport.service;

import com.zhonghui.carbonReport.domain.ScmContractArriveReturnDetail;
import com.zhonghui.carbonReport.domain.ViewScmPurchasingContractDetails;

import java.util.List;

/**
 * 采购合同明细报表Service接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface IViewScmPurchasingContractDetailsService 
{
    /**
     * 查询采购合同明细报表列表
     * 
     * @param viewScmPurchasingContractDetails 采购合同明细报表
     * @return 采购合同明细报表集合
     */
    public List<ViewScmPurchasingContractDetails> selectViewScmPurchasingContractDetailsList(ViewScmPurchasingContractDetails viewScmPurchasingContractDetails);

    /**
     * 按月份统计采购-入库-退货报表
     *
     * @param scmContractArriveReturnDetail 采购-入库-退货报表实体
     * @return 采购-入库-退货报表实体
     */
    List<ScmContractArriveReturnDetail> selectContractArriveReturnMonthReport(ScmContractArriveReturnDetail scmContractArriveReturnDetail);

    /**
     * 按季度统计采购-入库-退货报表
     *
     * @param scmContractArriveReturnDetail 采购-入库-退货报表实体
     * @return 采购-入库-退货报表实体
     */
    List<ScmContractArriveReturnDetail> selectContractArriveReturnQuarterReport(ScmContractArriveReturnDetail scmContractArriveReturnDetail);
}
