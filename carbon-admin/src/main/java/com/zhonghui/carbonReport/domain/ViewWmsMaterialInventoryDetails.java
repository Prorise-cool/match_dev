package com.zhonghui.carbonReport.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 库存明细报表对象 view_wms_material_inventory_details
 * 
 * @author zhonghui
 * @date 2022-05-29
 */
@ApiModel("库存明细报表对象")
public class ViewWmsMaterialInventoryDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仓库id */
    @Excel(name = "仓库id")
    @ApiModelProperty("仓库id")
    private Long warehouseId;

    /** 库区id */
    @Excel(name = "库区id")
    @ApiModelProperty("库区id")
    private Long areaId;

    /** 库位id */
    @Excel(name = "库位id")
    @ApiModelProperty("库位id")
    private Long seatId;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    @ApiModelProperty("生产厂家")
    private String manufacturer;

    /** 生产批号 */
    @Excel(name = "生产批号")
    @ApiModelProperty("生产批号")
    private String batchNumber;

    /** 锁定库存 */
    @Excel(name = "锁定库存")
    @ApiModelProperty("锁定库存")
    private Double lockInventory;

    /** 现有库存 */
    @Excel(name = "现有库存")
    @ApiModelProperty("现有库存")
    private Double existingInventory;

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

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 库存上限 */
    @Excel(name = "库存上限")
    @ApiModelProperty("库存上限")
    private Long inventoryLimit;

    /** 库存下限 */
    @Excel(name = "库存下限")
    @ApiModelProperty("库存下限")
    private Long inventoryLower;

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

    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }
    public void setSeatId(Long seatId) 
    {
        this.seatId = seatId;
    }

    public Long getSeatId() 
    {
        return seatId;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setBatchNumber(String batchNumber) 
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() 
    {
        return batchNumber;
    }
    public void setLockInventory(Double lockInventory)
    {
        this.lockInventory = lockInventory;
    }

    public Double getLockInventory()
    {
        return lockInventory;
    }
    public void setExistingInventory(Double existingInventory)
    {
        this.existingInventory = existingInventory;
    }

    public Double getExistingInventory()
    {
        return existingInventory;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
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
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setInventoryLimit(Long inventoryLimit) 
    {
        this.inventoryLimit = inventoryLimit;
    }

    public Long getInventoryLimit() 
    {
        return inventoryLimit;
    }
    public void setInventoryLower(Long inventoryLower) 
    {
        this.inventoryLower = inventoryLower;
    }

    public Long getInventoryLower() 
    {
        return inventoryLower;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("areaId", getAreaId())
            .append("seatId", getSeatId())
            .append("manufacturer", getManufacturer())
            .append("batchNumber", getBatchNumber())
            .append("lockInventory", getLockInventory())
            .append("existingInventory", getExistingInventory())
            .append("warehouseId", getWarehouseId())
            .append("warehouseName", getWarehouseName())
            .append("areaName", getAreaName())
            .append("seatName", getSeatName())
            .append("materialId", getMaterialId())
            .append("inventoryLimit", getInventoryLimit())
            .append("inventoryLower", getInventoryLower())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .toString();
    }
}
