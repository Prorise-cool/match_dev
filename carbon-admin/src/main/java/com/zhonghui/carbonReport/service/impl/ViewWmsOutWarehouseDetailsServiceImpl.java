package com.zhonghui.carbonReport.service.impl;

import com.zhonghui.carbonReport.domain.ViewWmsOutWarehouseDetails;
import com.zhonghui.carbonReport.mapper.ViewWmsOutWarehouseDetailsMapper;
import com.zhonghui.carbonReport.service.IViewWmsOutWarehouseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 物料出库明细报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
@Service
public class ViewWmsOutWarehouseDetailsServiceImpl implements IViewWmsOutWarehouseDetailsService 
{
    @Autowired
    private ViewWmsOutWarehouseDetailsMapper viewWmsOutWarehouseDetailsMapper;

    /**
     * 查询物料出库明细报表
     * 
     * @param materialId 物料出库明细报表主键
     * @return 物料出库明细报表
     */
    @Override
    public ViewWmsOutWarehouseDetails selectViewWmsOutWarehouseDetailsByMaterialId(Long materialId)
    {
        return viewWmsOutWarehouseDetailsMapper.selectViewWmsOutWarehouseDetailsByMaterialId(materialId);
    }

    /**
     * 查询物料出库明细报表列表
     * 
     * @param viewWmsOutWarehouseDetails 物料出库明细报表
     * @return 物料出库明细报表
     */
    @Override
    public List<ViewWmsOutWarehouseDetails> selectViewWmsOutWarehouseDetailsList(ViewWmsOutWarehouseDetails viewWmsOutWarehouseDetails)
    {
        return viewWmsOutWarehouseDetailsMapper.selectViewWmsOutWarehouseDetailsList(viewWmsOutWarehouseDetails);
    }
}
