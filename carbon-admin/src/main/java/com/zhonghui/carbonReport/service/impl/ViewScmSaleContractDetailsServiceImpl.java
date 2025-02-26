package com.zhonghui.carbonReport.service.impl;

import com.zhonghui.carbonReport.domain.RepContractDeliveryReturnDetail;
import com.zhonghui.carbonReport.domain.ViewScmSaleContractDetails;
import com.zhonghui.carbonReport.mapper.ViewScmSaleContractDetailsMapper;
import com.zhonghui.carbonReport.service.IViewScmSaleContractDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 销售合同明细报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Service
public class ViewScmSaleContractDetailsServiceImpl implements IViewScmSaleContractDetailsService 
{
    @Autowired
    private ViewScmSaleContractDetailsMapper viewScmSaleContractDetailsMapper;

    /**
     * 查询销售合同明细报表列表
     * 
     * @param viewScmSaleContractDetails 销售合同明细报表
     * @return 销售合同明细报表
     */
    @Override
    public List<ViewScmSaleContractDetails> selectViewScmSaleContractDetailsList(ViewScmSaleContractDetails viewScmSaleContractDetails)
    {
        return viewScmSaleContractDetailsMapper.selectViewScmSaleContractDetailsList(viewScmSaleContractDetails);
    }

    /**
     * 查询销售台账报表
     *
     * @param viewScmSaleContractDetails 销售合同明细
     * @return 销售合同明细
     */
    @Override
    public List<ViewScmSaleContractDetails> selectSaleBookReport(ViewScmSaleContractDetails viewScmSaleContractDetails) {
        return viewScmSaleContractDetailsMapper.selectSaleBookReport(viewScmSaleContractDetails);
    }


    /**
     * 按月份统计销售-发货-退货报表
     *
     * @param repContractDeliveryReturnDetail 销售-发货-退货报表实体
     * @return 销售-发货-退货报表实体
     */
    @Override
    public List<RepContractDeliveryReturnDetail> selectContractDeliveryReturnMonthReport(RepContractDeliveryReturnDetail repContractDeliveryReturnDetail){
        return viewScmSaleContractDetailsMapper.selectContractDeliveryReturnMonthReport(repContractDeliveryReturnDetail);
    }


    /**
     * 按季度统计销售-发货-退货报表
     *
     * @param repContractDeliveryReturnDetail 销售-发货-退货报表实体
     * @return 销售-发货-退货报表实体
     */
    @Override
    public List<RepContractDeliveryReturnDetail> selectContractDeliveryReturnQuarterReport(RepContractDeliveryReturnDetail repContractDeliveryReturnDetail){
        return viewScmSaleContractDetailsMapper.selectContractDeliveryReturnQuarterReport(repContractDeliveryReturnDetail);
    }
}
