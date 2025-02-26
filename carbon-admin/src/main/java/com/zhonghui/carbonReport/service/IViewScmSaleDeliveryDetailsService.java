package com.zhonghui.carbonReport.service;

import com.zhonghui.carbonReport.domain.ViewScmSaleDeliveryDetails;

import java.util.List;

/**
 * 销售发货退货明细报表Service接口
 * 
 * @author zhonghui
 * @date 2022-05-25
 */
public interface IViewScmSaleDeliveryDetailsService 
{
    /**
     * 查询销售发货退货明细报表
     * 
     * @param deliveryId 销售发货退货明细报表主键
     * @return 销售发货退货明细报表
     */
    public ViewScmSaleDeliveryDetails selectViewScmSaleDeliveryDetailsByDeliveryId(Long deliveryId);

    /**
     * 查询销售发货退货明细报表列表
     * 
     * @param viewScmSaleDeliveryDetails 销售发货退货明细报表
     * @return 销售发货退货明细报表集合
     */
    public List<ViewScmSaleDeliveryDetails> selectViewScmSaleDeliveryDetailsList(ViewScmSaleDeliveryDetails viewScmSaleDeliveryDetails);

    /**
     * 新增销售发货退货明细报表
     * 
     * @param viewScmSaleDeliveryDetails 销售发货退货明细报表
     * @return 结果
     */
    public int insertViewScmSaleDeliveryDetails(ViewScmSaleDeliveryDetails viewScmSaleDeliveryDetails);

    /**
     * 修改销售发货退货明细报表
     * 
     * @param viewScmSaleDeliveryDetails 销售发货退货明细报表
     * @return 结果
     */
    public int updateViewScmSaleDeliveryDetails(ViewScmSaleDeliveryDetails viewScmSaleDeliveryDetails);

    /**
     * 批量删除销售发货退货明细报表
     * 
     * @param deliveryIds 需要删除的销售发货退货明细报表主键集合
     * @return 结果
     */
    public int deleteViewScmSaleDeliveryDetailsByDeliveryIds(Long[] deliveryIds);

    /**
     * 删除销售发货退货明细报表信息
     * 
     * @param deliveryId 销售发货退货明细报表主键
     * @return 结果
     */
    public int deleteViewScmSaleDeliveryDetailsByDeliveryId(Long deliveryId);
}
