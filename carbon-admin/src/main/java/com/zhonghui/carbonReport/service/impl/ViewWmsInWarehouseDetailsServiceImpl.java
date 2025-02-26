package com.zhonghui.carbonReport.service.impl;

import com.zhonghui.carbonReport.domain.ViewWmsInWarehouseDetails;
import com.zhonghui.carbonReport.mapper.ViewWmsInWarehouseDetailsMapper;
import com.zhonghui.carbonReport.service.IViewWmsInWarehouseDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 入库明细报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
@Service
public class ViewWmsInWarehouseDetailsServiceImpl implements IViewWmsInWarehouseDetailsService 
{
    @Autowired
    private ViewWmsInWarehouseDetailsMapper viewWmsInWarehouseDetailsMapper;

    /**
     * 查询入库明细报表
     * 
     * @param materialId 入库明细报表主键
     * @return 入库明细报表
     */
    @Override
    public ViewWmsInWarehouseDetails selectViewWmsInWarehouseDetailsById(Long materialId)
    {
        return viewWmsInWarehouseDetailsMapper.selectViewWmsInWarehouseDetailsById(materialId);
    }

    /**
     * 查询入库明细报表列表
     * 
     * @param viewWmsInWarehouseDetails 入库明细报表
     * @return 入库明细报表
     */
    @Override
    public List<ViewWmsInWarehouseDetails> selectViewWmsInWarehouseDetailsList(ViewWmsInWarehouseDetails viewWmsInWarehouseDetails)
    {
        return viewWmsInWarehouseDetailsMapper.selectViewWmsInWarehouseDetailsList(viewWmsInWarehouseDetails);
    }
}
