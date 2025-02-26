package com.zhonghui.carbonReport.mapper;

import com.zhonghui.carbonReport.domain.ViewWmsOutWarehouseDetails;

import java.util.List;

/**
 * 物料出库明细报表Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
public interface ViewWmsOutWarehouseDetailsMapper 
{
    /**
     * 查询物料出库明细报表
     * 
     * @param materialId 物料出库明细报表主键
     * @return 物料出库明细报表
     */
    public ViewWmsOutWarehouseDetails selectViewWmsOutWarehouseDetailsByMaterialId(Long materialId);

    /**
     * 查询物料出库明细报表列表
     * 
     * @param viewWmsOutWarehouseDetails 物料出库明细报表
     * @return 物料出库明细报表集合
     */
    public List<ViewWmsOutWarehouseDetails> selectViewWmsOutWarehouseDetailsList(ViewWmsOutWarehouseDetails viewWmsOutWarehouseDetails);
}
