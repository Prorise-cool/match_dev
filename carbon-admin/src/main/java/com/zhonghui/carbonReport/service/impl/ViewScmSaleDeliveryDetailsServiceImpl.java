package com.zhonghui.carbonReport.service.impl;

import com.zhonghui.carbonReport.domain.ViewScmSaleDeliveryDetails;
import com.zhonghui.carbonReport.mapper.ViewScmSaleDeliveryDetailsMapper;
import com.zhonghui.carbonReport.service.IViewScmSaleDeliveryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 销售发货退货明细报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
@Service
public class ViewScmSaleDeliveryDetailsServiceImpl implements IViewScmSaleDeliveryDetailsService 
{
    @Autowired
    private ViewScmSaleDeliveryDetailsMapper viewScmSaleDeliveryDetailsMapper;

    /**
     * 查询销售发货退货明细报表
     * 
     * @param deliveryId 销售发货退货明细报表主键
     * @return 销售发货退货明细报表
     */
    @Override
    public ViewScmSaleDeliveryDetails selectViewScmSaleDeliveryDetailsByDeliveryId(Long deliveryId)
    {
        return viewScmSaleDeliveryDetailsMapper.selectViewScmSaleDeliveryDetailsByDeliveryId(deliveryId);
    }

    /**
     * 查询销售发货退货明细报表列表
     * 
     * @param viewScmSaleDeliveryDetails 销售发货退货明细报表
     * @return 销售发货退货明细报表
     */
    @Override
    public List<ViewScmSaleDeliveryDetails> selectViewScmSaleDeliveryDetailsList(ViewScmSaleDeliveryDetails viewScmSaleDeliveryDetails)
    {
        return viewScmSaleDeliveryDetailsMapper.selectViewScmSaleDeliveryDetailsList(viewScmSaleDeliveryDetails);
    }

    /**
     * 新增销售发货退货明细报表
     * 
     * @param viewScmSaleDeliveryDetails 销售发货退货明细报表
     * @return 结果
     */
    @Override
    public int insertViewScmSaleDeliveryDetails(ViewScmSaleDeliveryDetails viewScmSaleDeliveryDetails)
    {
        return viewScmSaleDeliveryDetailsMapper.insertViewScmSaleDeliveryDetails(viewScmSaleDeliveryDetails);
    }

    /**
     * 修改销售发货退货明细报表
     * 
     * @param viewScmSaleDeliveryDetails 销售发货退货明细报表
     * @return 结果
     */
    @Override
    public int updateViewScmSaleDeliveryDetails(ViewScmSaleDeliveryDetails viewScmSaleDeliveryDetails)
    {
        return viewScmSaleDeliveryDetailsMapper.updateViewScmSaleDeliveryDetails(viewScmSaleDeliveryDetails);
    }

    /**
     * 批量删除销售发货退货明细报表
     * 
     * @param deliveryIds 需要删除的销售发货退货明细报表主键
     * @return 结果
     */
    @Override
    public int deleteViewScmSaleDeliveryDetailsByDeliveryIds(Long[] deliveryIds)
    {
        return viewScmSaleDeliveryDetailsMapper.deleteViewScmSaleDeliveryDetailsByDeliveryIds(deliveryIds);
    }

    /**
     * 删除销售发货退货明细报表信息
     * 
     * @param deliveryId 销售发货退货明细报表主键
     * @return 结果
     */
    @Override
    public int deleteViewScmSaleDeliveryDetailsByDeliveryId(Long deliveryId)
    {
        return viewScmSaleDeliveryDetailsMapper.deleteViewScmSaleDeliveryDetailsByDeliveryId(deliveryId);
    }
}
