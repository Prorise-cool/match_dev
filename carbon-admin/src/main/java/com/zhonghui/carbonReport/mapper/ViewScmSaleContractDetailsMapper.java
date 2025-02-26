package com.zhonghui.carbonReport.mapper;

import com.zhonghui.carbonReport.domain.RepContractDeliveryReturnDetail;
import com.zhonghui.carbonReport.domain.ViewScmSaleContractDetails;

import java.util.List;

/**
 * 销售合同明细报表Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface ViewScmSaleContractDetailsMapper 
{
    /**
     * 查询销售合同明细报表列表
     * 
     * @param viewScmSaleContractDetails 销售合同明细报表
     * @return 销售合同明细报表集合
     */
    public List<ViewScmSaleContractDetails> selectViewScmSaleContractDetailsList(ViewScmSaleContractDetails viewScmSaleContractDetails);

    /**
     * 查询销售合同明细列表
     *
     * @param viewScmSaleContractDetails 销售合同明细
     * @return 销售合同明细集合
     */
    public List<ViewScmSaleContractDetails> selectSaleBookReport(ViewScmSaleContractDetails viewScmSaleContractDetails);

    /**
     * 按月份统计销售-发货-退货报表
     *
     * @param repContractDeliveryReturnDetail 销售-发货-退货报表实体
     * @return 销售-发货-退货报表实体
     */
    public List<RepContractDeliveryReturnDetail> selectContractDeliveryReturnMonthReport(RepContractDeliveryReturnDetail repContractDeliveryReturnDetail);

    /**
     * 按季度统计销售-发货-退货报表
     *
     * @param repContractDeliveryReturnDetail 销售-发货-退货报表实体
     * @return 销售-发货-退货报表实体
     */
    public List<RepContractDeliveryReturnDetail> selectContractDeliveryReturnQuarterReport(RepContractDeliveryReturnDetail repContractDeliveryReturnDetail);
}
