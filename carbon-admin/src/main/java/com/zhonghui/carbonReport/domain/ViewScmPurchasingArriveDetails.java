package com.zhonghui.carbonReport.domain;

import com.zhonghui.common.annotation.Excel;
import com.zhonghui.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 采购到货详细报表对象 view_scm_purchasing_arrive_details
 * 
 * @author zhonghui
 * @date 2022-05-28
 */
@ApiModel("采购到货详细报表对象")
public class ViewScmPurchasingArriveDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 到货id */
    @Excel(name = "到货id")
    @ApiModelProperty("到货id")
    private Long purchasingArrivalId;

    /** 物料id */
    @Excel(name = "物料id")
    @ApiModelProperty("物料id")
    private Long materialId;

    /** 生产批号 */
    @Excel(name = "生产批号")
    @ApiModelProperty("生产批号")
    private String batchNumber;

    /** 退货数量 */
    @Excel(name = "退货数量")
    @ApiModelProperty("退货数量")
    private Long returnQuantity;

    /** 到货数量 */
    @Excel(name = "到货数量")
    @ApiModelProperty("到货数量")
    private Long arrivalQuantity;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    @ApiModelProperty("供应商名称")
    private String supplierName;

    /** 物料编码 */
    @Excel(name = "物料编码")
    @ApiModelProperty("物料编码")
    private String materialCode;

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

    /** 单价 */
    @Excel(name = "单价")
    @ApiModelProperty("单价")
    private BigDecimal materialPrice;

    /** 合同编号 */
    @Excel(name = "合同编号")
    @ApiModelProperty("合同编号")
    private String contractNo;

    /** 供应商id */
    @Excel(name = "供应商id")
    @ApiModelProperty("供应商id")
    private Long saleSupplierId;

    /** 入库数量 */
    @Excel(name = "入库数量")
    @ApiModelProperty("入库数量")
    private Long inWarehouseQuantity;

    public void setPurchasingArrivalId(Long purchasingArrivalId) 
    {
        this.purchasingArrivalId = purchasingArrivalId;
    }

    public Long getPurchasingArrivalId() 
    {
        return purchasingArrivalId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setBatchNumber(String batchNumber) 
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() 
    {
        return batchNumber;
    }
    public void setReturnQuantity(Long returnQuantity) 
    {
        this.returnQuantity = returnQuantity;
    }

    public Long getReturnQuantity() 
    {
        return returnQuantity;
    }
    public void setArrivalQuantity(Long arrivalQuantity) 
    {
        this.arrivalQuantity = arrivalQuantity;
    }

    public Long getArrivalQuantity() 
    {
        return arrivalQuantity;
    }
    public void setSupplierName(String supplierName) 
    {
        this.supplierName = supplierName;
    }

    public String getSupplierName() 
    {
        return supplierName;
    }
    public void setMaterialCode(String materialCode) 
    {
        this.materialCode = materialCode;
    }

    public String getMaterialCode() 
    {
        return materialCode;
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
    public void setMaterialPrice(BigDecimal materialPrice) 
    {
        this.materialPrice = materialPrice;
    }

    public BigDecimal getMaterialPrice() 
    {
        return materialPrice;
    }
    public void setContractNo(String contractNo) 
    {
        this.contractNo = contractNo;
    }

    public String getContractNo() 
    {
        return contractNo;
    }
    public void setSaleSupplierId(Long saleSupplierId) 
    {
        this.saleSupplierId = saleSupplierId;
    }

    public Long getSaleSupplierId() 
    {
        return saleSupplierId;
    }
    public void setInWarehouseQuantity(Long inWarehouseQuantity) 
    {
        this.inWarehouseQuantity = inWarehouseQuantity;
    }

    public Long getInWarehouseQuantity() 
    {
        return inWarehouseQuantity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("purchasingArrivalId", getPurchasingArrivalId())
            .append("materialId", getMaterialId())
            .append("batchNumber", getBatchNumber())
            .append("returnQuantity", getReturnQuantity())
            .append("arrivalQuantity", getArrivalQuantity())
            .append("supplierName", getSupplierName())
            .append("materialCode", getMaterialCode())
            .append("materialName", getMaterialName())
            .append("materialModel", getMaterialModel())
            .append("materialSpecifications", getMaterialSpecifications())
            .append("materialUnit", getMaterialUnit())
            .append("materialPrice", getMaterialPrice())
            .append("contractNo", getContractNo())
            .append("saleSupplierId", getSaleSupplierId())
            .append("inWarehouseQuantity", getInWarehouseQuantity())
            .toString();
    }
}
