package com.zhonghui.carbonReport.service.impl;

import com.zhonghui.carbonReport.domain.ScmContractArriveReturnDetail;
import com.zhonghui.carbonReport.domain.ViewScmPurchasingContractDetails;
import com.zhonghui.carbonReport.mapper.ViewScmPurchasingContractDetailsMapper;
import com.zhonghui.carbonReport.service.IViewScmPurchasingContractDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购合同明细报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Service
public class ViewScmPurchasingContractDetailsServiceImpl implements IViewScmPurchasingContractDetailsService 
{
    @Autowired
    private ViewScmPurchasingContractDetailsMapper viewScmPurchasingContractDetailsMapper;

    /**
     * 查询采购合同明细报表列表
     * 
     * @param viewScmPurchasingContractDetails 采购合同明细报表
     * @return 采购合同明细报表
     */
    @Override
    public List<ViewScmPurchasingContractDetails> selectViewScmPurchasingContractDetailsList(ViewScmPurchasingContractDetails viewScmPurchasingContractDetails)
    {
        return viewScmPurchasingContractDetailsMapper.selectViewScmPurchasingContractDetailsList(viewScmPurchasingContractDetails);
    }

    /**
     * 按月份统计采购-入库-退货报表
     *
     * @param scmContractArriveReturnDetail 采购-入库-退货报表实体
     * @return 采购-入库-退货报表实体
     */
    @Override
    public List<ScmContractArriveReturnDetail> selectContractArriveReturnMonthReport(ScmContractArriveReturnDetail scmContractArriveReturnDetail) {
        return viewScmPurchasingContractDetailsMapper.selectContractArriveReturnMonthReport(scmContractArriveReturnDetail);
    }

    /**
     * 按季度统计采购-入库-退货报表
     *
     * @param scmContractArriveReturnDetail 采购-入库-退货报表实体
     * @return 采购-入库-退货报表实体
     */
    @Override
    public List<ScmContractArriveReturnDetail> selectContractArriveReturnQuarterReport(ScmContractArriveReturnDetail scmContractArriveReturnDetail) {
        return viewScmPurchasingContractDetailsMapper.selectContractArriveReturnQuarterReport(scmContractArriveReturnDetail);
    }
}
