package com.zhonghui.carbonReport.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 物料出库明细报表对象 view_wms_out_warehouse_details
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
@ApiModel("物料出库明细报表对象")
public class ViewWmsOutWarehouseDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 仓库编号 */
    @Excel(name = "仓库编号")
    @ApiModelProperty("仓库编号")
    private Long warehouseId;

    /** 库区编号 */
    @Excel(name = "库区编号")
    @ApiModelProperty("库区编号")
    private Long warehouseAreaId;

    /** 库位编号 */
    @Excel(name = "库位编号")
    @ApiModelProperty("库位编号")
    private Long warehouseSeatId;

    /** 出库数量 */
    @Excel(name = "出库数量")
    @ApiModelProperty("出库数量")
    private Double outboundNumber;

    /** 生产批号 */
    @Excel(name = "生产批号")
    @ApiModelProperty("生产批号")
    private String batchNumber;

    /** 仓库名称 */
    @Excel(name = "仓库名称")
    @ApiModelProperty("仓库名称")
    private String warehouseName;

    /** 库区名称 */
    @Excel(name = "库区名称")
    @ApiModelProperty("库区名称")
    private String areaName;

    /** 库位名称 */
    @Excel(name = "库位名称")
    @ApiModelProperty("库位名称")
    private String seatName;

    /** 物料名称 */
    @Excel(name = "物料名称")
    @ApiModelProperty("物料名称")
    private String materialName;

    /** 型号 */
    @Excel(name = "型号")
    @ApiModelProperty("型号")
    private String materialModel;

    /** 规格 */
    @Excel(name = "规格")
    @ApiModelProperty("规格")
    private String materialSpecifications;

    /** 单位 */
    @Excel(name = "单位")
    @ApiModelProperty("单位")
    private String materialUnit;

    /** 业务类型: */
    @Excel(name = "业务类型:")
    @ApiModelProperty("业务类型")
    private Integer businessType;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("申请日期")
    private Date applicationDate;

    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }
    public void setWarehouseAreaId(Long warehouseAreaId) 
    {
        this.warehouseAreaId = warehouseAreaId;
    }

    public Long getWarehouseAreaId() 
    {
        return warehouseAreaId;
    }
    public void setWarehouseSeatId(Long warehouseSeatId) 
    {
        this.warehouseSeatId = warehouseSeatId;
    }

    public Long getWarehouseSeatId() 
    {
        return warehouseSeatId;
    }
    public void setOutboundNumber(Double outboundNumber) 
    {
        this.outboundNumber = outboundNumber;
    }

    public Double getOutboundNumber() 
    {
        return outboundNumber;
    }
    public void setBatchNumber(String batchNumber) 
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() 
    {
        return batchNumber;
    }
    public void setWarehouseName(String warehouseName) 
    {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseName() 
    {
        return warehouseName;
    }
    public void setAreaName(String areaName) 
    {
        this.areaName = areaName;
    }

    public String getAreaName() 
    {
        return areaName;
    }
    public void setSeatName(String seatName) 
    {
        this.seatName = seatName;
    }

    public String getSeatName() 
    {
        return seatName;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setMaterialModel(String materialModel) 
    {
        this.materialModel = materialModel;
    }

    public String getMaterialModel() 
    {
        return materialModel;
    }
    public void setMaterialSpecifications(String materialSpecifications) 
    {
        this.materialSpecifications = materialSpecifications;
    }

    public String getMaterialSpecifications() 
    {
        return materialSpecifications;
    }
    public void setMaterialUnit(String materialUnit) 
    {
        this.materialUnit = materialUnit;
    }

    public String getMaterialUnit() 
    {
        return materialUnit;
    }
    public void setBusinessType(Integer businessType) 
    {
        this.businessType = businessType;
    }

    public Integer getBusinessType() 
    {
        return businessType;
    }
    public void setApplicationDate(Date applicationDate) 
    {
        this.applicationDate = applicationDate;
    }

    public Date getApplicationDate() 
    {
        return applicationDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("materialId", getMaterialId())
            .append("warehouseId", getWarehouseId())
            .append("warehouseAreaId", getWarehouseAreaId())
            .append("warehouseSeatId", getWarehouseSeatId())
            .append("outboundNumber", getOutboundNumber())
            .append("batchNumber", getBatchNumber())
            .append("warehouseName", getWarehouseName())
            .append("areaName", getAreaName())
            .append("seatName", getSeatName())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("businessType", getBusinessType())
            .append("applicationDate", getApplicationDate())
            .toString();
    }
}
