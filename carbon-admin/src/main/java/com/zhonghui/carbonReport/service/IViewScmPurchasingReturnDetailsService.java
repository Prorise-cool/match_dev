package com.zhonghui.carbonReport.service;

import com.zhonghui.carbonReport.domain.ViewScmPurchasingReturnDetails;

import java.util.List;

/**
 * 采购退货统计Service接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface IViewScmPurchasingReturnDetailsService 
{
    /**
     * 查询采购退货统计列表
     * 
     * @param viewScmPurchasingReturnDetails 采购退货统计
     * @return 采购退货统计集合
     */
    public List<ViewScmPurchasingReturnDetails> selectViewScmPurchasingReturnDetailsList(ViewScmPurchasingReturnDetails viewScmPurchasingReturnDetails);
}
