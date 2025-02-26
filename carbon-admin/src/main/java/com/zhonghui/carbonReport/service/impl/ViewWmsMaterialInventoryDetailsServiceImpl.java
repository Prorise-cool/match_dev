package com.zhonghui.carbonReport.service.impl;

import com.zhonghui.carbonReport.domain.ViewWmsMaterialInventoryDetails;
import com.zhonghui.carbonReport.mapper.ViewWmsMaterialInventoryDetailsMapper;
import com.zhonghui.carbonReport.service.IViewWmsMaterialInventoryDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库存明细报表Service业务层处理
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
@Service
public class ViewWmsMaterialInventoryDetailsServiceImpl implements IViewWmsMaterialInventoryDetailsService 
{
    @Autowired
    private ViewWmsMaterialInventoryDetailsMapper viewWmsMaterialInventoryDetailsMapper;

    /**
     * 查询库存明细报表
     * 
     * @param warehouseId 库存明细报表主键
     * @return 库存明细报表
     */
    @Override
    public ViewWmsMaterialInventoryDetails selectViewWmsMaterialInventoryDetailsById(Long warehouseId)
    {
        return viewWmsMaterialInventoryDetailsMapper.selectViewWmsMaterialInventoryDetailsById(warehouseId);
    }

    /**
     * 查询库存明细报表列表
     * 
     * @param viewWmsMaterialInventoryDetails 库存明细报表
     * @return 库存明细报表
     */
    @Override
    public List<ViewWmsMaterialInventoryDetails> selectViewWmsMaterialInventoryDetailsList(ViewWmsMaterialInventoryDetails viewWmsMaterialInventoryDetails)
    {
        return viewWmsMaterialInventoryDetailsMapper.selectViewWmsMaterialInventoryDetailsList(viewWmsMaterialInventoryDetails);
    }
}
