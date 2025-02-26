package com.zhonghui.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhonghui.wms.mapper.WmsOutboundApplicationMapper;
import com.zhonghui.wms.domain.WmsOutboundApplication;
import com.zhonghui.wms.service.IWmsOutboundApplicationService;

/**
 * 智能仓储WMS-出库申请Service业务层处理
 * 
 * @author zhonghui
 * @date 2025-02-26
 */
@Service
public class WmsOutboundApplicationServiceImpl implements IWmsOutboundApplicationService 
{
    @Autowired
    private WmsOutboundApplicationMapper wmsOutboundApplicationMapper;

    /**
     * 查询智能仓储WMS-出库申请
     * 
     * @param id 智能仓储WMS-出库申请主键
     * @return 智能仓储WMS-出库申请
     */
    @Override
    public WmsOutboundApplication selectWmsOutboundApplicationById(Long id)
    {
        return wmsOutboundApplicationMapper.selectWmsOutboundApplicationById(id);
    }

    /**
     * 查询智能仓储WMS-出库申请列表
     * 
     * @param wmsOutboundApplication 智能仓储WMS-出库申请
     * @return 智能仓储WMS-出库申请
     */
    @Override
    public List<WmsOutboundApplication> selectWmsOutboundApplicationList(WmsOutboundApplication wmsOutboundApplication)
    {
        return wmsOutboundApplicationMapper.selectWmsOutboundApplicationList(wmsOutboundApplication);
    }

    /**
     * 新增智能仓储WMS-出库申请
     * 
     * @param wmsOutboundApplication 智能仓储WMS-出库申请
     * @return 结果
     */
    @Override
    public int insertWmsOutboundApplication(WmsOutboundApplication wmsOutboundApplication)
    {
        return wmsOutboundApplicationMapper.insertWmsOutboundApplication(wmsOutboundApplication);
    }

    /**
     * 修改智能仓储WMS-出库申请
     * 
     * @param wmsOutboundApplication 智能仓储WMS-出库申请
     * @return 结果
     */
    @Override
    public int updateWmsOutboundApplication(WmsOutboundApplication wmsOutboundApplication)
    {
        return wmsOutboundApplicationMapper.updateWmsOutboundApplication(wmsOutboundApplication);
    }

    /**
     * 批量删除智能仓储WMS-出库申请
     * 
     * @param ids 需要删除的智能仓储WMS-出库申请主键
     * @return 结果
     */
    @Override
    public int deleteWmsOutboundApplicationByIds(Long[] ids)
    {
        return wmsOutboundApplicationMapper.deleteWmsOutboundApplicationByIds(ids);
    }

    /**
     * 删除智能仓储WMS-出库申请信息
     * 
     * @param id 智能仓储WMS-出库申请主键
     * @return 结果
     */
    @Override
    public int deleteWmsOutboundApplicationById(Long id)
    {
        return wmsOutboundApplicationMapper.deleteWmsOutboundApplicationById(id);
    }
}
