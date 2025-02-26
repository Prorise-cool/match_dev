package com.zhonghui.carbonReport.mapper;

import com.zhonghui.carbonReport.domain.ViewScmPurchasingArriveDetails;

import java.util.List;

/**
 * 采购到货详细报表Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface ViewScmPurchasingArriveDetailsMapper 
{
    /**
     * 查询采购到货详细报表列表
     * 
     * @param viewScmPurchasingArriveDetails 采购到货详细报表
     * @return 采购到货详细报表集合
     */
    public List<ViewScmPurchasingArriveDetails> selectViewScmPurchasingArriveDetailsList(ViewScmPurchasingArriveDetails viewScmPurchasingArriveDetails);
}
