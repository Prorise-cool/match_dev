package com.zhonghui.carbonReport.mapper;

import com.zhonghui.carbonReport.domain.ViewScmPurchasingReturnDetails;

import java.util.List;

/**
 * 采购退货统计Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
public interface ViewScmPurchasingReturnDetailsMapper 
{
    /**
     * 查询采购退货统计列表
     * 
     * @param viewScmPurchasingReturnDetails 采购退货统计
     * @return 采购退货统计集合
     */
    public List<ViewScmPurchasingReturnDetails> selectViewScmPurchasingReturnDetailsList(ViewScmPurchasingReturnDetails viewScmPurchasingReturnDetails);
}
