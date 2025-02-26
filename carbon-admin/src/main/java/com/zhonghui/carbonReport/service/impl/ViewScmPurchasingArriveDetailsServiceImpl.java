package com.zhonghui.carbonReport.service.impl;

import com.zhonghui.carbonReport.domain.ViewScmPurchasingArriveDetails;
import com.zhonghui.carbonReport.mapper.ViewScmPurchasingArriveDetailsMapper;
import com.zhonghui.carbonReport.service.IViewScmPurchasingArriveDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 采购到货详细报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@Service
public class ViewScmPurchasingArriveDetailsServiceImpl implements IViewScmPurchasingArriveDetailsService 
{
    @Autowired
    private ViewScmPurchasingArriveDetailsMapper viewScmPurchasingArriveDetailsMapper;

    /**
     * 查询采购到货详细报表列表
     * 
     * @param viewScmPurchasingArriveDetails 采购到货详细报表
     * @return 采购到货详细报表
     */
    @Override
    public List<ViewScmPurchasingArriveDetails> selectViewScmPurchasingArriveDetailsList(ViewScmPurchasingArriveDetails viewScmPurchasingArriveDetails)
    {
        return viewScmPurchasingArriveDetailsMapper.selectViewScmPurchasingArriveDetailsList(viewScmPurchasingArriveDetails);
    }
}
