package com.zhonghui.carbonReport.service.impl;

import com.zhonghui.carbonReport.domain.ViewScmPurchasingReturnDetails;
import com.zhonghui.carbonReport.mapper.ViewScmPurchasingReturnDetailsMapper;
import com.zhonghui.carbonReport.service.IViewScmPurchasingReturnDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购退货统计Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Service
public class ViewScmPurchasingReturnDetailsServiceImpl implements IViewScmPurchasingReturnDetailsService 
{
    @Autowired
    private ViewScmPurchasingReturnDetailsMapper viewScmPurchasingReturnDetailsMapper;

    /**
     * 查询采购退货统计列表
     * 
     * @param viewScmPurchasingReturnDetails 采购退货统计
     * @return 采购退货统计
     */
    @Override
    public List<ViewScmPurchasingReturnDetails> selectViewScmPurchasingReturnDetailsList(ViewScmPurchasingReturnDetails viewScmPurchasingReturnDetails)
    {
        return viewScmPurchasingReturnDetailsMapper.selectViewScmPurchasingReturnDetailsList(viewScmPurchasingReturnDetails);
    }
}
