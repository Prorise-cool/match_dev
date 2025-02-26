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
 * 入库明细报表对象 view_wms_in_warehouse_details
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
@ApiModel("入库明细报表对象")
public class ViewWmsInWarehouseDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料ID */
    @Excel(name = "物料ID")
    @ApiModelProperty("物料ID")
    private Long materialId;

    /** 仓库ID */
    @Excel(name = "仓库ID")
    @ApiModelProperty("仓库ID")
    private Long warehouseId;

    /** 库区ID */
    @Excel(name = "库区ID")
    @ApiModelProperty("库区ID")
    private Long warehouseAreaId;

    /** 库位ID */
    @Excel(name = "库位ID")
    @ApiModelProperty("库位ID")
    private Long warehouseSeatId;

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

    /** 入库数量 */
    @Excel(name = "入库数量")
    @ApiModelProperty("入库数量")
    private Double receiptNum;

    /** 业务类型 */
    @Excel(name = "业务类型")
    @ApiModelProperty("业务类型")
    private Integer businessType;

    /** 申请日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请日期", width = 30, dateFormat = "yyyy-MM-dd")
    @ApiModelProperty("申请日期")
    private Date applicationDate;

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
    public void setReceiptNum(Double receiptNum) 
    {
        this.receiptNum = receiptNum;
    }

    public Double getReceiptNum() 
    {
        return receiptNum;
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
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("warehouseId", getWarehouseId())
            .append("warehouseAreaId", getWarehouseAreaId())
            .append("warehouseSeatId", getWarehouseSeatId())
            .append("batchNumber", getBatchNumber())
            .append("warehouseName", getWarehouseName())
            .append("areaName", getAreaName())
            .append("seatName", getSeatName())
            .append("receiptNum", getReceiptNum())
            .append("businessType", getBusinessType())
            .append("applicationDate", getApplicationDate())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("materialId", getMaterialId())
            .toString();
    }
}
