package com.zhonghui.carbonReport.mapper;

import com.zhonghui.carbonReport.domain.ViewWmsMaterialInventoryDetails;

import java.util.List;

/**
 * 库存明细报表Mapper接口
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
public interface ViewWmsMaterialInventoryDetailsMapper 
{
    /**
     * 查询库存明细报表
     * 
     * @param warehouseId 库存明细报表主键
     * @return 库存明细报表
     */
    public ViewWmsMaterialInventoryDetails selectViewWmsMaterialInventoryDetailsById(Long warehouseId);

    /**
     * 查询库存明细报表列表
     * 
     * @param viewWmsMaterialInventoryDetails 库存明细报表
     * @return 库存明细报表集合
     */
    public List<ViewWmsMaterialInventoryDetails> selectViewWmsMaterialInventoryDetailsList(ViewWmsMaterialInventoryDetails viewWmsMaterialInventoryDetails);
}
