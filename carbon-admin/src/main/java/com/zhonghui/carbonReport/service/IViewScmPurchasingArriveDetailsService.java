package com.zhonghui.carbonReport.service;

import com.zhonghui.carbonReport.domain.ViewScmPurchasingArriveDetails;

import java.util.List;

/**
 * 采购到货详细报表Service接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface IViewScmPurchasingArriveDetailsService 
{
    /**
     * 查询采购到货详细报表列表
     * 
     * @param viewScmPurchasingArriveDetails 采购到货详细报表
     * @return 采购到货详细报表集合
     */
    public List<ViewScmPurchasingArriveDetails> selectViewScmPurchasingArriveDetailsList(ViewScmPurchasingArriveDetails viewScmPurchasingArriveDetails);
}
