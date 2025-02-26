package com.zhonghui.carbonReport.service.impl;

import com.zhonghui.carbonReport.domain.ViewScmPurchasingContract;
import com.zhonghui.carbonReport.mapper.ViewScmPurchasingContractMapper;
import com.zhonghui.carbonReport.service.IViewScmPurchasingContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购合同报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Service
public class ViewScmPurchasingContractServiceImpl implements IViewScmPurchasingContractService 
{
    @Autowired
    private ViewScmPurchasingContractMapper viewScmPurchasingContractMapper;

    /**
     * 查询采购合同报表
     * 
     * @param contractId 采购合同报表主键
     * @return 采购合同报表
     */
    @Override
    public ViewScmPurchasingContract selectViewScmPurchasingContractByContractId(Long contractId)
    {
        return viewScmPurchasingContractMapper.selectViewScmPurchasingContractByContractId(contractId);
    }

    /**
     * 查询采购合同报表列表
     * 
     * @param viewScmPurchasingContract 采购合同报表
     * @return 采购合同报表
     */
    @Override
    public List<ViewScmPurchasingContract> selectViewScmPurchasingContractList(ViewScmPurchasingContract viewScmPurchasingContract)
    {
        return viewScmPurchasingContractMapper.selectViewScmPurchasingContractList(viewScmPurchasingContract);
    }

    /**
     * 按月份统计
     *
     * @param viewScmPurchasingContract 采购合同报表
     * @return 采购合同报表集合
     */
    @Override
    public List<ViewScmPurchasingContract> selectMonthReport(ViewScmPurchasingContract viewScmPurchasingContract) {
        return viewScmPurchasingContractMapper.selectMonthReport(viewScmPurchasingContract);
    }

    /**
     * 按季度份统计
     *
     * @param viewScmPurchasingContract 采购合同报表
     * @return 采购合同报表集合
     */
    @Override
    public List<ViewScmPurchasingContract> selectQuarterReport(ViewScmPurchasingContract viewScmPurchasingContract){
        return viewScmPurchasingContractMapper.selectQuarterReport(viewScmPurchasingContract);
    }
    /**
     * 按月份统计供应商对账
     *
     * @param viewScmPurchasingContract 采购合同报表
     * @return 采购合同报表集合
     */
    @Override
    public List<ViewScmPurchasingContract> selectMonthSupplierReport(ViewScmPurchasingContract viewScmPurchasingContract) {
        return viewScmPurchasingContractMapper.selectMonthSupplierReport(viewScmPurchasingContract);
    }

    /**
     * 按季度统计供应商对账
     *
     * @param viewScmPurchasingContract 采购合同报表
     * @return 采购合同报表集合
     */
    @Override
    public List<ViewScmPurchasingContract> selectQuarterSupplierReport(ViewScmPurchasingContract viewScmPurchasingContract){
        return viewScmPurchasingContractMapper.selectQuarterSupplierReport(viewScmPurchasingContract);
    }
}
