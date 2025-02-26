package com.zhonghui.carbonReport.mapper;

import com.zhonghui.carbonReport.domain.ViewWmsInWarehouseDetails;

import java.util.List;

/**
 * 入库明细报表Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
public interface ViewWmsInWarehouseDetailsMapper 
{
    /**
     * 查询入库明细报表
     * 
     * @param materialId 入库明细报表主键
     * @return 入库明细报表
     */
    public ViewWmsInWarehouseDetails selectViewWmsInWarehouseDetailsById(Long materialId);

    /**
     * 查询入库明细报表列表
     * 
     * @param viewWmsInWarehouseDetails 入库明细报表
     * @return 入库明细报表集合
     */
    public List<ViewWmsInWarehouseDetails> selectViewWmsInWarehouseDetailsList(ViewWmsInWarehouseDetails viewWmsInWarehouseDetails);
}
